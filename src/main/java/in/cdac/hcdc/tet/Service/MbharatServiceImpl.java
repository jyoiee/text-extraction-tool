package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.MbharatDao;
import in.cdac.hcdc.tet.Models.Verse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jyoti
 */
@Service
@Transactional
public class MbharatServiceImpl implements MbharatService {

    @Autowired
    public MbharatDao dao;

    @Autowired
    private UtilityMethods utility;

    @Override
    public String extract(String url) {
        try {
            Document doc = Jsoup.connect(url).timeout(50000).get();
            Pattern pattern = Pattern.compile("(<hr>)");            //To get subchapters full contents 

            Pattern pattern1 = Pattern.compile("([\\p{IsL}\\p{IsM}]{1,4}[||]{2})"); // to get speakers for other language

            Pattern pattern2 = Pattern.compile("[\\p{IsN}]{1,4}");     // To get subchapter number and name

            Pattern pattern3 = Pattern.compile("(([||]{2})[ ]?\\p{IsN}{1,}+([||]{2}))"); // to get verses which are in ||123|| this form for other language

            Pattern pattern4 = Pattern.compile("(([|]{1})([ ]+\\p{IsN}{1,}+[ ]+)([|]{1}))"); //to get verses which are in | 123 | form  | ०८४ | for other language  

      //      Pattern pattern1 = Pattern.compile("([\\p{IsL}\\p{IsM}]{1,3}[\\u0965]{1})"); // to get speakers omnly for devnagari
        //     Pattern pattern2 = Pattern.compile("[\\p{IsN}]{1,4}");     // To get subchapter number and name
      //       Pattern pattern3 = Pattern.compile("([\\u0965]{1}[ ]?\\p{IsN}{1,}+[ ]?\\u0965)"); // to get verses which are in ||123|| this form for Devnagari only 
       //     Pattern pattern4 = Pattern.compile("([\\u0964]{1}[ ]+\\p{IsN}{1,}[ ]+[\\u0964]{1})"); //to get verses which are in | 123 | form  | ०८४ | only for devnagari
            //List<String> speakers = new ArrayList<String>();  // reqired for first time
            
            List<String> speakers = dao.getSpeakerList();

            Elements chapterDetails = (Elements) doc.select("ul li a");    //geting chaper url here with html tag  
            Long speaker_id = 1L;

           for (Element element : chapterDetails.subList(0, 18)) {          
             String prefix = "http://www.virtualvinodh.com/aksharamkh/aksharamukha-web.php?website=";
             String chapterUrl = element.attr("href");
             
            // String subUrl = "&src=devanagari&tgt=devanagari"; //for devnagiri
               String subUrl = "&src=devanagari&tgt=gujarati";  // FOR gujrati
             //  String subUrl = "&src=devanagari&tgt=tamil";         //for Tamil
             String CompUrl = prefix + chapterUrl + subUrl;  
            
          //  String CompUrl = "https://sanskritdocuments.org/mirrors/mahabharata/unic/mbh18_sa.html"; // this is for sanskrit only
              
            System.out.println(" @@@@@@@@@ COMPLETE URL @@@@@@@@@" + CompUrl);
            Document docs = Jsoup.connect(CompUrl).maxBodySize(0).timeout(500000).get();

            Elements chapterName = docs.select("pre ul font h2");

            String chaptername = chapterName.html();

            Elements chapterContents = docs.select("pre ul font");

            String content = chapterContents.html();                //getting full content
            String con = content.substring(38);
            Long cid = dao.saveChapter(chaptername, CompUrl, con);           // To save Chapters
            System.out.println("inside service cid " + cid);

            Matcher matcher = pattern.matcher(con);

            List<String> result = utility.toSplit(con, matcher, pattern);

            for (String s : result) {
                Matcher matcher2 = pattern2.matcher(s);
                List<String> sub_chap_no = utility.toGetSubChapNo(s, matcher2, pattern2);      // to get sub chapter number and number 
                List<String> sub_chap_name = utility.toSplit(s, matcher2, pattern2);                     // to get sub chapter number and name                        

                int schap_no = Integer.parseInt(sub_chap_no.get(0));
                Long sid = dao.saveSubchapter(sub_chap_name.get(0), schap_no, cid);            // To save subchapters
                System.out.println("inside service sid " + sid);
                Matcher matcher1 = pattern1.matcher(s);
                String[] words = utility.toGetWordsArray(s, matcher1, pattern1);
                int loop_count = 0;
                List<String> speakers_sublist = new ArrayList<String>();
                for (String v : words) {
                    String SPLIT_STR = " ";
                    String mainStr = v;
                    // code for getting speaker started   
                    int length = words.length - 1;
                    String speaker = null;
                                        if (loop_count < length) {
                                            StringTokenizer stToken = new StringTokenizer(mainStr, SPLIT_STR);
                                            String[] splitStr = new String[stToken.countTokens()];
                                            int i = 0;
                                            while (stToken.hasMoreElements()) {
                                                splitStr[i++] = stToken.nextToken();
                                            }
                                            int token_count = splitStr.length - 1;
                                            speaker = splitStr[token_count];
                                            if (speaker.length() == 1) {
                                                speaker = splitStr[splitStr.length - 2];
                                            }
                                            speakers_sublist.add(speaker);
                                            if (!speakers.contains(speaker)) {
                                                speakers.add(speaker);
                                                dao.saveSpeaker(speaker);
                                            }
                                            if (loop_count == 0 && v.length() > 100) {
                                                System.out.println("inside if_else");
                                                speaker_id = 1L;
                                            }
                                            if (loop_count > 0 && loop_count < length) {                                           
                                                int spkr_index = speakers_sublist.lastIndexOf(speaker);
                                                speaker = speakers_sublist.get(spkr_index - 1);
                                                speaker_id = dao.getSpeakerId(speaker);
                                            }
                                        }
                    if (loop_count == length) {
                        int spkr_index = speakers_sublist.size();
                        speaker = speakers_sublist.get(spkr_index - 1);
                        speaker_id = dao.getSpeakerId(speaker);
                    }
                    loop_count = loop_count + 1;
                    // code for getting speaker ended                       
                    Matcher matcher3 = pattern3.matcher(v);
                    List<String> sub_chap_verse = utility.toGetVerse(v, matcher3, pattern3);
                    for (String verse : sub_chap_verse) {
                        Matcher matcher4 = pattern4.matcher(verse);
                        List<String> sub_chap_verse2 = utility.toGetSubVerse(verse, matcher4, pattern4);
                        for (String v1 : sub_chap_verse2) {
                            dao.saveVerse(v1, sid, speaker_id);
                        }
                    }
                }
            }
          }
            dao.saveLiterature();
        } catch (IOException ex) {
            System.out.println("inside catch");
        }
        return "msg";
    }
}


package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Literature;
import in.cdac.hcdc.tet.Models.Verse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DyanDaoImpl implements DnyanDao {

    @Autowired
    private SessionFactory sf;

    int chapterno = 0;

    @Override
    public String extract(String url) {
        try {
            Document doc = Jsoup.connect(url).timeout(10000).get();
            System.out.println("**************inside Dao********************");

            Pattern pattern = Pattern.compile("([\\u0965\\u0964]{1}[ ]?\\p{IsN}{1,}+[ ]?\\u0965)");

            Elements chapterDetails = doc.select("ol li a");    //geting chaper url here with html tag
            Chapter chapter = null;

            Verse verse = null;
            Session session = sf.getCurrentSession();
            int chapterno = 0;
            Literature literature = (Literature) session.get(Literature.class, 1L);
            List<Chapter> chapters = new LinkedList<>();
            for (Element element : chapterDetails) {
                chapterno++;

                String chapterUrl = element.attr("href");       //getting chapter url without tag

                String mainUrl = "https://mr.wikisource.org";

                String completeUrl = mainUrl + chapterUrl;

                String chaptername = element.attr("title");

                Document docs = Jsoup.connect(mainUrl + chapterUrl).get();

                Elements chapterContents = docs.select("p");

                int verseNo = 0;

                String con = chapterContents.html();
                System.out.println("****&&Content to print     : " + con);
                System.out.println("*************************content end****************************");

                chapter = new Chapter(chaptername, chapterno, completeUrl, con.substring(12));

                List<Verse> verses = new LinkedList<Verse>();

                Matcher matcher = pattern.matcher(con);
                int index = 0;

                int pos = 0;

                List<String> result = new ArrayList<String>();

                        while (matcher.find(pos)) {

                            String[] words = pattern.split(con.substring(12));
                            String s1 = words[index] + matcher.group();
                            result.add(s1);
                            index++;

                            pos = matcher.end();
                        }
                                            for (String s : result) {
                                                System.out.println("*******final string to store ****************" + s);
                                                verseNo++;
                                                verse = new Verse(verseNo, s);
                                            //    verse.setChapterno(chapter);
                                                verses.add(verse);
                                            }

                chapter.setlDetails(literature);
               // chapter.setVersesList(verses);
                chapters.add(chapter);
            }
            literature.setChapters(chapters);
            session.saveOrUpdate(literature);
        } catch (IOException ex) {
            Logger.getLogger(DyanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "msg";
    }

    @Override
    public Chapter getChapterById(Long id) {
        return null;
    }
}




//                        Pattern pattern =Pattern.compile("([\\u0965\\u0964]{1}[ ]?\\p{IsN}{1,}+[ ]?\\u0965)");
//                             Matcher matcher = pattern.matcher((CharSequence) con);
//                                    while (matcher.find()) {
//
//                                    String[] words = pattern.split(con);
//                                              for (String s : words) {
//                                                  System.out.println("Split using Pattern.split(): " + s + matcher.group());
//                                                     verseNo++;
//                                                   verse = new Verse(verseNo, s.concat(matcher.group()));
//                                                 verse.setChapterno(chapter);
//                                                    verses.add(verse);
//                                            }
//                                    }
//@Repository
//@Transactional
//public class TextExtarctClass implements TextExtractInterface {
//
//    @Autowired
//    private SessionFactory sf;
//
//    int chapterno = 0;
//
//    @Override
//    public String extract(String url) {
//        try {
//            Document doc = Jsoup.connect(url).timeout(10000).get();
//            System.out.println("**************inside Dao********************");
//
//            Pattern pattern = Pattern.compile("([\\u0965\\u0964]{1}[ ]?\\p{IsN}{1,}+[ ]?\\u0965)");
//
//            Elements chapterDetails = doc.select("ol li a");    //geting chaper url here with html tag
//            Chapter chapter = null;
//
//            Verse verse = null;
//            Session session = sf.getCurrentSession();
//            int chapterno = 0;
//            Literature literature = (Literature) session.get(Literature.class, 1L);
//            List<Chapter> chapters = new LinkedList<>();
//            for (Element element : chapterDetails) {
//                chapterno++;
//
//                String chapterUrl = element.attr("href");       //getting chapter url without tag
//
//                String mainUrl = "https://mr.wikisource.org";
//
//                String completeUrl = mainUrl + chapterUrl;
//
//                String chaptername = element.attr("title");
//
//                Document docs = Jsoup.connect(mainUrl + chapterUrl).get();
//
//                System.out.println("Printing chapter contents with url");
//
//                Elements chapterContents = docs.select("p");
//
//                int verseNo = 0;
//
//                String con = chapterContents.html();
//
//                chapter = new Chapter(chaptername, chapterno, completeUrl, con.substring(12));
//
//                List<Verse> verses = new LinkedList<Verse>();
//
//                for (Element e : chapterContents)
//                {
//                 //   String content = e.html();
//               //  Matcher matcher = pattern.matcher(con);
//
//
//                //     String[] words = pattern.split(con);
//                 //  while(matcher.find())
//
//               //   {
//                            //    for (String s : words) {
//                                   // System.out.println("Split using Pattern.split(): " + s+matcher.group());
//                                     verseNo++;
//                                        verse = new Verse(verseNo, e.html());
//                                        verse.setChapterno(chapter);
//                                            verses.add(verse);
//                                }
//
//                   // }
//
//               //}
//                chapter.setlDetails(literature);
//                chapter.setVersesList(verses);
//                chapters.add(chapter);
//
//            }
//
//            literature.setChapters(chapters);
//            session.saveOrUpdate(literature);
//        } catch (IOException ex) {
//            Logger.getLogger(TextExtarctClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "msg";
//    }
//
//    @Override
//    public Chapter getChapterById(Long id) {
//        return null;
//    }
//}

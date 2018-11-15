/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jyoti
 */
@Service
public class UtilityMethods {

    @Async
    public List<String> toSplit(String con, Matcher matcher, Pattern pattern) {
        int index = 0;
        int pos = 0;
        List<String> result = new ArrayList<String>();
        while (matcher.find(pos)) {
            String[] words = pattern.split(con);
            String s1 = words[index];
            result.add(s1);                         //here in result we get full content of subchapters in result
            index++;
            pos = matcher.end();
        }
        return result;
    }

    @Async
    public List<String> toGetSubChapNo(String con, Matcher matcher, Pattern pattern) {
        int index = 0;
        int pos = 0;
        List<String> sub_chap_no = new ArrayList<String>();
        while (matcher.find(pos)) {
            String g = matcher.group();
            sub_chap_no.add(g);                      //here in result we get full content of subchapters in result
            index++;
            pos = matcher.end();
        }
        return sub_chap_no;
    }

    @Async
    public String[] toGetWordsArray(String con, Matcher matcher, Pattern pattern) {
        int pos1 = 0;
        int index1 = 0;
        String[] words = null;
        while (matcher.find(pos1)) {
            words = pattern.split(con);
            String str1 = words[index1];
            index1++;
            pos1 = matcher.end();         //here we get subchapter separated by uvach word
        }
        return words;
    }

    @Async
    public String toGetSpeakerName(String v) {
        String SPLIT_STR = " ";
        String mainStr = v;
        String speaker = null;
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
            System.out.println("final speaker to store in database.length ===== " + speaker);
        }
        return speaker;
    }

    @Async
    public String toGetSpeaker(int loop_count, int length, List<String> speakers_sublist) {
        String speaker = null;
        if (loop_count > 0 && loop_count <= length) {
            System.out.println("&&&&&&&& 0bserve &&&&&&&&");
            int spkr_index = speakers_sublist.lastIndexOf(speaker);
            speaker = speakers_sublist.get(spkr_index - 1);
            System.out.println("Loop_count " + loop_count);
            System.out.println("spkr_index    " + spkr_index + "    speaker " + speaker);
        }
        if (loop_count == length) {
            int spkr_index = speakers_sublist.size();
            System.out.println("inside last iteration Loop_count " + loop_count + "spkr_index size =" + spkr_index);
            speaker = speakers_sublist.get(spkr_index - 1);
            System.out.println("speker ==== " + speaker);
        }
        return speaker;
    }

    @Async
    public List<String> toGetVerse(String con, Matcher matcher, Pattern pattern) {
        int index = 0;
        int pos = 0;
        List<String> result = new ArrayList<String>();
        while (matcher.find(pos)) {
            String[] words = pattern.split(con);
            String s1 = words[index] + matcher.group();
            result.add(s1);                         //here in result we get full content of subchapters in result
            index++;
            pos = matcher.end();
        }
        return result;
    }

    @Async
    public List<String> toGetSubVerse(String verse, Matcher matcher4, Pattern pattern4) {
        List<String> sub_chap_verse2 = new ArrayList<String>();
        int pos4 = 0;
        int index4 = 0;
        String[] w2 = null;
        if (!matcher4.find(pos4)) {
            sub_chap_verse2.add(verse);
        } else {
            while (matcher4.find(pos4)) {
                w2 = pattern4.split(verse);
                String s1 = w2[index4] + matcher4.group();
                System.out.println("s1 ::::: " + s1);
                sub_chap_verse2.add(s1);
                index4++;
                pos4 = matcher4.end();
            }
            int w2_count = w2.length;
            System.out.println("w2[w2_count-1]     " + w2[w2_count - 1]);
            sub_chap_verse2.add(w2[w2_count - 1]);

        }
        return sub_chap_verse2;
    }

}


package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Speakers;
import java.util.List;

public interface MbharatDao {
      //public String extract(String url);
 /*     public void saveChapter(String chaptername, String chapterUrl, String substring);
      public void saveVerse(String result);
      public void saveLiterature(); */
    
     public Long saveChapter(String chaptername, String chapterUrl, String substring);
      public void saveVerse(String result,Long sid,Long spid);
      public void saveLiterature();
      public Long saveSubchapter(String name,int no,Long id);
      public Long saveSpeaker(String name);
     public Long getSpeakerId(String name);
     public List<String> getSpeakerList();
}

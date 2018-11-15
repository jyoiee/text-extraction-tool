
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Literature;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.SubChapters;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MbharatDaoImpl implements MbharatDao{
        @Autowired
        private SessionFactory sf;
       List<Chapter> chapters = new LinkedList<>();
       List<Verse> verses = new LinkedList<Verse>();
       List<SubChapters> sub_chap = new LinkedList<SubChapters>();
       List<Speakers> speaker = new LinkedList<Speakers>();
       LinkedList<Sense> senses = new LinkedList<Sense>();
       Sense sense = null;
       Speakers spkr = null;
        Chapter chapter = null;
        Verse verse = null;
        SubChapters subchap = null;
        int verseNo = 0;
        int chapterno = 0;     
        
     @Override
    public void saveVerse(String result,Long sid,Long spid)
    {
            Session session = sf.getCurrentSession(); 
                    verseNo++;
                    verse = new Verse(verseNo, result);
                    SubChapters sub = (SubChapters) session.get(SubChapters.class, sid);
                    verse.setSubchapterno(sub);
                    Speakers s = (Speakers) session.get(Speakers.class, spid);
                    verse.setsDetails(s);
                    verses.add(verse); 
                    verse.setSense(senses);
    }
     
    @Override
    public void saveLiterature()
    {  
        System.out.println("*******INSIDE LITERATURESAVE METHOD ****************");
        Session session = sf.getCurrentSession();  
        Literature literature = (Literature) session.get(Literature.class, 1L);
        literature.setChapters(chapters);
        session.saveOrUpdate(literature);
    }
 @Override
     public Long saveChapter(String chaptername, String chapterUrl, String substring){
          System.out.println("*******INSIDE CHATERsAVE METHOD ****************");
              Session session = sf.getCurrentSession();   
               Literature literature = (Literature) session.get(Literature.class, 1L); //we have to enter the new id each time while extracting the data
             chapter = new Chapter(chaptername, ++chapterno, chapterUrl, substring);
              chapter.setlDetails(literature);
              chapter.setSub_chapters(sub_chap);
              chapters.add(chapter);
            return (Long) session.save(chapter);
     }
    @Override
    public Long saveSubchapter(String name, int no, Long id) {
         System.out.println("*******INSIDE SUBCHATERsAVE METHOD ****************");
          Session session = sf.getCurrentSession();  
          System.out.println("chapter_id" + id);
          Chapter c = (Chapter) session.get(Chapter.class, id);
          subchap = new SubChapters(name,no);
          subchap.setCDetails(c);
          subchap.setVerse_list(verses);
          sub_chap.add(subchap);
          Long sub_save_id = (Long) session.save(subchap);
         // System.out.println("sun_save_id " + sub_save_id);
          return sub_save_id;
    }

    @Override
    public Long saveSpeaker(String name) {
         System.out.println("*******INSIDE SpeakerSaveMETHOD ****************");
          Session session = sf.getCurrentSession();  
            spkr = new Speakers(name);
             speaker.add(spkr);
                 spkr.setVerses(verses);
                   Long speaker_save_id = (Long) session.save(spkr);
        //  System.out.println("sun_save_id " + speaker_save_id);
      return speaker_save_id;
    }

    @Override
    public Long getSpeakerId(String name) {
           Session session = sf.getCurrentSession();  
            Criteria cr = session.createCriteria(Speakers.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id")).
                    setResultTransformer(Transformers.aliasToBean(Speakers.class));
            Criteria cr1 =cr.add(Restrictions.eq("name", name));
            Speakers sp = (Speakers) cr1.uniqueResult();
              Long id = sp.getId();
             return id;
    }

    @Override
    public List<String> getSpeakerList() {
         Session session = sf.getCurrentSession(); 
        List<Speakers> list = new ArrayList<Speakers>();
        List<String> r1 =new ArrayList<String>();
         list = session.createCriteria(Speakers.class).list();
        for (Speakers result : list) {    
            r1.add(result.getName());
        }
        return r1;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.SubChapters;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hcdc-pc15
 */
@Repository
public class MRetrieveDaoImpl implements MRetrieveDao {

    @Autowired
    private SessionFactory sf;

    // getting chapter names
    public List<Chapter> getChapters(Long id) {

        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Chapter.class).setProjection(Projections.projectionList().add(Projections.property("chapterId"), "chapterId")
                .add(Projections.property("name"), "name").add(Projections.property("chapNo"), "chapNo")).setResultTransformer(Transformers.aliasToBean(Chapter.class));
        Criteria cr1 = cr.add(Restrictions.eq("lDetails.LiteratureID", id));
        List results = cr1.list();

        System.out.println(results);
        return results;
    }

    // getting verses of chapters through subchapters
    @Override
    public List<Verse> getContent(Long subchapterId, Long speakerId) {

        Session session = sf.getCurrentSession();

        // to get verses
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));

        Criteria cr4 = cr3.add(Restrictions.eq("subchapterno.id", subchapterId));
        Criteria cr5 = cr4.add(Restrictions.eq("sDetails.id", speakerId));
        //  List<Verse> verses = cr4.list();
        List<Verse> verses1 = cr5.list();
        return verses1;
    }

    // getting chapter contents through only chapters full contents
    @Override
    public List<Chapter> getChapterContent(Long id) {
        Session session = sf.getCurrentSession();
        Criteria cr1 = session.createCriteria(Chapter.class).setProjection(Projections.projectionList().add(Projections.property("chapterId"), "chapterId")
                .add(Projections.property("fullContent"), "fullContent").add(Projections.property("name"), "name")).
                setResultTransformer(Transformers.aliasToBean(Chapter.class));
        Criteria cr2 = cr1.add(Restrictions.eq("chapterId", id));
        List<Chapter> chapters = cr2.list();

        //Chapter chap = (Chapter) cr1.uniqueResult();
        return chapters;

    }

    // getting subchapter names
    @Override
    public List<SubChapters> getSubChapterNames(Long chapterId) {
        Session session = sf.getCurrentSession();
        Criteria cr1 = session.createCriteria(SubChapters.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id")
                .add(Projections.property("sname"), "sname").add(Projections.property("subchapNo"), "subchapNo")).
                setResultTransformer(Transformers.aliasToBean(SubChapters.class));
        Criteria cr2 = cr1.add(Restrictions.eq("CDetails.chapterId", chapterId));
        List<SubChapters> subchapters = cr2.list();

        for (SubChapters subchapter : subchapters) {

        }

        return subchapters;

    }

    // getting speakers
    @Override
    public Map<Long, String> getSpeakers(Long subchapterId) {
        Session session = sf.getCurrentSession();

        //to get total speakers in mahabharat
//        Criteria cr = session.createCriteria(Speakers.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
//                add(Projections.property("name"), "name")).setResultTransformer(Transformers.aliasToBean(Speakers.class));
//
//        List<Speakers> speakers = cr.list();
        // to get speakers according to subchapters 
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));

        Criteria cr4 = cr3.add(Restrictions.eq("subchapterno.id", subchapterId));
        List<Verse> verses1 = cr4.list();
        Map<Long, String> speakers = new HashMap<Long, String>();
        for (Verse verse : verses1) {
            String name = verse.getsDetails().getName();
            Long id = verse.getsDetails().getId();
            if (!speakers.containsKey(id)) {
                speakers.put(id, name);
            }
        }
        return speakers;

    }

    // get verses according to the main chapters
    @Override
    public List<String> getverses(Long chapterId) {
        Session session = sf.getCurrentSession();
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));

        List<Verse> verses = cr3.list();
        List<String> v = new ArrayList();
        for (Verse verse : verses) {
            Long cid = verse.getSubchapterno().getCDetails().getChapterId();

            if (chapterId == cid) {
                v.add(verse.getVerseContent());
            }
        }
        return v;
    }
    
    // this method is usefull for getting subchapterwise verses,and getting the max number of result for subchapter
 @Override
    public List<Verse> getverse(Long chapterId) {
          Session session = sf.getCurrentSession();
            Criteria cr = session.createCriteria(Verse.class).
                    setProjection(Projections.projectionList().
                    add(Projections.property("verseContent"), "verseContent").add(Projections.property("sDetails"), "sDetails").add(Projections.property("id"), "id"))
                    .setResultTransformer(Transformers.aliasToBean(Verse.class));
            Criteria cr1 =cr.add(Restrictions.eq("subchapterno.id", chapterId));
             List<Verse> v = cr1.list();  
       return v;
    }

    @Override
    public List<Speakers> getTotalSpeakers(int pageid,int total) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Speakers.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("name"), "name")).setResultTransformer(Transformers.aliasToBean(Speakers.class));
        List<Speakers> speakers = cr.setFirstResult(pageid-1).setMaxResults(total).list();
        return speakers;
    }

    @Override
    public Map<Long, List<Verse>> getVersesWithMetadata(Long speakerId, Long chapterId) {
        Session session = sf.getCurrentSession();
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));
        Criteria cr4 = cr3.add(Restrictions.eq("sDetails.id", speakerId));
        List<Verse> verses = cr4.list();
        Map<Long, List<Verse>> mverses = new HashMap<Long, List<Verse>>();
        mverses.put(chapterId, verses);

        return mverses;
    }

    // get verses according to speakers only
    @Override
    public List<Verse> getCharacterWiseContents(Long speakerId )
    {
        Session session = sf.getCurrentSession();
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));
        Criteria cr4 = cr3.add(Restrictions.eq("sDetails.id", speakerId));
        List<Verse> verses = cr4.list();  
        return verses;   
    // this method is for pagination- to get limited number of result
    }

    @Override
    public List<Verse> pagination(Long SubchapterId, int pageid, int total) {
       Session session = sf.getCurrentSession();
            Criteria cr = session.createCriteria(Verse.class).
                    setProjection(Projections.projectionList().
                    add(Projections.property("verseContent"), "verseContent").add(Projections.property("sDetails"), "sDetails").add(Projections.property("id"), "id"))
                    .setResultTransformer(Transformers.aliasToBean(Verse.class));
            Criteria cr1 =cr.add(Restrictions.eq("subchapterno.id", SubchapterId));
             List<Verse> v = cr1.setFirstResult(pageid-1).setMaxResults(total).list();  
             System.out.println("vearses :" + v);
       return v;
    }

    @Override
    public List<Verse> getCharWiseContent(Long speakerId, int pageid, int total) {
     Session session = sf.getCurrentSession();
        Criteria cr3 = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").
                add(Projections.property("verseContent"), "verseContent").
                add(Projections.property("subchapterno"), "subchapterno").
                add(Projections.property("sDetails"), "sDetails")).
                setResultTransformer(Transformers.aliasToBean(Verse.class));
        Criteria cr4 = cr3.add(Restrictions.eq("sDetails.id", speakerId));
        List<Verse> verses = cr4.setFirstResult(pageid-1).setMaxResults(total).list();  
        return verses;   
        
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Language;
import in.cdac.hcdc.tet.Models.Literature;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hcdc-pc16
 */
@Repository
public class ChapterDao implements IChapter {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Chapter> getChapters(Long id) {

        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Chapter.class).setProjection(Projections.projectionList().add(Projections.property("chapterId"), "chapterId")
                .add(Projections.property("name"), "name").add(Projections.property("chapNo"), "chapNo")).setResultTransformer(Transformers.aliasToBean(Chapter.class));
    
        Criteria cr1=cr.add(Restrictions.eq("lDetails.LiteratureID", id));
        List results = cr1.list();
        
        System.out.println(results);
        return results;
    }

    @Override
    public Chapter getContent(Long id) {
        Session session = sf.getCurrentSession();
            Criteria cr = session.createCriteria(Chapter.class).setProjection(Projections.projectionList().add(Projections.property("chapterId"), "chapterId")
                    .add(Projections.property("fullContent"), "fullContent")).
                    setResultTransformer(Transformers.aliasToBean(Chapter.class));
            Criteria cr1 =cr.add(Restrictions.eq("chapterId", id));
            Chapter chap = (Chapter) cr1.uniqueResult();
            System.out.println(chap);
       return chap;
    }

    @Override
    public List<Language> getLanguage() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from Language");
        List list = query.list();

        System.out.println("**Inside chaper dao **********"+list);
        return list;

    }

    @Override
    public List<Chapter> togetChapters(Long id) {
        
        Session session = sf.getCurrentSession();

        Criteria cr = session.createCriteria(Literature.class).setProjection(Projections.projectionList().add(Projections.property("LiteratureID"), "LiteratureID")
        ).setResultTransformer(Transformers.aliasToBean(Literature.class));

        Criteria cr1 = cr.add(Restrictions
                .conjunction()
                .add(Restrictions.eq("language.id", id))
                .add(Restrictions.eq("autherDetails.authorid", 2L)));
       
        Literature lit = (Literature) cr1.uniqueResult();

        Long litId = lit.getLiteratureID();

        System.out.println("^^^Inside chapter dao togetchap Method ^^^^" + litId);

        Criteria c1 = session.createCriteria(Chapter.class).setProjection(Projections.projectionList().add(Projections.property("chapterId"), "chapterId")
                .add(Projections.property("name"), "name").add(Projections.property("chapNo"), "chapNo")).setResultTransformer(Transformers.aliasToBean(Chapter.class));

        Criteria c2 = c1.add(Restrictions.eq("lDetails.LiteratureID", litId));
        List results = c2.list();

        System.out.println(results);
        return results;
    }
    


}

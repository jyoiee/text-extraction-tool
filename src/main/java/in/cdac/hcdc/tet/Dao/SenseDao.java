/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.ArrayList;
import java.util.List;
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
 * @author Jyoti
 */
@Repository
public class SenseDao implements ISense {

    @Autowired
    private SessionFactory sf;

    List<Sense> senses = new ArrayList<>();
    List<Comments> comments = new ArrayList<>();
    Sense sense = null;
    Comments comment = null;

    @Override
    public void saveSense(Sense s, Long id) {
        Session session = sf.getCurrentSession();
        Sense s1 = s;
        Verse v = (Verse) session.get(Verse.class, id);
        s1.setvDetails(v);
        s1.setLike(0);
        s1.setUnlike(0);
        Long speaker_save_id = (Long) session.save(s1);
        s1.setComment(comments);
    }

    @Override
    public List<Sense> getSence(Long verse_id) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Sense.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("meaning"), "meaning").
                add(Projections.property("username"), "username").add(Projections.property("vDetails"), "vDetails").add(Projections.property("like"), "like").add(Projections.property("unlike"), "unlike")).
                setResultTransformer(Transformers.aliasToBean(Sense.class));
        Criteria cr1 = cr.add(Restrictions.eq("vDetails.id", verse_id));
        senses = cr1.list();
        return senses;
    }

    @Override
    public Sense getSencebySenseId(Long senseId) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Sense.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("meaning"), "meaning").
                add(Projections.property("username"), "username").add(Projections.property("vDetails"), "vDetails").add(Projections.property("like"), "like").add(Projections.property("unlike"), "unlike")).
                setResultTransformer(Transformers.aliasToBean(Sense.class));
        Criteria cr1 = cr.add(Restrictions.eq("id", senseId));
        sense = (Sense) cr1.uniqueResult();
        return sense;
    }

    @Override
    public void saveLike(Sense s, int likes) {
        Session session = sf.getCurrentSession();
//        System.out.println("Likes ====" + likes);
//        //String hqlUpdate = "update Sense c set c.like = :like where c.id = :id";
//        int updatedEntities = session.createQuery("update Sense c set c.like = :like where c.id = :id")
//                .setParameter("like", likes)
//                .setParameter("id", id)
//                .executeUpdate();
//        System.out.println("number of rows affectes :" + updatedEntities);
        s.setLike(likes);
        session.update(s);
    }

    @Override
    public void saveUnlike(Sense s, int unlikes) {
        Session session = sf.getCurrentSession();
        s.setUnlike(unlikes);
        session.update(s);
    }
}

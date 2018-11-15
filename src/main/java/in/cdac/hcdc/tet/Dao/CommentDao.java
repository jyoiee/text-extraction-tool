/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Models.Sense;
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
public class CommentDao implements IComment {

    @Autowired
    private SessionFactory sf;

    List<Sense> senses = new ArrayList<>();
    List<Comments> comments = new ArrayList<>();
    Sense sense = null;
    Comments comment = null;

    @Override
    public void saveComment(Comments s, Long id) {
        Session session = sf.getCurrentSession();
        Comments s1 = s;
        Sense v = (Sense) session.get(Sense.class, id);
        s1.setcDetails(v);
        Long speaker_save_id = (Long) session.save(s1);
    }

    @Override
    public List<Comments> getComment(Long verse_id) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Comments.class).setProjection(Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("comment"), "comment").
                add(Projections.property("username"), "username").add(Projections.property("cDetails"), "cDetails")).
                setResultTransformer(Transformers.aliasToBean(Comments.class));
        Criteria cr1 = cr.add(Restrictions.eq("cDetails.id", verse_id));
        comments = cr1.list();
        return comments;
    }
}

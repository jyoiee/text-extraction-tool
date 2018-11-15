/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
 * @author hcdc-pc16
 */
@Repository
public class VersesDao implements IVerses {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Verse> getVerses(Long Id) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Verse.class).setProjection(Projections.projectionList().add(Projections.property("verseContent"), "verseContent"))
                .setResultTransformer(Transformers.aliasToBean(Verse.class));
        Criteria cr1 = cr.add(Restrictions.eq("chapterno.chapterId", Id));
        List<Verse> v = cr1.list();
        return v;
    }

}

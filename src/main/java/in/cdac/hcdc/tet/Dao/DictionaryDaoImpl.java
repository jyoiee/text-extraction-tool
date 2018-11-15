/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harshada
 */

@Repository
public class DictionaryDaoImpl implements DictionaryDao
{
    @Autowired
    private SessionFactory sf;

    @Override
    public List <Dictionary> getMeaning(String word)
    {
       
        Long id = 1L;
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Dictionary.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("dictionaryEntry"), "dictionaryEntry")
                        .add(Projections.property("dictionaryEntryWith"), "dictionaryEntryWith")
                        .add(Projections.property("etymology"), "etymology")
                        .add(Projections.property("meaning"), "meaning"))
                .setResultTransformer(Transformers.aliasToBean(Dictionary.class));
        Criteria cr1 = cr
                .add(Restrictions.ilike("dictionaryEntry", word, MatchMode.ANYWHERE))
//                .add(Restrictions.ilike("dictionaryEntry", word, MatchMode.EXACT))
//                .add(Restrictions.ilike("dictionaryEntry", word, MatchMode.START))
                .add(Restrictions.ilike("dictionaryEntryWith", word, MatchMode.ANYWHERE));
//                .add(Restrictions.ilike("etymology", word, MatchMode.ANYWHERE));
        List <Dictionary> results = cr1.list();
        System.out.println("inside dao ");
        for (Dictionary result : results)
        {
            System.out.println("meaning of word" + result.getMeaning());
        }
    
        return results;
    }
    
}

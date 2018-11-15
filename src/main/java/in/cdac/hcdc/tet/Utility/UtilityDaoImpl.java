/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Utility;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Harshada
 */

@Repository
public class UtilityDaoImpl implements UtilityDao
{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public Dictionary saveDictionary(Dictionary d)
    {
        Session session = sf.getCurrentSession();
       
       
        session.save(d);
        
        return d;
    }
    
    
    @Override
    public List<Dictionary> getDictionary()
    {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Dictionary.class).setProjection(Projections.projectionList().
                add(Projections.property("id"), "id").
                add(Projections.property("dictionaryEntry"), "dictionaryEntry").
                add(Projections.property("meaning"), "meaning")).
                setResultTransformer(Transformers.aliasToBean(Dictionary.class));
    
       
        List results = cr.list();
    
        return results;
    }
}

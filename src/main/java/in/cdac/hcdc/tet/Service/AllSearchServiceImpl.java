/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.AllSearchDao;
import in.cdac.hcdc.tet.Models.Speakers;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harshada
 */

@Service
@Transactional
public class AllSearchServiceImpl implements AllSearchService{
    
    @Autowired
    private AllSearchDao dao;
    
    
    
    @Override
     public void indexSpeakers() {}
    @Override
     public List<Speakers> searchForSpeakers(String searchText)
     {
        List<Speakers> results =  dao.searchForSpeakers(searchText);
        return results;
     }
}

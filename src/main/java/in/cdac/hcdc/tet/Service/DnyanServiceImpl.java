/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.DnyanDao;
import in.cdac.hcdc.tet.Models.Chapter;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcdc-pc15
 */
@Service
@Transactional
public class DnyanServiceImpl implements DnyanService
{
    @Autowired
     public DnyanDao dao;
   
    @Override
     public String extract(String url)
     {
         String msg = dao.extract(url); 
         return msg;
     }

    @Override
    public List<Chapter> getChapters(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}

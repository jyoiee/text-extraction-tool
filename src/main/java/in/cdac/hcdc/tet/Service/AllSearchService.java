/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Models.Speakers;
import java.util.List;

/**
 *
 * @author Harshada
 */
public interface AllSearchService {
     public void indexSpeakers() ;
      public List<Speakers> searchForSpeakers(String searchText);
}

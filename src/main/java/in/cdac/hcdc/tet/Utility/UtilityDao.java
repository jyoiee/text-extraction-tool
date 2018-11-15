/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Utility;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;

/**
 *
 * @author Harshada
 */
public interface UtilityDao 
{
    public Dictionary saveDictionary(Dictionary d);
    
     public List<Dictionary> getDictionary();
}

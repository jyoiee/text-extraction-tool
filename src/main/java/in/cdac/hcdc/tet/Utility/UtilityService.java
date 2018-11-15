/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Utility;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.io.File;
import java.util.List;

/**
 *
 * @author Harshada
 */
public interface UtilityService  {
    public void saveDictionary(File file);
     public List<Dictionary> getDictionary();
}

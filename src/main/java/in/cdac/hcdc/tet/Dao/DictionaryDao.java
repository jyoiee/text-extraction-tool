/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;

/**
 *
 * @author Harshada
 */
public interface DictionaryDao {

    public List <Dictionary> getMeaning(String word);
}

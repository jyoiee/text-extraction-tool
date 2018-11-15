/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;

/**
 *
 * @author Harshada
 */
public interface SearchService {
    public List <Dictionary> getMeaning(String word);
}

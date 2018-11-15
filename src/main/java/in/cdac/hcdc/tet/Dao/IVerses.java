/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.List;

/**
 *
 * @author hcdc-pc16
 */
public interface IVerses {

    public List<Verse> getVerses(Long Id);

}

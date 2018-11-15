/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Sense;
import java.util.List;

/**
 *
 * @author Jyoti
 */
public interface ISense {

    public void saveSense(Sense s, Long id);

    public List<Sense> getSence(Long verse_id);

    public void saveLike(Sense s,int likes);

    public void saveUnlike(Sense s,int unlikes);

    public Sense getSencebySenseId(Long senseId);
}

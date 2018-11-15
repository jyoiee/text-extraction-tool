/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Models.Sense;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jyoti
 */
public interface ISenseService {

    public void saveSense(Sense s, Long id);

    public List<Sense> getSence(Long verse_id);

    public void saveLike(Long id);

    public void saveUnlike(Long id);

}

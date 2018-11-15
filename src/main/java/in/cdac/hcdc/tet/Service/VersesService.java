/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;
import in.cdac.hcdc.tet.Dao.IVerses;
import in.cdac.hcdc.tet.Models.Verse;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcdc-pc16
 */
@Service
@Transactional
public class VersesService implements IVersesService {

    @Autowired
    private IVerses dao;

    @Override
    public List<Verse> getVerses(Long Id) {
        return dao.getVerses(Id);
    }

}

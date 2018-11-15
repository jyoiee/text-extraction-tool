/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.ISense;
import in.cdac.hcdc.tet.Models.Sense;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jyoti
 */
@Service
@Transactional
public class SenseService implements ISenseService {

    @Autowired
    private ISense dao;

    @Override
    public void saveSense(Sense s, Long id) {
        dao.saveSense(s, id);
    }

    @Override
    public List<Sense> getSence(Long verse_id) {
        return dao.getSence(verse_id);
    }

    @Override
    public void saveLike(Long senseId) {
        Sense s = dao.getSencebySenseId(senseId);
        System.out.println("s====" + s);
        int likes = 0;
        if (s.getLike() == 0) {
            likes = 1;
        } else {
            likes = s.getLike() + 1;
        }
        dao.saveLike(s, likes);
    }

    @Override
    public void saveUnlike(Long senseId) {
        Sense s = dao.getSencebySenseId(senseId);
        System.out.println("s====" + s);
        int unlikes = 0;
        if (s.getUnlike() == 0) {
            unlikes = 1;
        } else {
            unlikes = s.getLike() + 1;
        }
        dao.saveUnlike(s, unlikes);
    }
}

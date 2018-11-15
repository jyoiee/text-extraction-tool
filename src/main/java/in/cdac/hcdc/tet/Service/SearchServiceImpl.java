/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.DictionaryDao;
import in.cdac.hcdc.tet.Models.Dictionary;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harshada
 */
@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DictionaryDao dao;

    @Override
    public List <Dictionary> getMeaning(String word) {
       List <Dictionary> results = dao.getMeaning(word);

        return results;
    }
}

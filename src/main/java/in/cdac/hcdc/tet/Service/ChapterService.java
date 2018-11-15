/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.IChapter;
import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Language;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hcdc-pc16
 */

@Service
@Transactional
public class ChapterService implements IChapterService{
    
    @Autowired
    private IChapter dao;
    
    @Override
    public List<Chapter> getChapters(Long id) {
      return dao.getChapters(id);
    }

    @Override
    public Chapter getContent(Long id) {
        return dao.getContent(id);
    }

    @Override
    public List<Language> getLanguage() {
     return dao.getLanguage();
    }

    @Override
    public List<Chapter> togetChapters(Long id) {
       return dao.togetChapters(id);
    }
    
}

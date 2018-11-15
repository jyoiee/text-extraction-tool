/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Language;
import java.util.List;

/**
 *
 * @author hcdc-pc16
 */
public interface IChapter {
     public List<Chapter> getChapters(Long id);

     public Chapter getContent(Long id);
     
     public List<Language> getLanguage();
     
     public List<Chapter> togetChapters(Long id);
     
}

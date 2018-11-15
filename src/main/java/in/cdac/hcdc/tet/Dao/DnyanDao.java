/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Chapter;
import java.util.List;

/**
 *
 * @author hcdc-pc15
 */
public interface DnyanDao {

    public String extract(String url);

    public Chapter getChapterById(Long id);
}

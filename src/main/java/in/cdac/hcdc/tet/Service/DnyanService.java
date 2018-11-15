/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Models.Chapter;
import java.util.List;

/**
 *
 * @author hcdc-pc15
 */
public interface DnyanService {

    public String extract(String url);

    public List<Chapter> getChapters(Long id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Dao;

import in.cdac.hcdc.tet.Models.Comments;
import java.util.List;

/**
 *
 * @author Jyoti
 */
public interface IComment {

    public void saveComment(Comments s, Long id);

    public List<Comments> getComment(Long verse_id);
}

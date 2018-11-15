/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Service;

import in.cdac.hcdc.tet.Dao.IComment;
import in.cdac.hcdc.tet.Models.Comments;
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
public class CommentService implements ICommentService {

    @Autowired
    private IComment dao;

    @Override
    public void saveComment(Comments s, Long id) {
        dao.saveComment(s, id);
    }

    @Override
    public List<Comments> getComment(Long verse_id) {
        return dao.getComment(verse_id);
    }

}

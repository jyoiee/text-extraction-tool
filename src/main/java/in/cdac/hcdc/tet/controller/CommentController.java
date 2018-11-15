/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Service.ICommentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jyoti
 */
@Controller
public class CommentController {

    @Autowired
    private ICommentService service;

    @RequestMapping("/addComment/{id}")
    public String addComment(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long sense_id) {
        String com = request.getParameter("comment");
        String Name = request.getParameter("username");
        Comments c1 = new Comments(Name, com);
        service.saveComment(c1, sense_id);
        return "versesWithMetaData";
    }

    @RequestMapping("/getComment/{id}")
    public String getComment(Model map, @PathVariable("id") Long sense_id) {
        System.out.println("inside getmeaning method");
        List<Comments> list = service.getComment(sense_id);
        map.addAttribute("commentList", list);
        return "versesWithMetaData";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Dao.ISense;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Service.ISenseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jyoti
 */
@Controller
public class SenseController {

    @Autowired
    private ISenseService service;

    @RequestMapping("/addMeaning/{id}")
    public String AddMeaning(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long verse_id) {
        String Name = request.getParameter("username");
        String sense = request.getParameter("meaning");
        Sense s1 = new Sense(sense, Name);
        service.saveSense(s1, verse_id);
        return "versesWithMetaData";
    }

    @RequestMapping("/getMeaning/{id}")
    public String getMeaning(HttpSession session, @PathVariable("id") Long verse_id) {
        System.out.println("inside getmeaning method");
        List<Sense> list = service.getSence(verse_id);
        session.setAttribute("senseList", list);
        return "versesWithMetaData";
    }

    @RequestMapping("/addlike/{id}")
    public String addlike(@PathVariable("id") Long sense_id) {
        System.out.println("********************************************************sense id insideaddllike method:  " + sense_id);
        service.saveLike(sense_id);
        return "versesWithMetaData";
    }

    @RequestMapping("/addunlike/{id}")
    public String addunlike(@PathVariable("id") Long sense_id) {
        System.out.println("sense id insideaddunlike method:  " + sense_id);
        service.saveUnlike(sense_id);
        return "versesWithMetaData";
    }
}

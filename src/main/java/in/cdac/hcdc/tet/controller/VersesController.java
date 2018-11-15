/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Comments;
import in.cdac.hcdc.tet.Models.Sense;
import in.cdac.hcdc.tet.Models.Verse;
import in.cdac.hcdc.tet.Service.IVersesService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hcdc-pc16
 */
@Controller
@RequestMapping(value = "/verses")
public class VersesController {

    @Autowired
    private IVersesService service;

    @RequestMapping("/getFullDnyaneshwary/{id}")
    public String viewDnyaneshwary(Model map, @PathVariable("id") Long Id) {
        System.out.println("Inside update for user" + Id);
        List<Verse> verses = service.getVerses(Id);
        map.addAttribute("v", verses);
        return "fullContent";
    }

    @RequestMapping("/getFullMahabharat/{id}")
    public String viewMahabharat(Model map, @PathVariable("id") Long Id) {
        System.out.println(" &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside update for user" + Id);
        List<Verse> verses = service.getVerses(Id);
        map.addAttribute("v", verses);
        return "fullContent";
    }
}

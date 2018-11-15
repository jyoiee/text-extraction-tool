/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.Verse;
import in.cdac.hcdc.tet.Service.IVersesService;
import in.cdac.hcdc.tet.Service.MRetrieveService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Harshada
 */
@Controller

public class CharacterController {

    @Autowired
    private MRetrieveService service;

    @RequestMapping(value = "/Retreive")
    public String getChapters(Model map, HttpSession session) {
        Long id = 1L;
        List<Chapter> chapters = service.getChapters(id);

        //   map.addAttribute("chapterNames", chapters);
        session.setAttribute("chapterNames", chapters);
        return "mainChapters";
    }

    @RequestMapping(value = "/getTotalSpeakers/{pageid}")
    public String getTotalSpeakers(HttpSession session, @PathVariable("pageid") int pageid) {
        int total = 15;
        if (pageid == 1) {
        } else {
            pageid = (pageid - 1) * total + 1;
        }
        List<Speakers> speakers = service.getTotalSpeakers(pageid, total);
        session.setAttribute("speakers", speakers);
        return "characters";
    }

    @RequestMapping(value = "/getCharacterWiseContents/{speakerId}/{pageid}")
    public String getCharacterWiseContents(HttpSession session, Model map, @PathVariable("speakerId") Long speakerId, @PathVariable("pageid") int pageid) {
        int total = 3;
        if (pageid == 1) {
        } else {
            pageid = (pageid - 1) * total + 1;
        }
        List<Verse> v1 = service.getCharacterWiseContents(speakerId);
        int count = v1.size();
        List<Verse> verses = service.getCharWiseContent(speakerId, pageid, total);
        session.setAttribute("count", count);
        session.setAttribute("s", speakerId);
        session.setAttribute("verses", verses);
        return "versesWithMetaData";
    }
}

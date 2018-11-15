/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Speakers;
import in.cdac.hcdc.tet.Models.SubChapters;
import in.cdac.hcdc.tet.Models.Verse;
import in.cdac.hcdc.tet.Service.MRetrieveService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hcdc-pc15
 */
@Controller

public class RetrieveController {

    @Autowired
    private MRetrieveService service;

    @RequestMapping(value = "/forTextLikeData")
    public String getChapters(Model map, HttpSession session) {
        Long id = 1L;
        List<Chapter> chapters = service.getChapters(id);
        
        //   map.addAttribute("chapterNames", chapters);
        session.setAttribute("chapterNames", chapters);
        return "chapterNames";
    }
    
     @RequestMapping(value = "/forVerseWiseData")
    public String getChapter(Model map, HttpSession session) {
        Long id = 1L;
        List<Chapter> chapters = service.getChapters(id);
        
        //   map.addAttribute("chapterNames", chapters);
        session.setAttribute("chapterName", chapters);
        return "chapters_list";
    }

    @RequestMapping(value = "/getLinks")
    public String getLinks() {

        return "links";
    }

    @RequestMapping(value = "/SearchAndRetreive/{id}/{Id}")
    public String getContent(Model map, @PathVariable("id") Long subchapterId, @PathVariable("Id") Long speakerId, HttpSession session) {
        System.out.println("inside controller : ");
        String sname = null;
        String SpeakerName = null;
        List<Verse> verses = service.getContent(subchapterId, speakerId);
        for (Verse verse : verses) {
            System.out.println("speaker name and id : " + verse.getsDetails().getName() + verse.getsDetails().getId());
            System.out.println("verses : " + verse.getSubchapterno().getSname());
            sname = verse.getSubchapterno().getSname();
            SpeakerName = verse.getsDetails().getName();
        }
        session.setAttribute("fullcontent", verses);
        session.setAttribute("subchaptername", sname);
        session.setAttribute("speakername", SpeakerName);
        return "fullContent";
    }

    @RequestMapping(value = "/getSubchapters/{id}/{name}")
    public String getSubChapters(Model map, @PathVariable("id") Long Id, @PathVariable("name") String name, HttpSession session) {
        List<SubChapters> subch = service.getSubChapterNames(Id);
        // map.addAttribute("subchapters" ,subch);
        session.setAttribute("subchapters", subch);
        session.setAttribute("chaptername", name);
        return "subchapters";
    }

    @RequestMapping(value = "/getSpeakers/{id}")
    public String getSpeakers(Model map, HttpSession session, @PathVariable("id") Long subchapterId) {
        System.out.println("inside speaker method");
        Map<Long, String> speakers = service.getSpeakers(subchapterId);

        session.setAttribute("speakers", speakers);
        session.setAttribute("subchapterId", subchapterId);

        return "speakers";

    }

    @RequestMapping(value = "/getWholeContent/{id}/{name}")
    public String getWholeContent(Model map, HttpSession session, @PathVariable("id") Long chapterId, @PathVariable("name") String name) {
        System.out.println("inside contents method");
        List<Chapter> contents = service.getChapterContent(chapterId);
        session.setAttribute("contents", contents);
        map.addAttribute("contents", contents);
        return "chapterContents";

    }

    @RequestMapping(value = "/getVerses/{chapterId}")
    public String getVerses(Model map, HttpSession session, @PathVariable("chapterId") Long chapterId) {
        List<String> verses = service.getverses(chapterId);
        map.addAttribute("verses", verses);
        return "verses";
    }

   
   
    @RequestMapping(value = "/getVersesWithMetaData/{chapterId}/{speakerId}")
    public String getVersesWithMetaData(Model map, HttpSession session, @PathVariable("chapterId") Long chapterId ,@PathVariable("speakerId") Long speakerId) {
        Map <Long , List<Verse>> mverses = service.getVersesWithMetadata(chapterId, speakerId);
        for (Map.Entry<Long, List<Verse>> entrySet : mverses.entrySet()) {
            Long key = entrySet.getKey();
            List<Verse> value = entrySet.getValue();           
        }
        map.addAttribute("chapterId" , chapterId);
        map.addAttribute("mverses", mverses);
    
        return "versesWithMetaData";
    }
    
       @RequestMapping(value = "/getChapterwiseVerses/{SubchapterId}")
    public String getVerse(Model map, HttpSession session, @PathVariable("SubchapterId") Long SubchapterId) {
        List<Verse> verses = service.getverse(SubchapterId);
        List<Verse> v =new ArrayList();
        session.setAttribute("SubchapterId", SubchapterId);
        session.setAttribute("Resultcount", verses.size());
        map.addAttribute("verses", verses.subList(0, 5));
        return "verses1";
    }
    
        @RequestMapping(value = "/getSubChapterwiseVerses/{SubchapterId}/{pageid}")
    public String forPagination(Model map, HttpSession session, @PathVariable("SubchapterId") Long SubchapterId,@PathVariable("pageid") int pageid) {
    int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Verse> verses = service.pagination(SubchapterId,pageid,total);
        map.addAttribute("verses", verses);
        return "verses";
    }
    
 /*    @RequestMapping(value = "/getTotalSpeakers/{chapterId}")
    public String getTotalSpeakers(Model map ,@PathVariable("chapterId") Long chapterId)
    {
       List <Speakers> speakers = service.getTotalSpeakers();
       map.addAttribute("speakers", speakers);
       map.addAttribute("chapterId", chapterId);
       return "characters";
    }*/
}

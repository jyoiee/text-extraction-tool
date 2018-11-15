/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Models.Language;
import in.cdac.hcdc.tet.Service.IChapterService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hcdc-pc16
 */

@Controller
@RequestMapping(value = "/chapter")
public class ChapterController {
    
     @Autowired
    private IChapterService service;
     
      @RequestMapping(value = "/getDnyneshwary")
    public String getDnyneshwary(Model map) throws IOException
    {
        Long id = 1L;
           List<Chapter> chapters = service.getChapters(id);
           map.addAttribute("chapterNames", chapters);
           return "chapters";
    } 
    
       @RequestMapping(value = "/getMahabharat")
    public String getMahabharat(Model map) throws IOException
    {
        Long id = 2L;
           List<Chapter> chapters = service.getChapters(id);
           map.addAttribute("MahaChapter", chapters);
           return "chapters";
    } 
   @RequestMapping(value = "/language")
    public String selectlanguage(Model map) throws IOException
    {
       
           List<Language> languages = service.getLanguage();
           map.addAttribute("Language", languages);
           return "chapters";
    } 
    
        @RequestMapping(value = "/getChapters/{id}")
    public String getChapters(Model map,@PathVariable("id") Long Id) throws IOException
    {
        System.out.println();
           List<Chapter> chapters = service.togetChapters(Id);
           map.addAttribute("Chapterlist", chapters);
           return "chapters";
    } 
}

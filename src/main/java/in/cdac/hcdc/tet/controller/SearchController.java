/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.controller;


import in.cdac.hcdc.tet.Models.Dictionary;
import in.cdac.hcdc.tet.Service.SearchService;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Harshada
 */

@Controller
@RequestMapping(value = "/search")
public class SearchController {
    
    @Autowired
    private SearchService service;
    
    
    @RequestMapping(value = "/word")
    @ResponseBody
    public JSONObject searchWord(@RequestParam("word") String word){
        System.out.println("inside search method");
        System.out.println("*******selected word******* : " + word);
        
        // logic to fetch meaning 
        // service call
        String meaning = "meaning";
        List <Dictionary> results = service.getMeaning(word);
        JSONObject obj = new JSONObject();
        obj.put("entry", results);
        obj.put("searchedWord", word);
        return obj;
    
    }
    
}

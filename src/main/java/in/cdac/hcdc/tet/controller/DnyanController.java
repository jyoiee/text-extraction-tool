package in.cdac.hcdc.tet.controller;


import in.cdac.hcdc.tet.Models.Chapter;
import in.cdac.hcdc.tet.Service.DnyanService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sanjay Rabidas<sanjayr@cdac.in>
 */
@Controller
public class DnyanController 
{
     @Autowired
        public DnyanService service;
        
    @RequestMapping(value = "/")
    public String index() throws IOException {
      System.out.println("Loading Index");
        return "index";
    }

    @RequestMapping(value = "/dnyaneshwari")
    public String extract() throws IOException
    {
           String url = "https://mr.wikisource.org/wiki/%E0%A4%9C%E0%A5%8D%E0%A4%9E%E0%A4%BE%E0%A4%A8%E0%A5%87%E0%A4%B6%E0%A5%8D%E0%A4%B5%E0%A4%B0%E0%A5%80";
            service.extract(url);
          //  List<Chapter> chapters = service.getChapters(1);
            //System.out.println(chapters); 
        return "chapters";
    } 
   
}
        
        
        
        
        

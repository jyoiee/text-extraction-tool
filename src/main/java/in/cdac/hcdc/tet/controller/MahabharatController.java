
package in.cdac.hcdc.tet.controller;

import in.cdac.hcdc.tet.Service.MbharatService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahabharatController {
    
    @Autowired
    public MbharatService service;
    
    
    @RequestMapping(value = "/mahabharat")
    public String extract() throws IOException
    {
           String url = "http://sanskritdocuments.org/mirrors/mahabharata/mahabharata-bori.html";
        
            service.extract(url);
        return "chapters";
    } 
}

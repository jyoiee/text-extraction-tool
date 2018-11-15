/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Utility;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;


/**
 *
 * @author hcdc-pc15
 */
@Controller
public class UtilityController {
    @Value("${excel.file.location}")
    String filePath;
    
    @Autowired
    private UtilityService service;
    private final Logger log = Logger.getLogger(UtilityController.class);

    @RequestMapping(value = "/readData")
    public String readExcelFile() {
        System.out.println("inside utility controller");

        File file = new File(filePath);

        service.saveDictionary(file);

        return "index";
    }

    @RequestMapping(value = "/readDataBase")
    public String getDictionary(Model map) {
        List<Dictionary> dlist = service.getDictionary();

        map.addAttribute("listOfWords", dlist);
        return "dcontents";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cdac.hcdc.tet.Utility;

import in.cdac.hcdc.tet.Models.Dictionary;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harshada
 */
@Service
@Transactional
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    UtilityDao dao;

    private final Logger log = Logger.getLogger(UtilityController.class);

    @Override
    public void saveDictionary(File file) {
        List sheetData = new ArrayList();
        InputStream fis = null;

        String s = " ";
        try {
            System.out.println("file reding using XSSF reader");

            fis = new FileInputStream(file);

            // Create an excel workbook from the file system.
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            workbook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
            // Get the first sheet on the workbook.
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int row = 0; row <= sheet.getLastRowNum(); row++) {
                Row r = sheet.getRow(row);
                log.info("row no : " + row);
                List<String> dlist = new ArrayList();
                for (int col = 0; col < r.getLastCellNum(); col++) {
                    log.info("cell no : " + col);
                    Cell cell = r.getCell(col);
                    log.info("cell data : " + cell);
                    if (col == 1 && cell.getCellType() == 3) {
                        System.out.println("Reached EOF...Exiting...");
                        return;
                    }
                    dlist.add(col, cell.toString());
                }

                Dictionary d = new Dictionary(dlist.get(0),
                        dlist.get(1),
                        dlist.get(2),
                        dlist.get(3),
                        dlist.get(4),
                        dlist.get(5),
                        dlist.get(6),
                        dlist.get(7),
                        dlist.get(8),
                        dlist.get(9));
                System.out.printf("%d === > %s", row, d.getDictionaryEntry());
                dao.saveDictionary(d);
                d = null;
                dlist = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    System.out.println("Closing Connection");
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Dictionary> getDictionary() {
        List<Dictionary> dlist = dao.getDictionary();

        return dlist;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MinhPC
 */
import com.monitorjbl.xlsx.StreamingReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;
import z11.F_ile;

public class ReadLargeExcel {

    public static void main(String[] args) throws FileNotFoundException {
        List list = new ArrayList();
        InputStream is = new FileInputStream(new File("data/OnlineRetail.xlsx"));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);            // InputStream or File for XLSX file (required)
        Sheet mysheet = workbook.getSheetAt(0);
//        int row = mysheet.getLastRowNum();
//        JSONArray jsonArray = new JSONArray();
//        for (Sheet sheet : workbook) {
        for (Row r : mysheet) {
//            JSONObject json = new JSONObject();
            String str = "";

            for (Cell c : r) {
                if (c.getColumnIndex() == 1) {
                    str = str + c.getStringCellValue();
                }
                if (c.getColumnIndex() == 2) {
                    str = str + "__" + c.getStringCellValue();
                }
            }
            System.out.println(str);
            list.add(str);

//            jsonArray.put(json);
//      
        }
        System.out.println(list.size());
        Collection<String> c = (Collection<String>) list.stream().collect(Collectors.toSet());
        System.out.println(c.size());

        F_ile.writeStringToFile("data/instance_StockCode_ProductName.txt", c.toString(), true);
//        F_ile.writeStringToFile("data/data.json", jsonArray.toString(), false);
//
//        removeTheDuplicates(list);
//        }
    }

    private static void removeTheDuplicates(List<String> myList) {
        for (ListIterator<String> iterator = myList.listIterator(); iterator.hasNext();) {
            String customer = iterator.next();
            if (Collections.frequency(myList, customer) > 1) {
                iterator.remove();
            }
        }
        System.out.println(myList.size());

    }
}

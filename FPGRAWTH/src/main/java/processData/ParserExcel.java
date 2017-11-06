/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;

/**
 *
 * @author MinhPC
 */
public class ParserExcel {

    private JSONArray listJSON;

    public ParserExcel() {
//        String EXCEL_FILE_LOCATION = "data/Online_Retail.xls";
//        Workbook workbook = null;
//        try {
//            JSONArray list_json = new JSONArray();
//            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
//
//            Sheet sheet = workbook.getSheet(0);
//            int rows = sheet.getRows();
//            int current_row = 1;
//            Cell cell1 = null;
//
//            while (current_row < rows - 1) {
//                List listItem = new ArrayList();
//                cell1 = sheet.getCell(0, current_row);
//                String StockCode = sheet.getCell(1, current_row).getContents();
//                System.out.println(StockCode);
//                listItem.add(StockCode);
//                /**/
////                    String InvoiceNo  = sheet.getCell(0, current_row).getContents().trim();
////                    String CustomerID = sheet.getCell(6, current_row).getContents().trim();
////                    String Country    = sheet.getCell(6, current_row).getContents().trim();
//
//                /**/
//                int head = current_row;
////                System.out.println(head);
//                while (cell1.getContents() == sheet.getCell(0, ++head).getContents()) {
////                    System.out.println(head);
//                    String _StockCode = sheet.getCell(1, head).getContents();
//                    System.out.println(_StockCode);
//                    listItem.add(_StockCode);
//                }
//                current_row = head;
////                System.out.println(listItem);
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } finally {
//
//            if (workbook != null) {
//                workbook.close();
//            }
//
//        }

    }

    private static Workbook getRelevantWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("Incorrect file format");
        }

        return workbook;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            String excelFilePath = "data/OnlineRetail.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            System.out.println(excelFilePath);
            Workbook workbook = getRelevantWorkbook(inputStream, excelFilePath);

//            Sheet firstSheet = workbook.getSheetAt(0);
//            Iterator<Row> iterator = firstSheet.iterator();
//
//            while (iterator.hasNext()) {
//                Row nextRow = iterator.next();
//                Iterator<Cell> cellIterator = nextRow.cellIterator();
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    System.out.println(cell.getStringCellValue());
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//
//            workbook.close();
//            inputStream.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

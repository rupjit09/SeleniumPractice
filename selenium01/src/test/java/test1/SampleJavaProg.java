package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleJavaProg {

	public static void main(String[] args) throws IOException {
		//File f=new File("");
		//FileWriter wr=new FileWriter(f);
//Read XLS file ==Use the class HSSFWorkbook
		InputStream xls_ip=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\xldata\\data1.xls"));
		//System.out.println(System.getProperty("user.dir"));
		Workbook xls_wb=new HSSFWorkbook(xls_ip);
		Sheet xls_sheet=xls_wb.getSheetAt(0);
		Row xls_row=xls_sheet.getRow(1);
		Cell xls_cell=xls_row.getCell(1);
		System.out.println("xls Cell data="+xls_cell.toString());
		xls_wb.close();
		
//Read XLSX file == Use the class XSSFWorkbook
		InputStream xlsx_ip=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\xldata\\data2.xlsx"));
		Workbook xlsx_wb=new XSSFWorkbook(xlsx_ip);
		Sheet xlsx_sheet=xlsx_wb.getSheetAt(0);
		Row xlsx_row=xlsx_sheet.getRow(1);
		Cell xlsx_cell=xlsx_row.getCell(1);
		System.out.println("xlsx Cell data="+xlsx_cell.toString());
		xlsx_wb.close();
	}

}

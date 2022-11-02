package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	String path = "C:\\Users\\232338\\eclipse-workspace\\07May22SwagLab\\src\\main\\java\\com\\testData\\MyTestData07May.xlsx";
	
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public String readData(int sheet_index,int rownum,int cellnum)
	{
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheet_index);	
		} 
		catch (IOException e) 
		{
			System.out.println("Provide current path");
			e.printStackTrace();
		}
		String data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheet_index)
	{
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheet_index);	
		} 
		catch (IOException e) 
		{
			System.out.println("Provide current path");
			e.printStackTrace();
		}
		int row_count=sheet.getLastRowNum();
		return row_count;
	}
	
	public int getCellCount(int sheet_index,int r)
	{
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheet_index);	
		} 
		catch (IOException e) 
		{
			System.out.println("Provide current path");
			e.printStackTrace();
		}
		int cell_count =sheet.getRow(r).getLastCellNum();
		return cell_count;
	}
	
	public void writeData(int sheet_index,int rownum,int cellnum,String status) 
	{
		 
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheet_index);
			sheet.getRow(rownum).createCell(cellnum).setCellValue(status);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			wb.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}

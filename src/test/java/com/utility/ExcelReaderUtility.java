package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		
		XSSFWorkbook xssWorkbook = null;
		Row row;
		Cell emailAddressCell, passwordCell;
		User user;
		List<User> userList = null;
		Iterator<Row> iterator;
		XSSFSheet xssfSheet;		

		try {			
			xssWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();
			xssfSheet = xssWorkbook.getSheet("LoginTestData");
			iterator = xssfSheet.iterator();
			iterator.next();// Skipped 1st 1st row			
			while (iterator.hasNext()) {
				row = iterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
//				System.out.println(emailAddressCell.toString());
//				System.out.println(passwordCell.toString());
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssWorkbook.close();
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
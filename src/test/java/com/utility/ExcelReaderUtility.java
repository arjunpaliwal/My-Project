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

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {

		File xlssFile = new File(System.getProperty("user.dir") + "//testdata//" + fileName);

		// xlsx file
		XSSFWorkbook xssfWorkBook = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		List<User> userList = null;
		try {
			xssfWorkBook = new XSSFWorkbook(xlssFile);
			userList = new ArrayList<User>();
			
			XSSFSheet xssfSheet = xssfWorkBook.getSheet("LoginTestData");
			Iterator<Row> rowIterator = xssfSheet.iterator();
			rowIterator.hasNext(); // to skip the first row which is header row

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			}
			xssfWorkBook.close();
		}
		 
			catch (InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
		return userList.iterator();


	}

}

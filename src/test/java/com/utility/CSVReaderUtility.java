package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile (String fileName)  {
		File csvFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null ;
		User userData;
		try {
			 fileReader = new FileReader(csvFile);
			 csvReader= new CSVReader(fileReader);
			 csvReader.readNext(); //Read row 1 which is header row and ignore it
			 
			 userList = new ArrayList<User>();
			 
			 while((line=csvReader.readNext())!=null) {
				 userData = new User(line[0],line[1]);
				 userList.add(userData);
				 
			 }
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		  catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
		
	}

}

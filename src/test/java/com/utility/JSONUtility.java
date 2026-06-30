package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JSONUtility {
	
	/**
	 * Simple main to run this utility from the IDE or command line.
	 *
	 * Steps performed:
	 * 1. Create a Gson instance to perform JSON -> Java conversions.
	 * 2. Locate the config.json file inside the project's config folder.
	 * 3. Create a FileReader for the JSON file.
	 * 4. Deserialize the JSON into a Config object.
	 * 5. Lookup the Environment object for the "QA" environment and print its URL.
	 *
	 * Note: This method throws FileNotFoundException if the file is missing. In a
	 * real automation framework you might want to handle that more gracefully.
	 * @return 
	 */
	public static String readJSON(Env env) {
		// 1) Create a Gson object. Gson is a library that converts JSON strings
		//    into Java objects and vice-versa.
		Gson gson = new Gson();
		
		// 2) Build the path to the JSON file. System.getProperty("user.dir") returns
		//    the current working directory of the JVM (typically the project root
		//    when running from an IDE). We then append the relative path to our
		//    config file. On Windows we escape backslashes (\\).
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		
		// 3) FileReader will read the contents of the file so Gson can parse it.
		//    It throws FileNotFoundException if the file does not exist.
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		// 4) Deserialize JSON to the Config POJO. Gson will inspect the JSON and
		//    populate the fields of Config (including nested Environment objects).
		Config config = gson.fromJson(fileReader, Config.class);
		
		// 5) Retrieve a specific environment by its key ("QA" here). The
		//    getEnvironments() method returns a Map<String, Environment>.
		Environment environment = config.getEnvironments().get("QA");
		return environment.getUrl();
	}

}
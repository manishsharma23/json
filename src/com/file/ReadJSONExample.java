package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {
	@SuppressWarnings("unchecked")
	
	public static  void jsonParsingStream_java8() throws FileNotFoundException, IOException, ParseException {
		Object obj = null;
		JSONParser parser = new JSONParser();
		   //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
		 //Read JSON file
        obj = jsonParser.parse(new FileReader("D:\\enviroment.json\\"));
    	JSONObject unitsJson = (JSONObject) obj;

		// JSONArray units = (JSONArray) unitsJson.get("environments");

		// getting phoneNumbers
		JSONArray ja = (JSONArray) unitsJson.get("environments");
         
        //Iterate over employee array
        ja.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
	}
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		
		jsonParsing();
	}


	public static  void jsonParsing() throws FileNotFoundException, IOException, ParseException {
		

		Object obj = null;
		JSONParser parser = new JSONParser();
		Object unitsObj = parser.parse(new FileReader("D:\\enviroment.json\\"));
		JSONObject unitsJson = (JSONObject) unitsObj;

		// JSONArray units = (JSONArray) unitsJson.get("environments");

		// getting phoneNumbers
		JSONArray ja = (JSONArray) unitsJson.get("environments");

		// iterating phoneNumbers
		Iterator itr2 = ja.iterator();

		for (int x = 0; x < ja.size(); x++) {

			System.out.println(ja.get(x));

			// Get employee object within list
			JSONObject employeeObject = (JSONObject) ja.get(x);

			// Get employee first name
			String scriptPath = (String) employeeObject.get("scriptPath");
			System.out.println("scriptPath...>>>"+scriptPath);

			String server = (String) employeeObject.get("server");
			System.out.println("server name....>>>"+server);

			// getting phoneNumbers
			JSONArray databases = (JSONArray) employeeObject.get("Databases");

			for (int y = 0; y < databases.size(); y++) {

				System.out.println("Databases....>>>"+databases.get(y));

				/*
				 * // Get employee object within list JSONObject dbobj = (JSONObject)
				 * databases.get(x);
				 * 
				 * String pass = (String) dbobj.get("password");
				 * 
				 * System.out.println(pass);
				 * 
				 * String name = (String) dbobj.get("name");
				 * 
				 * System.out.println(name);
				 * 
				 * String username = (String) dbobj.get("username");
				 * 
				 * System.out.println(username);
				 */

			}

			Long id = (Long) employeeObject.get("id");
			System.out.println(id);
		}

	
	}

	private static void parseEmployeeObject(JSONObject employee) {
		// Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get("Databases");

		// Get employee first name
		String firstName = (String) employeeObject.get("name");
		System.out.println(firstName);

		// Get employee last name
		String lastName = (String) employeeObject.get("username");
		System.out.println(lastName);

		// Get employee website name
		String website = (String) employeeObject.get("password");
		System.out.println(website);
	}
}
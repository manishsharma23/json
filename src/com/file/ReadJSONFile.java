package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
 
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try {
			InputStream is = new FileInputStream(new File("D:\\enviroment.json\""));

			// Create JsonReader from Json.
			JsonReader reader = Json.createReader(is);

			// Get the JsonObject structure from JsonReader.
			JsonObject obj = reader.readObject();
			reader.close();

			// read string
			System.out.println("Band: " + obj.getString("band"));

			// Get Array
			JsonArray array = obj.getJsonArray("members");
			System.out.println("Members:");
			for (JsonValue value : array) {
				System.out.println(value.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}
	}

	private static void parseEmployeeObject11(JSONObject employee) {
		// Get employee object within list
		JSONArray employeeObjectArry = (JSONArray) employee.get("Databases");
		System.out.println("........." + employeeObjectArry.size());
		/*
		 * //Get employee first name String firstName = (String)
		 * employeeObjectArry.get("name"); System.out.println(firstName);
		 * 
		 * //Get employee last name String lastName = (String)
		 * employeeObject.get("username"); System.out.println(lastName);
		 * 
		 * //Get employee website name String website = (String)
		 * employeeObject.get("password"); System.out.println(website);
		 */
	}
}
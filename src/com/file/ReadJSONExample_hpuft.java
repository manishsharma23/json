package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample_hpuft {
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		jsonParsing("done", "plan selection screen is not displayed");
	}

	static boolean isBlankString(String string) {
		return string == null || string.trim().isEmpty();
	}

	public static void jsonParsing(String inStatus, String inDescription)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object unitsObj = parser.parse(new FileReader("D:\\hpuftjson.json"));
		JSONObject unitsJson = (JSONObject) unitsObj;
		JSONArray ja = (JSONArray) unitsJson.get("issues");
		boolean isStatusDescrition = false;
		for (int x = 0; x < ja.size(); x++) {
			JSONObject ja1 = (JSONObject) ja.get(x);
			JSONObject ja11 = (JSONObject) ja1.get("fields");
			String desc = (String) ja11.get("description").toString().trim();
			JSONObject ja12 = (JSONObject) ja11.get("status");
			String status = (String) ja12.get("name").toString().trim();
			if (!(isBlankString(inStatus) && isBlankString(inDescription))
					&& (status.equalsIgnoreCase(inStatus) && desc.equalsIgnoreCase(inDescription))) {
				System.out.println(status + "....." + desc);
				System.out.println("Corrct...");
				isStatusDescrition = true;
				break;
			}
		}
		System.out.println("....1..." + isStatusDescrition);
	}
}
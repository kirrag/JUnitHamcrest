package ru.netology;

import java.io.IOException;
import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
//import com.google.gson.JsonObject;
//import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;

public class Main {

	public static String readString(String fileName) {
		String json = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String s;
			while ((s = br.readLine()) != null) {
				json = json + s;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/*
	 * jsonToList with org.json.simple not work!!!
	 * public static List<Employee> jsonToList(String json) {
	 * List<Employee> listEmployee = new ArrayList<>();
	 * TypeToken<List<Employee>> listType = new TypeToken<List<Employee>>() {};
	 * 
	 * GsonBuilder builder = new GsonBuilder();
	 * builder.setPrettyPrinting();
	 * Gson gson = builder.create();
	 * 
	 * try {
	 * 
	 * JSONParser parser = new JSONParser();
	 * JSONArray jsonArray = new JSONArray();
	 * jsonArray = (JSONArray) parser.parse(json);
	 * 
	 * 
	 * 
	 * for (Object object : jsonArray) {
	 * Employee employee = gson.fromJson((String) object, listType.getType());
	 * listEmployee.add(employee);
	 * }
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * return listEmployee;
	 * }
	 */

	public static List<Employee> jsonToList(String json) {
		List<Employee> listEmployee = new ArrayList<>();

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		try {
			JsonElement element = JsonParser.parseString(json);
			JsonArray jsonArray = element.getAsJsonArray();
			for (JsonElement e : jsonArray) {
				Employee employee = gson.fromJson(e, Employee.class);
				listEmployee.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEmployee;
	}

	public static void main(String[] args) {
		// JSON -> Object
		//String json3 = readString("");
		String json3 = readString("data.json");
		System.out.println(json3);
		List<Employee> list3 = jsonToList(json3);
		System.out.println(list3.getClass());

		for (Employee e : list3) {
			System.out.println(e);
		}
	}
}

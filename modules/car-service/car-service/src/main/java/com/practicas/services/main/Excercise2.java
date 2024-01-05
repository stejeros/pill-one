package com.practicas.services.main;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.practicas.services.data.DatabaseJson;

public class Excercise2 {

	public static void main(String[] args) {
		restoreloadData();
	}

	@SuppressWarnings("unused")
	private static void restoreloadData() {
		JSONArray array = DatabaseJson.loadDatabase().getData();

		int length = array.length();
		List<String> listCheck = new ArrayList<>(); 
		for(int i = 0; i < length; i++) {
			int random = new SecureRandom().nextInt(length); 
			while(listCheck.contains(""+random)) {
				random = new SecureRandom().nextInt(length);
			}
			listCheck.add(""+random);
			((JSONObject)array.get(i)).put("pk", random);
		}
		
		DatabaseJson.saveFile(array.toString());
		
		for(int i = 0; i < length; i++) {
			System.out.println(((JSONObject)array.get(i)).get("pk"));
		}
	}
	
}

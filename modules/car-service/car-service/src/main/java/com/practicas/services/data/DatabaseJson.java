package com.practicas.services.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class DatabaseJson {

    private static JSONArray _jsonArray;

    private static final Logger _log = Logger.getLogger(DatabaseJson.class.getName());
    
    private static DatabaseJson db;
    
    private DatabaseJson() {
        try{
            loadJSONDB();
        }catch (IOException | JSONException e){
            _log.log(Level.SEVERE, "Error loading database" , e);
        }
    }

    public static DatabaseJson loadDatabase() {

    	if(db == null) {
    		db = new DatabaseJson();
    	}
        return db; 
    }

    private void loadJSONDB() throws IOException, JSONException {

        InputStream inputStream = this.getClass()
                .getClassLoader().getResourceAsStream("cars-id-corregido.json");

        if (inputStream == null) return;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            jsonText.append(buffer.lines().collect(Collectors.joining("\n")));
        }

        _jsonArray = JSONFactoryUtil.createJSONArray( jsonText.toString() );
    }
    
    
    public static void saveFile(String newJsonFile) {
    	
    	BufferedWriter bufferWriter = null;
    	try {
    		FileWriter crunchifyWriter = new FileWriter("/Users/stejeros/Developer/source/practicas/exercise2/exercise2-service/src/main/resources/cars-id-corregido.json", true);

			// Writes text to a character-output stream
			bufferWriter = new BufferedWriter(crunchifyWriter);
			bufferWriter.write(newJsonFile.toString());
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
    }

    public JSONArray getData(){
        return _jsonArray;
    }
    
}

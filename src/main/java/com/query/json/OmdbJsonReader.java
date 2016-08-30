package com.query.json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *   This class contains specific methods to read and extract information from JSON content on www.omdbapi.com 
 * @author davi
 *  
 */
public class OmdbJsonReader implements JsonReader {

	
	/** 
	 * Extract from JSON content info as Title, Year and Director
	 * @param Json file that comes from IMDB.com
	 * @return HashMap with movie information.
	 */
	public HashMap<String, String> readJson(String response) {

		HashMap<String, String> movieInfo = new HashMap<String, String>();
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(response); 
			JSONObject jsonObject = (JSONObject) obj;
			String title = (String) jsonObject.get("Title");
			String year = (String) jsonObject.get("Year");
			String director = (String) jsonObject.get("Director");
			
			movieInfo.put("title", title);
			movieInfo.put("year", year);
			movieInfo.put("director", director);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return movieInfo;
	}


	/**
	 * Extract from a JSON content id's list, also called as imdbID 
	 * @param Json file that comes from IMDB.com
	 * @return List of movie's id.
	 */
	public List<String> getJsonId(String response){
		
		
		List<String> movieId = new ArrayList<String>(); 
		JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(response); 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray movieList = (JSONArray) jsonObject.get("Search");
 
            @SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = movieList.iterator();
            while (iterator.hasNext()) {
            	JSONObject element = iterator.next();            	
            	String id = (String) element.get("imdbID");            	            	
            	movieId.add(id);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return movieId;		
	}

	
	
}


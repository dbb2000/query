package com.query.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.query.json.OmdbJsonReader;
import com.query.printer.Printer;
import com.query.request.HttpRequest;
import com.query.uri.OmdbUri;

public class QueryOmdb extends Query {

	private HttpRequest httpRequest;
	private OmdbJsonReader jsonReader;
	private OmdbUri uri;
	private List<HashMap<String,String>> movieList;

	
	/**
	 * Execute the research using the www.omdbapi.com API
	 * @param nameSearch 
	 */
	@Override
	public void run(String nameSearch){
		
		this.uri = new OmdbUri();
		this.httpRequest = new HttpRequest();
		this.jsonReader = new OmdbJsonReader();
		
		try {
			
			this.movieList = new ArrayList<HashMap<String,String>>();
			
			//Obtain URI
			String builtUri = this.uri.buildUri(nameSearch);
			
			//Obtain JSON response
			String response = this.httpRequest.sendResquest(builtUri);
			
			//Obtain Id's list
			List<String> idList = jsonReader.getJsonId(response);
						
			for (String movieId : idList) {
				String builtUriId = this.uri.buildUri(movieId);
				String responsePerId = this.httpRequest.sendResquest(builtUriId);
				HashMap<String, String> movie = jsonReader.readJson(responsePerId);
				movieList.add(movie);				
			}
			
			Printer printer =  new Printer();
			printer.printerResult(movieList);
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
}

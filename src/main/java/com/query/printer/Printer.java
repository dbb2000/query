package com.query.printer;

import java.util.HashMap;
import java.util.List;

public class Printer {

	/**
	 * Print the results found on screen.
	 * Informations shown are Title, Year and Director
	 * @param movieList
	 */
	public void printerResult(List<HashMap<String, String>> movieList){
		
		System.out.println("Movies list:");
		
		for (HashMap<String, String> movie : movieList) {
			String title =  movie.get("title");
			String year = movie.get("year");
			String director = movie.get("director");
			
			System.out.println("Movie: " + title + " Year: " + year + " Director: " + director);
		}
	}
}

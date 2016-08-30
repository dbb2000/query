package com.query.program;

import com.query.factory.Query;
import com.query.factory.QueryFactory;

import Execption.QueryException;

public class Program {

	private static String api;
	private static String movie;
	
	public static void main(String[] args) {
				
		if(args.length != 2){			
			throw new QueryException("Usage example: java -jar querie.jar Dapi=omdb Dmovie=\"Indiana Jones\"");			
		}
		
		for( String arg : args){
			
			String[] parts = arg.split("=");
						
			if (parts[0].contains("Dapi")){
				api = parts[1];
			
			}else if(parts[0].contains("Dmovie")){
			
				String temp = parts[1];
				movie = temp.replace(" ", "+");
			} else{
				throw new QueryException("Possible arguments MUST be [Dapi] and [Dmovie]");
			}
		}

		QueryFactory queryFactory = new QueryFactory();
		Query query = queryFactory.getQuery(api);
		query.run(movie);
		
	}

}

package com.query.factory;

import Execption.QueryException;

public class QueryFactory {

	/**
	 * This class implements Factory Design Pattern.
	 * Chooses the right Query specialisation to create according to a given API in <strong>Dapi=</strong> parameter 
	 * 
	 * @param searchBase
	 * @return Query object
	 */
	public Query getQuery(String searchBase){

		if(searchBase.equals(QueryApiEnum.OMDB.getApi())){
			
			return new QueryOmdb();			
			
		} else {
			throw new QueryException("valid API options: [omdb] ");			
		}		
		
	}
}

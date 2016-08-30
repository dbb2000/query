package com.query.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.query.uri.OmdbUri;

public class OmdbUriTest {

	@Test
	public void testBuildUri() {
		
		String nameSearch = "Indiana Jones";
		String uriNameSeach = "http://www.omdbapi.com/?s=Indiana Jones&type=movie&r=json";
		
		String idSearch = "tt0154004";
		String uriIdSearch = "http://www.omdbapi.com/?i=tt0154004&plot=short&r=json";
		
		OmdbUri uri = new OmdbUri();
		
		String resultSearch = uri.buildUri(nameSearch);
		assertEquals(uriNameSeach, resultSearch);
		
		String resultId = uri.buildUri(idSearch);
		assertEquals(uriIdSearch, resultId);
	}
	
	
	
	@Test
	public void testIsID(){
		
		String nameSearch = "Indiana Jones";
		String idSearch = "tt0154004";
		
		OmdbUri uri = new OmdbUri();
		boolean resultFalse = uri.isID(nameSearch);
		assertFalse(resultFalse);
		
		boolean resultTrue = uri.isID(idSearch);
		assertTrue(resultTrue);
		
	}

}

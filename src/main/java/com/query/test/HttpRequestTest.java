package com.query.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.query.request.HttpRequest;

public class HttpRequestTest {

	@Test
	public void testSendResquest() throws Exception {
		HttpRequest con = new HttpRequest();
		String uri = "http://www.omdbapi.com/?i=tt0154004&plot=short&r=json";
		
		String JsonResponse = "{\"Title\":\"The Adventures of Young Indiana Jones: Attack of the Hawkmen\","
				+ "\"Year\":\"1995\","
				+ "\"Rated\":\"N/A\","
				+ "\"Released\":\"08 Oct 1995\","
				+ "\"Runtime\":\"96 min\","
				+ "\"Genre\":\"Adventure, War\","
				+ "\"Director\":\"Ben Burtt\","
				+ "\"Writer\":\"Matthew Jacobs (teleplay), Rosemary Anne Sisson (teleplay), Ben Burtt (teleplay), George Lucas (characters)\","
				+ "\"Actors\":\"Sean Patrick Flanery, Ronny Coutteure, Patrick Toomey, Marc Warren\","
				+ "\"Plot\":\"Young Indiana Jones takes to the skies in the new French air force, and parachutes into Germany to convince"
						  + " Anthony Fokker to defect.\","
				+ "\"Language\":\"English\","
				+ "\"Country\":\"USA\","
				+ "\"Awards\":\"N/A\","
				+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTcwMTU5NjExMV5BMl5BanBnXkFtZTYwNzU3MTA5._V1_SX300.jpg\","
				+ "\"Metascore\":\"N/A\","
				+ "\"imdbRating\":\"6.8\","
				+ "\"imdbVotes\":\"454\","
				+ "\"imdbID\":\"tt0154004\","
				+ "\"Type\":\"movie\","
				+ "\"Response\":\"True\"}";
		
		String result = con.sendResquest(uri);
		
		assertEquals(JsonResponse, result);
			
	}

}

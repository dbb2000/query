package com.query.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.query.json.OmdbJsonReader;

public class OmdbJsonReaderTest {

	@SuppressWarnings("unused")
	@Deprecated
	private final String uriToGetId= "http://www.omdbapi.com/?s=Indiana+Jones&type=movie&r=json";
	
	@SuppressWarnings("unused")
	@Deprecated
	private final String uriToGetmovieInfo= "http://www.omdbapi.com/?i=tt0154004&plot=short&r=json";
	
	
	
	private final String jsonResponseById = "{\"Search\":"
			+ "[{\"Title\":\"Indiana Jones and the Last Crusade\","
			+ "\"Year\":\"1989\","
			+ "\"imdbID\":\"tt0097576\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMjNkMzc2N2QtNjVlNS00ZTk5LTg0MTgtODY2MDAwNTMwZjBjXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"Indiana Jones and the Kingdom of the Crystal Skull\","
			+ "\"Year\":\"2008\","
			+ "\"imdbID\":\"tt0367882\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTIxNDUxNzcyMl5BMl5BanBnXkFtZTcwNTgwOTI3MQ@@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"Indiana Jones and the Temple of Doom\","
			+ "\"Year\":\"1984\","
			+ "\"imdbID\":\"tt0087469\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTMyNzI4OTA5OV5BMl5BanBnXkFtZTcwMDQ2MjAxNA@@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"Indiana Jones and the Temple of the Forbidden Eye\","
			+ "\"Year\":\"1995\","
			+ "\"imdbID\":\"tt0764648\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"N/A\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Treasure of the Peacock's Eye\","
			+ "\"Year\":\"1995\","
			+ "\"imdbID\":\"tt0115031\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BOTg2MTc2NDAzOF5BMl5BanBnXkFtZTcwODExNDIyMQ@@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Attack of the Hawkmen\","
			+ "\"Year\":\"1995\","
			+ "\"imdbID\":\"tt0154004\","
			+ "\"Type\":\"movie\""
			+ ",\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTcwMTU5NjExMV5BMl5BanBnXkFtZTYwNzU3MTA5._V1_SX300.jpg\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Adventures in the Secret Service\","
			+ "\"Year\":\"2000\","
			+ "\"imdbID\":\"tt0250196\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMzI1MDYzODM0MF5BMl5BanBnXkFtZTcwOTYwNjAyMQ@@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Daredevils of the Desert\","
			+ "\"Year\":\"1999\","
			+ "\"imdbID\":\"tt0275186\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BZDQ0NGI4ZjktYmQyNC00ZDZhLTgyMGYtYjU1Zjg5N2YzZDRlXkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Trenches of Hell\","
			+ "\"Year\":\"1999\","
			+ "\"imdbID\":\"tt0250199\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BNzgzMDQxNjY3N15BMl5BanBnXkFtZTcwODQ0NTgxMQ@@._V1_SX300.jpg\"},"
			+ "{\"Title\":\"The Adventures of Young Indiana Jones: Spring Break Adventure\","
			+ "\"Year\":\"1999\","
			+ "\"imdbID\":\"tt0250198\","
			+ "\"Type\":\"movie\","
			+ "\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMzQ5MzI2NTgwMl5BMl5BanBnXkFtZTcwMzQ3MzQyMQ@@._V1_SX300.jpg\"}],"
			+ "\"totalResults\":\"63\",\"Response\":\"True\"}";
	
	private final String jsonResponseSingleMovie = "{\"Title\":\"The Adventures of Young Indiana Jones: Attack of the Hawkmen\","
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
	
	@Test
	public void testReadJson() throws Exception {

		HashMap<String, String> fakeMovieInfo = new HashMap<String, String>();
		fakeMovieInfo.put("title", "The Adventures of Young Indiana Jones: Attack of the Hawkmen");
		fakeMovieInfo.put("year", "1995");
		fakeMovieInfo.put("director", "Ben Burtt");
		
		OmdbJsonReader jsonReader = new OmdbJsonReader();
		HashMap<String, String> result  = jsonReader.readJson(jsonResponseSingleMovie);
		
		assertEquals(fakeMovieInfo, result);
		
	}

	@Test
	public void testGetJsonId() throws Exception {
		
		List<String> fakeMovieId =  new ArrayList<String>();
		fakeMovieId.add("tt0097576");
		fakeMovieId.add("tt0367882");
		fakeMovieId.add("tt0087469");
		fakeMovieId.add("tt0764648");
		fakeMovieId.add("tt0115031");
		fakeMovieId.add("tt0154004");
		fakeMovieId.add("tt0250196");
		fakeMovieId.add("tt0275186");
		fakeMovieId.add("tt0250199");
		fakeMovieId.add("tt0250198");

		
//		HttpRequest resquest = new HttpRequest();
//		String response = resquest.sendResquest(jsonResponseById);
		
		OmdbJsonReader jsonReader = new OmdbJsonReader();
		List<String> result = jsonReader.getJsonId(jsonResponseById);
		
		assertEquals(fakeMovieId, result);
		
	}

}

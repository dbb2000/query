package com.query.request;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

	
	/**
	 * Send a given request to some public API 
	 * @param uri
	 * @return (String) response, usually in JSON/XML format
	 * @throws Exception
	 */
	public String sendResquest(String uri) throws Exception {

		URL obj = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();
		return response.toString();			
	}
}
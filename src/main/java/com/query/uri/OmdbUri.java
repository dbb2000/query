package com.query.uri;

public class OmdbUri implements Uri {

	
	
	/** build a appropriate URI according to information given. 
	 * For OMDB API the possibilities are movie name or id 
	 * @param nameSearch
	 * @return (String) built URI ready for use
	 */
	public String buildUri(String nameSearch) {

		StringBuffer st = new StringBuffer();
				
		if(isID(nameSearch)){
			st.append("http://www.omdbapi.com/");
			st.append("?i=" + nameSearch);
			st.append("&plot=short");
			st.append("&r=json");
			
		}else {			
			st.append("http://www.omdbapi.com/");
			st.append("?s=" + nameSearch);
			st.append("&type=movie");
			st.append("&r=json");
		}				
		return st.toString();
	}

	
	/**
	 * Define whether the string is a given ID or movie name.
	 * @param nameSearch
	 * @return boolean
	 */
	public boolean isID(String nameSearch){
		
		if(nameSearch.charAt(0) == 't' && nameSearch.charAt(1) == 't'){
			return true;
		}		
		return false;
	}

	

}

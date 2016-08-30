package com.query.factory;

public enum QueryApiEnum {

	OMDB("omdb");
	
	private final String api;
	
	QueryApiEnum(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
	
	
}

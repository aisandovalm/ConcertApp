package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmAttrModel {
	
	@JsonProperty("location")
	public String location; 

	@JsonProperty("page")
	public int page; 
	
	@JsonProperty("perPage")
	public int perPage;
	
	@JsonProperty("totalPages")
	public int totalPages;
	
	@JsonProperty("total")
	public int total;
	
	@JsonProperty("festivalsonly")
	public int festivalsonly;
	
	@JsonProperty("tag")
	public String tag;
}

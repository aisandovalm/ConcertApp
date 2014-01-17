package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmVenueModel {
		
	@JsonProperty("id")
	public String id;
		
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("location")
	public LastfmLocationModel location;

	@JsonProperty("url")
	public String url;	

	@JsonProperty("website")
	public String website;
	
	@JsonProperty("phonenumber")
	public String phonenumber;
	
	@JsonProperty("image")
	public List<LastfmImageModel> image;
	
}

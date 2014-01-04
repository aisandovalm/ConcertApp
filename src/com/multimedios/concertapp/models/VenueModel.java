package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VenueModel {
	
//	@JsonProperty("metroArea")
//	public MetroAreaModel metroArea;
	
	@JsonProperty("displayName")
	public String displayName;
	
	@JsonProperty("lat")
	public double lat;

	@JsonProperty("uri")
	public String uri;
	
	@JsonProperty("id")
	public int id;
	
	@JsonProperty("lng")
	public double lng;

}

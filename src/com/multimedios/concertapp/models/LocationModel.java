package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationModel {
	
	@JsonProperty("city")
	public String city;
	
	@JsonProperty("lat")
	public double lat;

	@JsonProperty("lng")
	public double lng;
}

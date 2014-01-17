package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmLocationModel {
	
	@JsonProperty("geo:point")
	public LastfmGeoPointModel geoPoint;
	
	@JsonProperty("city")
	public String city;
	
	@JsonProperty("country")
	public String country;

	@JsonProperty("street")
	public String street;
	
	@JsonProperty("postalcode")
	public String postalcode;
}

package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmGeoPointModel {
	
	@JsonProperty("geo:lat")
	public double geoLat;

	@JsonProperty("geo:long")
	public double geoLong;
}

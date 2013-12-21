package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ArtistModel {
	
	@JsonProperty("displayName")
	public String displayName;
	
	@JsonProperty("uri")
	public String uri;

	@JsonProperty("id")
	public int id;
}

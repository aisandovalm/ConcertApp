package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PerformanceModel {
	
	@JsonProperty("billingIndex")
	public int billingIndex;
	
	
	@JsonProperty("displayName")
	public String displayName;
	
//	@JsonProperty("artist")
	//public ArtistModel artist;
	
	@JsonProperty("billing")
	public String billing;
	
	@JsonProperty("id")
	public int id;
	
}

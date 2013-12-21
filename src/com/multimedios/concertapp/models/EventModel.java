package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EventModel {
	
	@JsonProperty("type")
	public String type;

	@JsonProperty("performance")
	public List<PerformanceModel> performanceList;
	
	@JsonProperty("venue")
	public VenueModel venue;
	
	@JsonProperty("status")
	public String status;
	
	@JsonProperty("displayName")
	public String displayName;

	@JsonProperty("start")
	public StartModel start; 
	
	@JsonProperty("location")
	public LocationModel location;
	
	@JsonProperty("popularity")
	public String popularity;
	
	@JsonProperty("ageRestriction")
	public String ageRestriction;
	
	@JsonProperty("uri")
	public String uri;

	@JsonProperty("id")
	public int id;
}

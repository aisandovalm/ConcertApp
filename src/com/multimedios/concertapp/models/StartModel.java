package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StartModel {
	
	@JsonProperty("time")
	public String startTime;
	
	@JsonProperty("datetime")
	public String startDateTime;

	@JsonProperty("date")
	public String startDate;
}

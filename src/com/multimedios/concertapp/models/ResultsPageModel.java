package com.multimedios.concertapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultsPageModel {
	
	@JsonProperty("status")
	public String status;
	
	@JsonProperty("results")
	public ResultsModel results;

}

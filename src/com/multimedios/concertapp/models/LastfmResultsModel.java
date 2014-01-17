package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmResultsModel {
	
	@JsonProperty("event")
	public List<LastfmEventModel> event;
	

}

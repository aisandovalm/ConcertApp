package com.multimedios.concertapp.models;

//import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmArtistsModel {
	
	//@JsonProperty("artist")
	//public List<LastfmArtistModel> artist; //lista de acompañantes del principal
	
	@JsonProperty("headliner")
	public String headliner; 	//artista principal
	
}

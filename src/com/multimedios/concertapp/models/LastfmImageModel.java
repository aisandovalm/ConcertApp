package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmImageModel {
	
	@JsonProperty("#text")
	public String urlImagen; 
	
	@JsonProperty("size")
	public String size; 	
	
}

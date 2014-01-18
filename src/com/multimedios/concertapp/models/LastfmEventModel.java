package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmEventModel {
	
	@JsonProperty("id")
	public int id;
	
	@JsonProperty("title")
	public String title;
	
	@JsonProperty("artists") //cambiar a lista
	public LastfmArtistsModel artists;

	@JsonProperty("venue") //cambiar a lista
	public LastfmVenueModel venue;
	
	@JsonProperty("startDate")
	public String startDate;
	
	@JsonProperty("endDate")
	public String endDate;
	
	@JsonProperty("description")
	public String description;
	
	@JsonProperty("url")
	public String url;
	
	@JsonProperty("image")
	public List<LastfmImageModel> image;
	
	@JsonProperty("website")
	public String website;
}

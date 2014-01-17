package com.multimedios.concertapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LastfmEventsModel {
		
	@JsonProperty("event")
	public List<LastfmEventModel> event; //contiene los eventos 

	@JsonProperty("@attr")
	public LastfmAttrModel attr; //cotiene los eventos
	//otro atributo que no se incluye
}

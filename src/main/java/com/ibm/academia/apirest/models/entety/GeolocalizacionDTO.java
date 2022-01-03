package com.ibm.academia.apirest.models.entety;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GeolocalizacionDTO implements Serializable{
	
	@JsonProperty("Servicios")
	private HashMap<String, HashMap<String, HashMap<String, List<String>>>> servicios;
	private static final long serialVersionUID = 8495957011297898873L;
	
	
	

}

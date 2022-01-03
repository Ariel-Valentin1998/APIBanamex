package com.ibm.academia.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.academia.apirest.models.entety.GeolocalizacionDTO;

@RestController
@RequestMapping("/banco")
public class ControllerCajeros 
{
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/listado")
	public String obtenerDatosJson()
	{  
		try {
		String url = "https://www.banamex.com/localizador/jsonP/json5.json";
		String geolocalizacion = restTemplate.getForObject(url, String.class);
		geolocalizacion = geolocalizacion.substring(geolocalizacion.indexOf("(") + 1, geolocalizacion.lastIndexOf(")"));
		ObjectMapper mapper = new ObjectMapper();
		GeolocalizacionDTO geolocalizacionDTO = mapper.readValue(geolocalizacion,GeolocalizacionDTO.class);
		List<String> lista = geolocalizacionDTO.getServicios().get("100").get("0").get("1");
		lista.forEach(System.out::println);
		}catch (Exception e) {
			e.getMessage();
	}
		return " ";
	}
}

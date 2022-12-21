package com.inti.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Achat;
import com.inti.model.Location;

@RestController
public class GerantController {

	@Autowired
	ProducerTemplate producerTemplate;

	private final Logger logA = LoggerFactory.getLogger(Achat.class);
	private final Logger logL = LoggerFactory.getLogger(Location.class);

	//READ
	
	@GetMapping(name="/getAchats")
	public List<Achat> getlisteAchats(){
		List<Achat> listeAchats = producerTemplate.requestBody("direct:select", null, List.class);
		logA.info("récupération des achats : "+ listeAchats);
		return listeAchats;
	}

	@GetMapping(name = "/getLocations")
	public List<Location> getlisteLocations() {
		List<Location> listeLocations = producerTemplate.requestBody("direct:select", null, List.class);
		logL.info("récupération des locations : " + listeLocations);
		return listeLocations;
	}
	
	@GetMapping(name="/getAchat/{id}")
	public Achat getAchat(@PathVariable int id) {
		Achat achat = producerTemplate.requestBody("direct:select", null, Achat.class);
		return achat;
	}
	
	@GetMapping(name="/getLocation/{id}")
	public Location getLocation(@PathVariable int id) {
		Location location = producerTemplate.requestBody("direct:select", null, Location.class);
		return location;
	}
	
	//CREATE
	
	@PostMapping(name="/saveAchat")
	public void saveAchat(@RequestBody Achat achat) {
		logA.info("Achat sauvegardé");
		producerTemplate.requestBody("direct:insert", achat, List.class);
	}
	
	@PostMapping(name="/saveLocation")
	public void saveLocation(@RequestBody Location location) {
		logL.info("Location sauvegardée");
		producerTemplate.requestBody("direct:insert", location, List.class);
	}
	
	//DELETE
	
//	@DeleteMapping(name="/deleteAchat/{id}")
//	public void deleteAchat(@PathVariable int id) {
//		producerTemplate.requestBody("direct:delete", null, null);
//	}
}

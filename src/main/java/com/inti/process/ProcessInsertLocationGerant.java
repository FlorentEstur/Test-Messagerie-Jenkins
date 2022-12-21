package com.inti.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


import com.inti.model.Location;

public class ProcessInsertLocationGerant implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Location location = exchange.getIn().getBody(Location.class);
		String query = "Insert Into Location_Projet (id, adresse, description, piece, chambre, prixParMois, surface, ascenceur, parking) values (" + location.getId() + ", '" + location.getAdresse() + ", '" + location.getDescription() + ", '" + location.getPiece() + ", '" + location.getChambre() + ", '" + location.getPrixParMois() + ", '" + location.getSurface() + ", '" + location.isAscenceur() + ", '" + location.isParking() + "')";
		exchange.getIn().setBody(query);
		
	}

}

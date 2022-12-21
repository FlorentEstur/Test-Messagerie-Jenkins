package com.inti.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.inti.model.Achat;

public class ProcessInsertAchatGerant implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Achat achat = exchange.getIn().getBody(Achat.class);
		String query = "Insert Into Achat_Projet (id, adresse, description, piece, chambre, prixAchat, surface, ascenceur, parking) values (" + achat.getId() + ", '" + achat.getAdresse() + ", '" + achat.getDescription() + ", '" + achat.getPiece() + ", '" + achat.getChambre() + ", '" + achat.getPrixAchat() + ", '" + achat.getSurface() + ", '" + achat.isAscenceur() + ", '" + achat.isParking() + "')";
		exchange.getIn().setBody(query);
	}

}

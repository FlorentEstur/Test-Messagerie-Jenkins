package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Achat_Projet")
public class Achat {

	@Id
	private int id;
	private String adresse, description;
	private int piece, chambre;
	private double prixAchat, surface;
	private boolean ascenceur, parking;
	
	public Achat() {
		super();
	}

	public Achat(int id, String adresse, String description, int piece, int chambre, double prixAchat,
			double surface, boolean ascenceur, boolean parking) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.description = description;
		this.piece = piece;
		this.chambre = chambre;
		this.prixAchat = prixAchat;
		this.surface = surface;
		this.ascenceur = ascenceur;
		this.parking = parking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	public int getChambre() {
		return chambre;
	}

	public void setChambre(int chambre) {
		this.chambre = chambre;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public boolean isAscenceur() {
		return ascenceur;
	}

	public void setAscenceur(boolean ascenceur) {
		this.ascenceur = ascenceur;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", adresse=" + adresse + ", description=" + description + ", piece=" + piece
				+ ", chambre=" + chambre + ", prixAchat=" + prixAchat + ", surface=" + surface + ", ascenceur="
				+ ascenceur + ", parking=" + parking + "]";
	}
	
}

package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Location_Projet")
public class Location {

	@Id
	private int id;
	private String adresse, description;
	private int piece, chambre;
	private double prixParMois, surface;
	private boolean ascenceur, parking;
	
	public Location() {
		super();
	}

	public Location(int id, String adresse, String description, int piece, int chambre, double prixParMois,
			double surface, boolean ascenceur, boolean parking) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.description = description;
		this.piece = piece;
		this.chambre = chambre;
		this.prixParMois = prixParMois;
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

	public double getPrixParMois() {
		return prixParMois;
	}

	public void setPrixParMois(double prixParMois) {
		this.prixParMois = prixParMois;
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
				+ ", chambre=" + chambre + ", prixParMois=" + prixParMois + ", surface=" + surface + ", ascenceur="
				+ ascenceur + ", parking=" + parking + "]";
	}
	
}

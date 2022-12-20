package com.inti;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GerantProjet")
public class Gerant {

	@Id
	private int id;
	private String nom, utilisateur, mdp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAdmin")
	private Admin admin;
	
	public Gerant() {
		super();
	}

	public Gerant(int id, String nom, String utilisateur, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.utilisateur = utilisateur;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + nom + ", utilisateur=" + utilisateur + ", mdp=" + mdp + "]";
	}
	
}

package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.inti.model.Gerant;

@Entity
@Table(name="Admin_Projet")
public class Admin {
	
	@javax.persistence.Id
	private int Id;
	private String nom;
	private String username;
	private String password;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "admin")
	private List<Client> listeClient;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "admin")
	private List<Gerant> listeGerant;
	
	public Admin() {
		super();
	}


	public Admin(int id, String nom, String username, String password) {
		super();
		Id = id;
		this.nom = nom;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", nom=" + nom + ", username=" + username + ", password=" + password + "]";
	}

	
	
}

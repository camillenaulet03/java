package fr.imie.bank.model;

import java.time.*;

public class Person {
	public int id;
	public String prenom;
	public String nom;
	public LocalDate ddn;
	public String email;
	
	public Person(int id, String prenom, String nom, LocalDate ddn , String email) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.ddn = ddn;
		this.email = email;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getAge() {
		return id;
	}
	
	public void setAge(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", date de naissance=" + ddn + ", email=" + email + "]\n";
	}
	
}

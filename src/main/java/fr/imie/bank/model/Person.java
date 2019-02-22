package fr.imie.bank.model;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Person {
	public int id;
	public String prenom;
	public String nom;
	public LocalDate ddn;
	public String email;
	public List<BankAccount> comptes = new ArrayList<BankAccount>();
	
	public Person(int id, String prenom, String nom, LocalDate ddn , String email, List<BankAccount> comptes) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.ddn = ddn;
		this.email = email;
		this.comptes = comptes;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public List<BankAccount> getComptes() {
		return comptes;
	}

	public void setComptes(List<BankAccount> comptes) {
		this.comptes = comptes;;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Person [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", date de naissance=" + ddn + ", email=" + email + ", compte =" + comptes.toString() + "]\n";
	}	
}

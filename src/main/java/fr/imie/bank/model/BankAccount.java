package fr.imie.bank.model;

public class BankAccount {
	public int id;
	public int number;
	public int idPers;
	public float solde;
	
	
	public BankAccount(int id, int number, int idPers, float solde) {
		this.id = id;
		this.number = number;
		this.idPers = idPers;
		this.solde = solde;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdPers() {
		return idPers;
	}

	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "BankAccount [number=" + number + ", id=" + id + ", idPers=" + idPers + ", solde=" + solde + "]";
	}

}

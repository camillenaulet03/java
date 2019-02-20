package fr.imie.bank.model;

public class BankAccount {
	public Integer number;
	public int id;
	
	
	public BankAccount(Integer number, int id) {
		super();
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public int getAge() {
		return id;
	}
	
	public void setAge(int id) {
		this.id = id;
	}
}
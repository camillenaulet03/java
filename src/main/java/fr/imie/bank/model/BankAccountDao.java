package fr.imie.bank.model;

import java.util.List;

public interface BankAccountDao {

	public List<BankAccount> findAll();
	public BankAccount findById(int id);
	public void save(BankAccount person);
	public void saveAll(List<BankAccount> people);

}
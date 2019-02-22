package fr.imie.bank.csv;

import java.util.ArrayList;
import java.util.List;

import fr.imie.bank.model.BankAccount;

public class DaoCsvBankAccount {
	
	
	public static ArrayList FindAllByIdPerson(List<BankAccount> comptes, int id) {
		
		while ((line = reader.readLine()) != null) {
				
		        rows.add(Arrays.asList(line.split(",")));
		        
	}	

	public static ArrayList FindAllByIdPerson(List<BankAccount> comptes, int id) {
		
		ArrayList reponse = new ArrayList();
		int i = 0;
		
		do {
			if (comptes.get(i).getIdPers() == id) {
				reponse.add(i);
			}
			i++;
		}while(i < comptes.size());
		
		return reponse;
	}	
}

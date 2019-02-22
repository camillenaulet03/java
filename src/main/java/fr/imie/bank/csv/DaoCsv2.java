package fr.imie.bank.csv;

import fr.imie.bank.model.*;

public class DaoCsv2 {
		
	public static BankAccount toObject(String text) {
		
		int id = 0;
		int idPers = 0;
		int number = 0;
		Float solde = 0.0f;
		
		if (text==null || text.isEmpty()) {
			BankAccount bankStr = null;
			return bankStr;
		}else {
			String[] parts = text.split(";");	
			try{		
				id = Integer.parseInt(parts[0]);
				number = Integer.parseInt(parts[0]);
				idPers = Integer.parseInt(parts[0]);
				solde = Float.parseFloat(parts[0]);
			}catch(NumberFormatException e){
				System.out.println("La liste est incomplete");
			}
			
			return new BankAccount(id,number,idPers,solde);		
		}
	}
	
	public static String toString(BankAccount compte) {
		
		String id = "";
		String number = "";
		String idPers = "";
		String solde = "";
		
		if (compte==null ) {
			String bankStr = null;
			return bankStr;
		}else {	
			id = Integer.toString(compte.getId());
			number = Integer.toString(compte.getNumber());
			idPers = Integer.toString(compte.getIdPers());
			solde = Float.toString(compte.getSolde());
			
			String phFinal =  id + ";" + number + ";" + idPers + ";"+ solde;
			return phFinal;
		}				
	}
}

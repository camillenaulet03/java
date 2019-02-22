package fr.imie.bank.csv;

import fr.imie.bank.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoCsv1 {
	
	public static Person toObject(String text) {
		
		boolean repB= true;
		int id = 0;
		List<BankAccount> listComp = new ArrayList<BankAccount>();
				
		if (text==null || text.isEmpty()) {
			Person personStr = null;
			return personStr;
		}else {
			String[] parts = text.split(";");
			
			try{		
				id = Integer.parseInt(parts[0]);
			}catch(NumberFormatException e){
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
			
			LocalDate ddn = DateUtils.toDate(parts[3]);
			
//			DaoCsvBankAccount.FindAllByIdPerson(comptes, id)
//			
//			do {
//				try {
//					BankAccount compte = null;
//					
//					new BankAccount();
//					listComp.add(compte)
//				}catch(IOexception e) {
//					
//				}
//				
//			}while(repB);
//			
			
			return null;
//		new Person(id,parts[1],parts[2],ddn,parts[4]);
			
		}
	}
	
	public static String toString(Person personne) {
		
		String id = "";
		String nom = "";
		String prenom = "";
		String ddn = "";
		String email = "";
		List comptes = new ArrayList();
		
		if (personne==null ) {
			String bankStr = null;
			return bankStr;
		}else {	
			id = Integer.toString(personne.getId());
			nom = personne.getNom();
			prenom = personne.getPrenom();
			ddn = DateUtils.toString(personne.getDdn());
			email = personne.getPrenom();			
			comptes = personne.getComptes();
			
			String phFinal =  id + ";" + nom + ";" + prenom + ";" + ddn + ";" + email + ";" + comptes ;
			return phFinal;
		}				
	}
}
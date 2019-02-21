package fr.imie.bank;

import fr.imie.bank.model.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainConsole {
	
	public static void FindAll(List<Person> personnes) {  
		int size = personnes.size();
		for (int i = 0; i<size; i++) {
			System.out.print(personnes.get(i));
		}
	   }
	
	
	public static void CreatePer(List<Person> personnes) {  
		
		Person personneCree = null;
		boolean repB = true;
		boolean restartB = true;
		int id = 0;
		String prenom = "";
		String nom = "";
		String ddnE = "";
		LocalDate ddn = LocalDate.now();
		int ddnJ = 0;
		int ddnM = 0;
		int ddnA = 0;
		String email = "";
		
		Scanner sc = new Scanner(System.in);
		
		do {
			personneCree = null;
			repB = true;
		
			System.out.println("Quel est le prenom de cette nouvelle personne ?");
			prenom = sc.nextLine();
			
			System.out.println("Et quel est son nom ?");
			nom = sc.nextLine();
			
			do {
				System.out.println("Sa date de naissance ?(jour/mois/année)");
				
				System.out.println("Jour = ");
				String sDdnJ = sc.nextLine();
				
				System.out.println("Mois = ");
				String sDdnM = sc.nextLine();
				
				System.out.println("Année = ");
				String sDdnA = sc.nextLine();
				
				try {	
					ddnJ = Integer.parseInt(sDdnJ);
					ddnM = Integer.parseInt(sDdnM);
					ddnA = Integer.parseInt(sDdnA);
				}catch(NumberFormatException e){
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
				}
				try {
					ddnE = sDdnJ + "/" + sDdnM + "/" + sDdnA ;
					ddn = LocalDate.parse(ddnE, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					repB = false;
				}catch(DateTimeException e) {
					System.out.println("Vous avez fait une erreur de saisi car la date n'est pas valide");
				}	
			}while(repB);
			
			System.out.println("Et pour finir quel est son adresse email ?");
			email = sc.nextLine();
			
			id = personnes.size()+1;				
			
			personneCree = new Person(id,prenom,nom,ddn,email);			
			
			personnes.add(personneCree);
		
			do{
				System.out.println("Voulez vous saisir une nouvelle personne ?");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					restartB = false;
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);
		}while(restartB);
		sc.close();
	   }
	
	public static void ChangePre(List<Person>personnes, int idModi) {
		
		Scanner sc = new Scanner(System.in);
		
		String prenomModif = "";
		
		System.out.println("Quel nouveau prenom voulez vous à la place de " + personnes.get(idModi).getPrenom() + " :");
		prenomModif = sc.nextLine();
		
		personnes.set(idModi, personnes.get(idModi)).setPrenom(prenomModif);
		sc.close();
	}
	
	public static void ChangeNom(List<Person>personnes, int idModi) {
		
		Scanner sc = new Scanner(System.in);
		
		String nomModif = "";
		
		System.out.println("Quel nouveau nom voulez vous à la place de " + personnes.get(idModi).getNom() + " :");
		nomModif = sc.nextLine();
		
		personnes.set(idModi, personnes.get(idModi)).setNom(nomModif);
		sc.close();
	}
	
	public static void ChangeEmail(List<Person>personnes, int idModi) {
		
		Scanner sc = new Scanner(System.in);
		
		String emailModif = "";
		
		System.out.println("Quel nouvel email voulez vous à la place de " + personnes.get(idModi).getEmail() + " :");
		emailModif = sc.nextLine();
		
		personnes.set(idModi, personnes.get(idModi)).setEmail(emailModif);
		sc.close();
	}

	public static void ChangeDdn(List<Person>personnes, int idModi) {
		
		Scanner sc = new Scanner(System.in);
		
		String ddnE = "";
		LocalDate ddnModif = LocalDate.now();
		int ddnJ = 1;
		int ddnM = 1;
		int ddnA = 1;
		boolean repB = true;
		
		System.out.println("Quel date voulez vous à la place de " + personnes.get(idModi).getDdn() + " :");
		
		do {
				
			System.out.println("Jour = ");
			String sDdnJ = sc.nextLine();
			
			System.out.println("Mois = ");
			String sDdnM = sc.nextLine();
			
			System.out.println("Année = ");
			String sDdnA = sc.nextLine();
			
			try {	
				ddnJ = Integer.parseInt(sDdnJ);
				ddnM = Integer.parseInt(sDdnM);
				ddnA = Integer.parseInt(sDdnA);
			}catch(NumberFormatException e){
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
			try {
				ddnE = sDdnJ + "/" + sDdnM + "/" + sDdnA ;
				System.out.println(ddnE);
				ddnModif = LocalDate.parse(ddnE, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				repB = false;
			}catch(DateTimeException e) {
				System.out.println("Vous avez fait une erreur de saisi car la date n'est pas valide");
			}	
			
		}while(repB);
		
		personnes.set(idModi, personnes.get(idModi)).setDdn(ddnModif);
		sc.close();
	}
	
	public static void ModifiPer(List<Person> personnes) {
		
		Scanner sc = new Scanner(System.in);
		
		int idModi = -100000;
		boolean repB = true;
		boolean restartB = true;
		String choix = "";
		boolean errorB = false;
		
		do {
			System.out.println("Quel profil voulez vous modifier :");
			FindAll(personnes);
			System.out.println("saisissez l'id du compte:");
			
			String sIdModi = sc.nextLine();
			repB = true;
			
			try{		
				idModi = Integer.parseInt(sIdModi)-1;
			}catch(NumberFormatException e){
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");	
			}
			if (idModi == -100000) {}
			else {
			try {
				System.out.print(personnes.get(idModi));
				repB = false;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
			}}
		}while(repB);
		
		repB = true;
		
		do {
            do {
                System.out.println("Que voulez vous modifier dans ce profil (prenom/nom/date de naissance(ddn)/email):");
                choix = sc.nextLine();
                errorB = false;

                switch (choix) {

                    case "prenom" :
                        ChangePre(personnes, idModi);
                        break;

                    case "nom" :
                        ChangeNom(personnes, idModi);
                        break;

                    case "ddn" :
                        ChangeDdn(personnes, idModi);
                        break;

                    case "email" :
                        ChangeEmail(personnes, idModi);
                        break;

                    default :
                        System.out.println("Vous avez tapé une catégorie inéxistante");
                        errorB=true;
                }
            }while(errorB);

                do{
                    System.out.println("Voulez vous modifier autre chose dans ce profil (oui/non):");
                    String rep = sc.nextLine();

                    if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
                        repB = false;
                    } else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
                        restartB = false;
                        repB = false;
                    } else {
                        System.out.println("Votre réponse est éronnée");
                    }
                }while (repB);
        }while(restartB);
		sc.close();
	}
	
	public static void DeletePer(List<Person> personnes) {
		
		Scanner sc = new Scanner(System.in);
		
		int idModi = 0;
		boolean repB = true;
		boolean restartB = true;
		
		do {
			
			repB = true;
			
			do {
				System.out.println("Quel profil voulez vous supprimer :");
				FindAll(personnes);
				System.out.println("saisissez l'id du compte:");
				
				String sIdModi = sc.nextLine();
				
				try{		
					idModi = Integer.parseInt(sIdModi)-1;
				}catch(NumberFormatException e){
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");	
				}
				try {
					System.out.print(personnes.get(idModi));
					repB = false;
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
				}
			}while(repB);
			
			repB = true ;
			
			do{
				System.out.println("Etes vous sûr de vouloir supprimer " + personnes.get(idModi).getPrenom() + " " + personnes.get(idModi).getNom() + " ?");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					personnes.remove(idModi);
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);
			
			repB = true;
			
			do{
				System.out.println("Voulez vous supprimer un autre profil ?");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					restartB = false;
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);	
		}while(restartB);
		sc.close();
	}
	
	public static void FindAll2(List<BankAccount> comptes) {  
		int size = comptes.size();
		for (int i = 0; i<size; i++) {
			System.out.println(comptes.get(i));
		}
	   }


	public static void CreeCompte(List<BankAccount> comptes) {
		
		Scanner sc = new Scanner(System.in);
		BankAccount compteCree = null;
		int number = (int)( 1 + (Math.random() * (200 - 1)));
		int id = 0;
		boolean restartB = true;
		boolean choixB = true;
		
		do {
			choixB = true;
			compteCree = null;
		
		System.out.println("Souhaitez-vous creez un nouveau compte ?");
		String repC = sc.nextLine();
		
		
			if (repC.equals("oui") || repC.equals("Oui") || repC.equals("yes") || repC.equals("Yes")) {
				System.out.println("Voici le numéro de votre compte : ");
				 System.out.println(number);
				 id = comptes.size()+1;
				 compteCree = new BankAccount(id,number);			
				 comptes.add(compteCree);
				choixB = false;
			} else if (repC.equals("non") || repC.equals("Non") || repC.equals("no") || repC.equals("No")) {
				restartB = false;
				choixB = false;
			} else {
				System.out.println("Votre réponse est éronnée");
			}
			
		}while(restartB);
		sc.close();
	}
	
public static void ChangeNum(List<BankAccount>comptes, int idModi) {
		
		Scanner sc = new Scanner(System.in);
		int num = 1;
		boolean repB = true;
		int number = (int)( 1 + (Math.random() * (200 - 1)));
		
		String numeroModif = "";
		
		System.out.println("Voici votre nouveau numéros : ");
		System.out.println(number);
		numeroModif = sc.nextLine();
		
		try {	
			num = Integer.parseInt(numeroModif);
		}catch(NumberFormatException e){
			System.out.println("bugbugbug");
		}
		{
	}while(repB);
	
	comptes.set(idModi, comptes.get(idModi)).setNumero(num);
	sc.close();
	}

public static void ModifCompte(List<BankAccount> comptes) {
		
		Scanner sc = new Scanner(System.in);
		
		int idModi = -100000;
		boolean repB = true;
		boolean restartB = true;
		boolean errorB = false;
		String choix = "";
		
		do {
			System.out.println("Quel compte voulez vous modifier :");
			FindAll2(comptes);
			System.out.println("saisissez l'id du compte:");
			
			String sIdModi = sc.nextLine();
			repB = true;
			
			try{		
				idModi = Integer.parseInt(sIdModi)-1;
			}catch(NumberFormatException e){
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");	
			}
			if (idModi == -100000) {}
			else {
			try {
				System.out.print(comptes.get(idModi));
				repB = false;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
			}}
		}while(repB);
		
		repB = true;
		
		do {
            do {
                System.out.println("Que voulez vous modifier dans ce compte (numero, ...):");
                choix = sc.nextLine();
                errorB = false;

                switch (choix) {

                    case "numero" :
                        ChangeNum(comptes, idModi);
                        break;

                    default :
                        System.out.println("Vous avez tapé une catégorie inéxistante");
                        errorB=true;
                }
            }while(errorB);

                do{
                    System.out.println("Voulez vous modifier autre chose dans ce compte (oui/non):");
                    String rep = sc.nextLine();

                    if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
                        repB = false;
                    } else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
                        restartB = false;
                        repB = false;
                    } else {
                        System.out.println("Votre réponse est éronnée");
                    }
                }while (repB);
        }while(restartB);
		sc.close();
	}
	
	public static void CompteSupp(List<BankAccount> comptes) {
		
Scanner sc = new Scanner(System.in);
		
		int idModi = 0;
		boolean repB = true;
		boolean restartB = true;
		
		do {
			
			repB = true;
			
			do {
				System.out.println("Quel profil voulez vous supprimer :");
				FindAll2(comptes);
				System.out.println("saisissez l'id du compte:");
				
				String sIdModi = sc.nextLine();
				
				try{		
					idModi = Integer.parseInt(sIdModi)-1;
				}catch(NumberFormatException e){
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");	
				}
				try {
					System.out.print(comptes.get(idModi));
					repB = false;
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
				}
			}while(repB);
			
			repB = true ;
			
			do{
				System.out.println("Etes vous sûr de vouloir supprimer le n° " + comptes.get(idModi).getNumero() + " ");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					comptes.remove(idModi);
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);
			
			repB = true;
			
			do{
				System.out.println("Voulez vous supprimer un autre profil ?");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					restartB = false;
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);	
		}while(restartB);
		sc.close();
	}
	
	public static void main(String[] args){
		
		List<Person> personnes = null;
		boolean repChB = true;
		boolean continuB = true;
		int choix = 0;
		List<BankAccount> comptes = null;
		
		Scanner sc = new Scanner(System.in);
		personnes = new ArrayList<Person>();
		
		Person personne1 = new Person(1, "corentin", "Fouquet", LocalDate.of(2013, 06, 23),"corentin.fouquet@outlook.com");
		Person personne2 = new Person(2, "Clément", "Mouniard", LocalDate.of(2015, 12, 31), "corentin.fouquet@imie.fr");
		Person personne3 = new Person(3, "corentin", "Fouquet", LocalDate.of(2016, 05, 15), "corentin.fouquet@outlook.com");
		
		personnes.add(personne1);
		personnes.add(personne2);
		personnes.add(personne3);
		
		comptes = new ArrayList<BankAccount>();
		
		BankAccount compte1 = new BankAccount(1, (int)( 1 + (Math.random() * (200 - 1))));
		BankAccount compte2 = new BankAccount(2, (int)( 1 + (Math.random() * (200 - 1))));
		BankAccount compte3 = new BankAccount(3, (int)( 1 + (Math.random() * (200 - 1))));
		
		comptes.add(compte1);
		comptes.add(compte2);
		comptes.add(compte3);	
		
		do {
			
			do {
				
				System.out.println("1) Lister les personnes");
		        System.out.println("2) Ajouter une personne");
		        System.out.println("3) Modifier une personne");
		        System.out.println("4) Supprimer une personne");
		        System.out.println("5) Lister les comptes");
		        System.out.println("6) Ajouter un compte");
		        System.out.println("7) Modifier un compte");
		        System.out.println("8) Supprimer un compte");
		        System.out.println("9) Sortir");
				System.out.println("Quel catégorie voulez vous choisir ?");
				
				String sChoix = sc.nextLine();
				
				try{		
					choix = Integer.parseInt(sChoix);
					repChB = false;	
				}catch(NumberFormatException e){
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas des chiffres");	
				}
				
			}while(repChB);		
			
			switch (choix){
				case 1: 
					FindAll(personnes);
					break;
					
				case 2:
					CreatePer(personnes);
					break;
				
				case 3:
					ModifiPer(personnes);
					break;
				
				case 4:
					DeletePer(personnes);
					break;
				
				case 5:	
					FindAll2(comptes);
					break;				

				case 6:	
					CreeCompte(comptes);
					break;				

				case 7:
					ModifCompte(comptes);
					break;
					
				case 8:	
					CompteSupp(comptes);
					break;
					
				case 9 :
					continuB = false;
					break;
			}
		}while(continuB);
	}
}
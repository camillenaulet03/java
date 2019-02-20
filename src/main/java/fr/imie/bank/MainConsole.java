package fr.imie.bank;

import fr.imie.bank.model.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.DateTimeException;
import java.time.LocalDate;

public class MainConsole {
	
	public static void findAll() {  
		try {
			  if(System.getProperty("os.name" ).startsWith("Windows"))
			    Runtime.getRuntime().exec("cls");
			  else
			    Runtime.getRuntime().exec("clear");
			} catch(Exception excpt) {
				  for(int i=0;i<100;i++)
				    System.out.println();
			} 
	   }
	
	public static void main(String[] args){

		List<Person> personnes = null;
		Person personneCree = null;
		int newPers = 0;
		boolean repB = true;
		boolean restartB = true;
		boolean repChB = true;
		int id = 0;
		String prenom = "";
		String nom = "";
		LocalDate ddn = LocalDate.now();
		int ddnJ = 0;
		int ddnM = 0;
		int ddnA = 0;
		String email = "";
		int choix = 0;
		
//		LocalDate date = LocalDate.of(2013, 06, 23);
//		System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		Scanner sc = new Scanner(System.in);
		personnes = new ArrayList<Person>();
		
		Person personne1 = new Person(1, "corentin", "Fouquet", LocalDate.of(2013, 06, 23),"corentin.fouquet@outlook.com");
		Person personne2 = new Person(2, "Clément", "Mouniard", LocalDate.of(2015, 12, 31), "corentin.fouquet@imie.fr");
		Person personne3 = new Person(3, "corentin", "Fouquet", LocalDate.of(2016, 05, 15), "corentin.fouquet@outlook.com");
		
		personnes.add(personne1);
		personnes.add(personne2);
		personnes.add(personne3);
		
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
			String Schoix = sc.nextLine();
			try{
				choix = Integer.parseInt(Schoix);
				repChB = false;
			}catch(NumberFormatException e){
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
		}while(repChB);		
		
		switch (choix){
			case 1: 
				int size = personnes.size();
				for (int i = 0; i<size; i++) {
					System.out.print(personnes.get(i));
				}
		}
		
		do {
			personneCree = null;
			
			do{
				System.out.println("Voulez vous saisir une nouvelle personne ?");
				String rep = sc.nextLine();	
				
				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					newPers = 1;
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					newPers = 0;
					restartB = false;
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			}while (repB);
			
			repB = true;
			
			if(newPers == 1){
				System.out.println("Quel est le prenom de cette nouvelle personne ?");
				prenom = sc.nextLine();
				
				System.out.println("Et quel est son nom ?");
				nom = sc.nextLine();
				
				do {
					System.out.println("Sa date de naissance ?(jour/mois/année)");
					
					System.out.println("Jour = ");
					String SddnJ = sc.nextLine();
					
					System.out.println("Mois = ");
					String SddnM = sc.nextLine();
					
					System.out.println("Année = ");
					String SddnA = sc.nextLine();
					
					try {	
						ddnJ = Integer.parseInt(SddnJ);
						ddnM = Integer.parseInt(SddnM);
						ddnA = Integer.parseInt(SddnA);
					}catch(NumberFormatException e){
						System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
					}
					try {
						ddn = LocalDate.of(ddnA, ddnM, ddnJ);
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
				
			} else {
				restartB = false;
			}
		}while(restartB);
		
		System.out.println("Votre base de personnes final est : \n");
		System.out.print(personnes.toString());
	}	
}

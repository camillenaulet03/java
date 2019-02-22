package fr.imie.bank;

import fr.imie.bank.csv.DaoCsv1;
import fr.imie.bank.csv.DaoCsv2;
import fr.imie.bank.model.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MainConsole {

	public static int FindPersWId(List<Person> personnes, int id) {

		boolean repB = true;
		int i = 0;
		int reponse = 0;

		do {
			if (personnes.get(i).getId() == id) {
				reponse = i;
				repB = false;
			}
			i++;
		} while (repB);

		return reponse;
	}

	public static int FindCompWId(List<BankAccount> comptes, int id) {

		boolean repB = true;
		int i = 0;
		int reponse = 0;

		do {
			if (comptes.get(i).getId() == id) {
				reponse = i;
				repB = false;
			}
			i++;
		} while (repB);

		return reponse;
	}

	public static List<Person> FindAll() throws FileNotFoundException {

		List<Person> listPerson = new ArrayList<Person>();

		String csvFile = "Person.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] readCsv = line.split(cvsSplitBy);
				int id = Integer.parseInt(readCsv[0]);
				LocalDate localDate = DateUtils.toDate(readCsv[3]);
				List listCompte = new ArrayList();
				listCompte.add(readCsv[5]);
				Person person = new Person(id, readCsv[1], readCsv[2], localDate, readCsv[4], listCompte);
				listPerson.add(person);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPerson;

	}

	public static void CreatePer(List<Person> personnes) throws IOException {

		List<BankAccount> comptes = null;
		comptes = new ArrayList<BankAccount>();
		Person personneCree = null;
		boolean repB = true;
		boolean restartB = true;
		int id = 0;
		String prenom = "";
		String nom = "";
		String email = "";

		Scanner sc = new Scanner(System.in);

		do {
			personneCree = null;
			repB = true;
			LocalDate ddn = LocalDate.now();

			System.out.println("Quel est le prenom de cette nouvelle personne ?");
			prenom = sc.nextLine();

			System.out.println("Et quel est son nom ?");
			nom = sc.nextLine();

			do {
				System.out.println("Sa date de naissance ?(jour/mois/année)");
				String ddnS = sc.nextLine();

				try {
					ddn = DateUtils.toDate(ddnS);
					repB = false;
				} catch (DateTimeParseException e) {
					System.out.println("La date n'est pas correcte");
				}
			} while (repB);

			repB = true;

			System.out.println("Et pour finir quel est son adresse email ?");
			email = sc.nextLine();

			FileWriter fw = new FileWriter("Person.csv", true);

			int idS = personnes.size();

			if (idS < 1) {
				id = 1;
			} else {
				id = personnes.get(idS - 1).getId() + 1;
			}

			personneCree = new Person(id, prenom, nom, ddn, email, comptes);

			fw.write(DaoCsv1.toString(personneCree) + "\r\n");

			fw.close();

			personnes.add(personneCree);

			do {
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
			} while (repB);
		} while (restartB);

	}

	public static void ChangePre(List<Person> personnes, int idModi) {

		Scanner sc = new Scanner(System.in);

		String prenomModif = "";

		System.out.println("Quel nouveau prenom voulez vous à la place de " + personnes.get(idModi).getPrenom() + " :");
		prenomModif = sc.nextLine();

		personnes.set(idModi, personnes.get(idModi)).setPrenom(prenomModif);

	}

	public static void ChangeNum(List<BankAccount> comptes, int idModi) {

		boolean repB;
		Scanner sc = new Scanner(System.in);

		int numModif = 0;
		String snumModi = sc.nextLine();
		repB = true;

		System.out.println("Quel numero de compte voulez vous à la place de " + comptes.get(idModi).getNumber() + " :");

		do {
			try {
				numModif = Integer.parseInt(snumModi);
				repB = false;
			} catch (NumberFormatException e) {
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
		} while (repB);

		comptes.set(idModi, comptes.get(idModi)).setNumber(numModif);

	}

	public static void ChangeSol(List<BankAccount> comptes, int idModi) {

		boolean repB;
		Scanner sc = new Scanner(System.in);

		float solModif = 0;
		String sSolModi = sc.nextLine();
		repB = true;

		System.out.println(
				"Quel solde sur votre compte voulez vous à la place de " + comptes.get(idModi).getNumber() + " :");

		do {
			try {
				solModif = Float.parseFloat(sSolModi);
				repB = false;
			} catch (NumberFormatException e) {
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
		} while (repB);

		comptes.set(idModi, comptes.get(idModi)).setSolde(solModif);

	}

	public static void ChangeNom(List<Person> personnes, int idModi) {

		Scanner sc = new Scanner(System.in);

		String nomModif = "";

		System.out.println("Quel nouveau nom voulez vous à la place de " + personnes.get(idModi).getNom() + " :");
		nomModif = sc.nextLine();

		personnes.set(idModi, personnes.get(idModi)).setNom(nomModif);

	}

	public static void ChangeEmail(List<Person> personnes, int idModi) {

		Scanner sc = new Scanner(System.in);

		String emailModif = "";

		System.out.println("Quel nouvel email voulez vous à la place de " + personnes.get(idModi).getEmail() + " :");
		emailModif = sc.nextLine();

		personnes.set(idModi, personnes.get(idModi)).setEmail(emailModif);

	}

	public static void ChangeDdn(List<Person> personnes, int idModi) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Quel date voulez vous à la place de " + personnes.get(idModi).getDdn() + " :");

		String ddn = sc.nextLine();

		LocalDate ddnModif = DateUtils.toDate(ddn);

		personnes.set(idModi, personnes.get(idModi)).setDdn(ddnModif);

	}

	public static void ModifiPer(List<Person> personnes) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		int idModi = -100000;
		boolean repB = true;
		boolean restartB = true;
		boolean errorB = false;
		String choix = "";

		do {
			System.out.println("Quel profil voulez vous modifier :");
			FindAll();
			System.out.println("saisissez l'id du compte:");

			String sIdModi = sc.nextLine();
			repB = true;

			try {
				idModi = Integer.parseInt(sIdModi) - 1;
			} catch (NumberFormatException e) {
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
			if (idModi == -100000) {
			} else {
				try {
					System.out.print(personnes.get(idModi));
					repB = false;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
				}
			}
		} while (repB);

		repB = true;

		do {
			do {
				System.out
						.println("Que voulez vous modifier dans ce profil (prenom/nom/date de naissance(ddn)/email):");
				choix = sc.nextLine();
				errorB = false;

				switch (choix) {

				case "prenom":
					ChangePre(personnes, idModi);
					break;

				case "nom":
					ChangeNom(personnes, idModi);
					break;

				case "ddn":
					ChangeDdn(personnes, idModi);
					break;

				case "email":
					ChangeEmail(personnes, idModi);
					break;

				default:
					System.out.println("Vous avez tapé une catégorie inéxistante");
					errorB = true;
				}
			} while (errorB);

			do {
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
			} while (repB);
		} while (restartB);

	}

	public static void DeletePer(List<Person> personnes, List<BankAccount> comptes) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		int idPers = 0;
		int idModi = 0;
		boolean repB = true;
		boolean restartB = true;

		do {

			repB = true;

			do {
				System.out.println("Quel profil voulez vous modifier :");
				FindAll();
				System.out.println("saisissez l'id du compte:");

				String sIdModi = sc.nextLine();

				try {
					idModi = Integer.parseInt(sIdModi);
					idPers = FindPersWId(personnes, idModi);
				} catch (NumberFormatException e) {
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
				}
				try {
					System.out.println(personnes.get(idPers));
					repB = false;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
				}
			} while (repB);

			repB = true;

			do {
				System.out.println("Etes vous sûr de vouloir supprimer " + personnes.get(idPers).getPrenom() + " "
						+ personnes.get(idPers).getNom() + " ainssi que tous ses comptes ?");
				String rep = sc.nextLine();

				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					personnes.remove(idPers);
					int idS = comptes.size();
					int i = 0;

					while (i < idS) {
						if (comptes.get(i).getIdPers() == idPers) {
							comptes.remove(comptes.get(i));
						}
						i++;
					}
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			} while (repB);

			repB = true;

			do {
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
			} while (repB);
		} while (restartB);

	}

	public static void CreateCom(List<BankAccount> comptes, List<Person> personnes) throws IOException {

		BankAccount compteCree = null;
		boolean repB = true;
		boolean restartB = true;
		int idS = 0;
		int id = 0;
		int idPers = -1;
		float solde = 0.0f;

		Scanner sc = new Scanner(System.in);

		do {
			List<BankAccount> listCompCree = new ArrayList<BankAccount>();
			int number = (int) (1 + (Math.random() * (200 - 1)));
			repB = true;
			do {
				System.out.println("A quel personne voulez vous relier ce compte :");
				System.out.println(FindAll());
				System.out.println("Saisissez l'id du profil:");

				String sIdPers = sc.nextLine();

				try {
					idPers = Integer.parseInt(sIdPers);
					repB = false;
				} catch (NumberFormatException e) {
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
				}
//				if (idPers > -1 && idPers <= personnes.get(personnes.size() - 1).getId()) {
//					repB = false;
//				} else {
//					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
//				}
			} while (repB);

			System.out.println("Voici le numéro de votre compte : ");
			System.out.println(number);

			FileWriter fw = new FileWriter("Comptes.csv", true);

			idS = comptes.size();

			if (idS < 1) {
				id = 1;
			} else {
				id = comptes.get(idS - 1).getId() + 1;
			}

			repB = true;

			do {
				System.out.println("Quel est le solde de votre compte : ");
				String sSolde = sc.nextLine();
				try {
					solde = Float.parseFloat(sSolde);
					repB = false;
				} catch (NumberFormatException e) {
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
				}
			} while (repB);

			compteCree = new BankAccount(id, number, idPers, solde);

			fw.write(DaoCsv2.toString(compteCree) + "\r\n");

			fw.close();

			comptes.add(compteCree);

			int i = 0;

			while (i <= idS) {
				if (comptes.get(i).getIdPers() == idPers) {
					listCompCree.add(comptes.get(i));
				}
				i++;
			}

//			personnes.get(idPers - 1).setComptes(listCompCree);

			repB = true;

			do {
				System.out.println("Souhaitez-vous creez un nouveau compte ?");
				String repC = sc.nextLine();

				if (repC.equals("oui") || repC.equals("Oui") || repC.equals("yes") || repC.equals("Yes")) {
					repB = false;
				} else if (repC.equals("non") || repC.equals("Non") || repC.equals("no") || repC.equals("No")) {
					restartB = false;
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			} while (repB);
		} while (restartB);
	}

	public static List<BankAccount> FindAllCom() throws FileNotFoundException {

		List<BankAccount> listCompte = new ArrayList<BankAccount>();

		String csvFile = "Comptes.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] readCsv = line.split(cvsSplitBy);
				int id = Integer.parseInt(readCsv[0]);
				int number = Integer.parseInt(readCsv[1]);
				int idPers = Integer.parseInt(readCsv[2]);
				float solde = Float.parseFloat(readCsv[3]);
				BankAccount compte = new BankAccount(id,number,idPers,solde);
				listCompte.add(compte);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCompte;


	}

	public static void ModifiCom(List<BankAccount> comptes) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		int idComp = 0;
		int idModi = -100000;
		boolean repB = true;
		boolean restartB = true;
		boolean errorB = false;
		String choix = "";

		do {
			System.out.println("Quel compte voulez vous modifier :");
			FindAllCom();
			System.out.println("saisissez l'id du compte:");

			String sIdModi = sc.nextLine();
			repB = true;

			try {
				idModi = Integer.parseInt(sIdModi);
				idComp = FindCompWId(comptes, idModi);
			} catch (NumberFormatException e) {
				System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
			}
			try {
				System.out.println(comptes.get(idComp));
				repB = false;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
			}
		} while (repB);

		repB = true;

//		int idModiC = comptes.get(idComp).getIdPers();
//		int idPers = FindPersWId(personnes, idModiC);

		do {
			do {
				System.out.println("Que voulez vous modifier dans ce profil (numero/solde):");
				choix = sc.nextLine();
				errorB = false;

				switch (choix) {

				case "numero":
					ChangeNum(comptes, idModi);
					break;

				case "solde":
					ChangeSol(comptes, idModi);
					break;

				default:
					System.out.println("Vous avez tapé une catégorie inéxistante");
					errorB = true;
				}
			} while (errorB);

			do {
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
			} while (repB);
		} while (restartB);
	}

	public static void DeleteCom(List<BankAccount> comptes, List<Person> personnes) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		int idComp = 0;
		int idModi = 0;
		boolean repB = true;
		boolean restartB = true;

		do {

			repB = true;

			do {
				System.out.println("Quel compte voulez vous supprimer :");
				FindAllCom();
				System.out.println("Saisissez l'id du compte:");

				String sIdModi = sc.nextLine();

				try {
					idModi = Integer.parseInt(sIdModi);
					idComp = FindCompWId(comptes, idModi);
				} catch (NumberFormatException e) {
					System.out.println("Vous avez fait une erreur de saisi car les caractères ne sont pas de chiffres");
				}
				try {
					System.out.println(comptes.get(idComp));
					repB = false;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Vous avez fait une erreur de saisi car l'id est en dehors des id proposés");
				}
			} while (repB);

			repB = true;

			int idModiC = comptes.get(idComp).getIdPers();
			int idPers = FindPersWId(personnes, idModiC);

			do {
				System.out.println(
						"Etes vous sûr de vouloir supprimer le comptes de " + personnes.get(idPers).getPrenom() + " "
								+ personnes.get(idPers).getNom() + " numero " + comptes.get(idComp).getNumber() + " ?");
				String rep = sc.nextLine();

				if (rep.equals("oui") || rep.equals("Oui") || rep.equals("yes") || rep.equals("Yes")) {
					comptes.remove(idComp);
					repB = false;
				} else if (rep.equals("non") || rep.equals("Non") || rep.equals("no") || rep.equals("No")) {
					repB = false;
				} else {
					System.out.println("Votre réponse est éronnée");
				}
			} while (repB);

			repB = true;

			do {
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
			} while (repB);
		} while (restartB);
	}

	public static void main(String[] args) throws IOException {

		List<BankAccount> comptes = new ArrayList<BankAccount>();
		List<Person> personnes = new ArrayList<Person>();
		boolean repChB = true;
		boolean continuB = true;
		int choix = 0;

		Scanner sc = new Scanner(System.in);

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

				try {
					choix = Integer.parseInt(sChoix);
					repChB = false;
				} catch (NumberFormatException e) {
					System.out
							.println("Vous avez fait une erreur de saisi car les caractères ne sont pas des chiffres");
				}

			} while (repChB);

			switch (choix) {
			case 1:
				System.out.println(FindAll());
				break;

			case 2:
				CreatePer(personnes);
				break;

			case 3:
				ModifiPer(personnes);
				break;

			case 4:
				DeletePer(personnes, comptes);
				break;

			case 5:
				System.out.println(FindAllCom());
				break;

			case 6:
				CreateCom(comptes, personnes);
				break;

			case 7:
				ModifiCom(comptes);
				break;

			case 8:
				DeleteCom(comptes, personnes);
				break;

			case 9:
				continuB = false;
				break;
			}
		} while (continuB);
	}
}
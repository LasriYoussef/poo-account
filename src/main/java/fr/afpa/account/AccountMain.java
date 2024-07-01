package fr.afpa.account;

/**
 * Classe principale du projet, contient la fonction "main"
 */

class AccountMain
{
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");
		
		// Objets de Class "Account"
		Account account1 = new Account("FR7612548029981234567890161", 8000, 0);
		Account account2 = new Account("FR7630004000031234567890143", 400, -250 );
		Account account3 = new Account("FR7630002032531234567890168", 700, -650);
		Account account4 = new Account("FR7630056009271234567890182", 0, 0);
		Account account5 = new Account("FR7630001007941234567890185", 10000, 2000);
		
		//To string de "Account"
		System.out.println("\n................... A");
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
		System.out.println(account4.toString());
		System.out.println(account5.toString());
		
		System.out.println("\n------------------------------------------------------------");
		
		// Objets de la class "Customer"
		System.out.println("\n................... CUSTOMERS ");
		Customer customer1 = new Customer(1234, "Dora", "Lexploratrice");
		Customer customer2 = new Customer(1235, "Bat", "Man");
		Customer customer3 = new Customer(1236, "Super", "Women");

		//TO STRING() de Customers
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());
		
		System.out.println("\n------------------------------------------------------------");
		
		// Rajouter un ou plusieurs objet de "Account" a "Customer"
		System.out.println("\n................... Rajout accounts");
		customer1.addAccount(account1);
		customer2.addAccount(account2);
		customer3.addAccount(account3);
		customer3.addAccount(account4);
		customer3.addAccount(account5);

		System.out.println("\n------------------------------------------------------------");
		
		//TO STRING() Customers
		System.out.println("\n................... CUSTOMERS & ACCOUNTS");
		System.out.println("Customer 1 : " +customer1.toString());
		System.out.println("Customer 2 : " +customer2.toString());
		System.out.println("Customer 3 : " +customer3.toString());
		

		System.out.println("\n------------------------------------------------------------");
		
		//Testes et "Transfert"
		System.out.println("\n................... Test et Transfert");

		//TEST SUB AMOUNT de account1
		System.out.println("\n.... Test SUB valeur de Account1");
		try{
			account1.removeMoney(5000);
			System.out.println("Retirer 8000 de account1 fait !, overdraft authorization ok.");
		} catch (Exception exceptionToProcess){
			System.out.println(exceptionToProcess.getMessage());
		}

		//Transfert d'argent entre account1 -> account2
		System.out.println("\n.... Test transfert d'argent entre account1 -> account2");
		try{
			Account.transfer(6000, account1, account2); 
		} catch (Exception e) {
            System.out.println("ERROR: DEBTOR's balance too low..");
			for (StackTraceElement st : e.getStackTrace()){          //*** Can see where the problem is from
				System.out.println(st);                              //From wich function in the try
			}
		}

		System.out.println("Balance account 1: " + account1.getBalance());
		System.out.println("Balance account 2: " + account2.getBalance());

		//IBAN COORECT ? // https://www.iban.fr/exemple.html
		System.out.println("\n.... TEST correct IBAN ?");
		boolean isCorrectIban = Account.checkIban("FR7630001007941234567890185");
		System.out.println("FR7630001007941234567890185 : It's a " + isCorrectIban + " IBAN");

		//Removing one object "Account" 3 to "Customer" 3
		System.out.println("\n.... TEST removing account3 to customer3");
		customer3.removeAccount(account5);
		System.out.println(customer3.toString());
		
		
		System.out.println("\n------------------------------------------------------------");
		
		//CONCLUSION
		
		//Printing all informations with System.out.println
		System.out.println("\n................... RECAP AFTER OPERATIONS");
		System.out.println(customer1);
		System.out.println(customer2);
		System.out.println(customer3);
		System.out.println("\n------------------------------------------------------------");
		
	}
}

 
// Instancier des objets de la classe "Account"

// Instancier des objets de la classe "Customer"

// Ajouter un ou plusieurs objet de "Account" à des "Customer"

// Afficher les informations des employés avec System.out.println
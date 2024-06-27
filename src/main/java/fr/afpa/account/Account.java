package fr.afpa.account;

import java.beans.Expression;
import java.util.regex.Pattern;


/**
 * Classe représentant un compte bancaire
 * L’objectif de ce TP est de concevoir un programme en console basé sur une
 * approche objet et permettant de gérer les comptes en banque de client.
 * Vous allez créer deux classes :
 * - « Account » : représente des comptes bancaires
 * - « Customer » : représente des clients d’une banque
 */
public class Account {
    // Les attributs de la classe
    private String iban;
    private int balance; // La est reprenste l'attribut de l'argent sur le compte
    private int overdraftAutorization; // l'attribut de l'autorisation de decouvert
    private String checkIban; // 
    // compléter le constructeur de la classes
    // Public est un modificateur d'accees qui déterminent la visibilité et
    // l'accessibilité des classes, méthodes, et variables depuis d'autres parties
    // du code
    // String retourne a une chaine de caracteres
    // Corps du constructeur où les attributs seront initialisés ce qu'on appelle
    // initialisation des attributs
    // Le constructeur Accoount initialise un nouvel objet Account avec les valeurs
    // fournies
    // Il utilise les paramètres pour assigner des valeurs aux attributs
    // correspondants de l'objet
    // avec une conversion de la chaîne de caractères

    public Account(String iban, int balance, int overdraftAutorization) {
        this.iban = iban;
        this.balance = balance;
        this.overdraftAutorization = overdraftAutorization;

    }

    // implementer les getters et les setters de la classe
    // l'implementation nous donne les donnees des getters
    // Public est un modificateur d'accees qui déterminent la visibilité et
    // l'accessibilité des classes, méthodes, et variables depuis d'autres parties
    // du code
    // String parametre de type String qui est une chaine de caracteres
    // getRegistationNumber est le nom de la methode donne au getters
    // elle retourne a une instance de class = objet

    // Getters
    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public int getOverdraftAutorization() {
        return overdraftAutorization;
    }

    // Setters
    // public: La méthode est publique, elle peut être appelée depuis n'importe
    // quelle autre classe.
    // void: La méthode ne retourne pas de valeur.
    // setIban(String iban): Le nom de la méthode est setIban et elle prend un
    // paramètre iban de type String.
    // La méthode appelle une autre méthode, checkIban, pour vérifier si l'IBAN
    // passé en paramètre est valide.
    // checkIban(iban) retourne probablement un boolean.
    // !checkIban(iban) signifie "si checkIban(iban) retourne false".
    // Si checkIban(iban) retourne false, la méthode lance une exception de type
    // IllegalArgumentException.
    // Le message "L'IBAN n'est pas au bon format" sera inclus dans l'exception et
    // pourra être utilisé pour diagnostiquer le problème.
    // Si checkIban(iban) retourne true, l'IBAN est considéré comme valide.
    // this.iban = iban; assigne la valeur du paramètre iban à l'attribut iban de
    // l'objet actuel.
    public void setIban(String iban) throws Exception {
        if (!checkIban(iban)) {
            throw new Exception("La saisie de l'IBAN n'est pas au bon format");
        }
        this.iban = iban;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOverdraftAutorization(int overdraftAutorization) {
        this.overdraftAutorization = overdraftAutorization;
    }

    @Override
    public String toString() {
        return "Account  [\n iban = " + getIban()
                + "\n balance = " + getBalance()
                + "\n overdraftAutorization = " + getOverdraftAutorization()
                + "]";
    }

    /**
     * Vérifie une chaîne de caractères et indique s'il s'agit d'un montant valide
     * correctement formaté ou non
     * 
     * @param inputToCheck "on appelle ca de la doc" La chaîne de caractère à vérifier
     * @return VRAI s'il s'agit d'un matricule, FAUX sinon
     */
    public void addMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Le montant du Deposit doit etre positive");
        }
    }

    public boolean removeMoney(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Fond insuffisant ou le montant n'est pas valide");
            return false;
        }
    }

    // L'ex.g. \s+ correspond à un ou plusieurs caractères d'espace blanc
    // Par conséquent, nous pouvons appeler la méthode thereplaceAll(“\\s+”, ” ") pour terminer la première étape
    // Ensuite, nous pouvons invoquer la méthode String.trim() pour appliquer l'opération de coupe
    private boolean checkIban(String stringToCheck) {
        for (int index = 0; stringToCheck.replaceAll(27); index++){
        String result = stringToCheck.replaceAll("\\s+", " ");
        // Utilisation de la méthode replaceAll pour remplacer les séquences d'espaces par un seul espace.
        // "\\s+" : Expression régulière qui correspond à une ou plusieurs occurrences d'espaces blancs (espace, tabulation, etc.).
        // " " : Remplacement des séquences d'espaces par un seul espace.
        assertThat(result).isEqualTo(" I am a wonderful String ! ");
        assertThat(result.trim()).isEqualTo("I am a wonderful String !");} 

}
}

// TODO à compléter

// private static final Pattern IBAN_PATTERN =
// Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z0-9]{1,30}");

// public void setIban(String iban) throws Exception{
// if (isValidIBAN(iban)) {
// this.iban = iban;
// } else {
// throw new Exception("Invalid IBAN");
// }
// }
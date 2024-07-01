package fr.afpa.account;

import java.beans.Expression;
import java.util.regex.Matcher;
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
    private static String iban;
    private int balance; // La est reprenste l'attribut de l'argent sur le compte
    private int overdraftAuthorization; // l'attribut de l'autorisation de decouvert

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
        this.overdraftAuthorization = overdraftAuthorization;

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

    public int getOverdraftAuthorization() {
        return overdraftAuthorization;
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
    // Exception.
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
        this.overdraftAuthorization = overdraftAuthorization;
    }

    @Override
    public String toString() {
        return "Account  {\n iban = " + getIban()
                + "\n balance = " + getBalance()
                + "\n overdraftAutorization = " + getOverdraftAuthorization()
                + "}";
    }

    /**
     * Vérifie une chaîne de caractères et indique s'il s'agit d'un montant valide
     * correctement formaté ou non
     * 
     * @param inputToCheck "on appelle ca de la doc" La chaîne de caractère à
     *                     vérifier
     * @return VRAI s'il s'agit d'un matricule, FAUX sinon
     */
    public void addMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rajout" + amount + "Nouveau solde" + this.balance);
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

    public void transfer(Account targetAccount, int amount) {
        if (amount > 0) {
            if (this.balance - amount >= -this.overdraftAuthorization) {
                this.balance -= amount;
                targetAccount.addMoney(amount);
                System.out.println("Transferred " + amount + " to " + targetAccount.getIban()
                        + ". New balance: " + this.balance);
            } else {
                System.out.println(" Fond insuffisant ! Pas de possibilite de transfert " + amount);
            }
        } else {
            System.out.println(" Le montant du transfert doit etre positive.");
        }
    }

   
    public static boolean checkIban(String stringToCheck) {
        return iban.matches("^[A-Za-z]{2}\\d{2}[A-Za-z0-9]{10,30}$");
    }
 // L'ex.g. \s+ correspond à un ou plusieurs caractères d'espace blanc
    // Par conséquent, nous pouvons appeler la méthode thereplaceAll(“\\s+”, ” ")
    // pour terminer la première étape
    // Ensuite, nous pouvons invoquer la méthode String.trim() pour appliquer
    // l'opération de coupe
    // Méthode pour vérifier le format de l'iban
    public static String removeUnwantedCharacters(String str) {
        if (str == null) {
            return null;
        }
        // Utilisation de replaceAll avec une expression régulière pour enlever espaces
        // et tirets
        // str.replaceAll("[\\s-]", "") utilise une expression régulière pour trouver
        // tous les espaces (\\s) et les tirets (-) dans la chaîne et les remplace par
        // une chaîne vide (""), les supprimant ainsi.
        // " " : Remplacement des séquences d'espaces par un seul espace.
        return str.replaceAll("[\\s-]", "");
    }
    // nous allons utiliser un types de donnee "boolean" pour representer une valeur de verite
    // public: La méthode est publique, elle peut être appelée depuis n'importe quelle autre classe.
    // mooveCharactersIban (String iban): Le nom de la méthode est mooveCharactersIban et elle prend un paramètre iban de type String.
    // La méthode appelle une autre méthode, chaine, pour vérifier si l'IBAN passé en paramètre est valide.
    // (chaine.length) retourne probablement un boolean.
    // Si (chaine.length) retourne false, la méthode lance une exception de type IllegalArgumentException.
    // Le message "L'IBAN n'est pas au bon format" sera inclus dans l'exception et pourra être utilisé pour diagnostiquer le problème.
    // Si checkIban(iban) retourne true, l'IBAN est considéré comme valide.
    // this.iban = iban; assigne la valeur du paramètre iban à l'attribut iban de l'objet actuel.

    public String mooveCharactersIban(String args) {

        String chaine = " ";
        String result = mooveCharactersIban(chaine);
        System.out.println(" Nouvelle Chaine" + result);

        // Vérifier que la chaîne a au moins 4 caractères
        if (chaine.length() >= 4) {
            // Déplacer les 4 premiers caractères à la fin
            String nouvelleChaine = chaine.substring(4) + chaine.substring(0, 4);
            System.out.println("Nouvelle chaîne: " + nouvelleChaine);
            return nouvelleChaine;
        } else {
            System.out.println("La chaîne doit avoir au moins 4 caractères.");
        }
        return chaine;// Retourner ma chaine inchangee si elle a moins de 4 caracteres
    }

    public static String moove4FirstCaracteres(String chaine) {
        String result = "";
        int length = chaine.length();

        // Ajouter les caractères après le quatrième caractère
        for (int i = 4; i < length; i++) {
            result += chaine.charAt(i);
        }

        // Ajouter les quatre premiers caractères à la fin
        for (int i = 0; i < 4; i++) {
            result += chaine.charAt(i);
        }

        return result;
    }

    public class LetterToNumberConverter {

        // Méthode pour convertir une seule lettre en son équivalent numérique
        public static String letterToNumber(char letter) {
            // Convertir la lettre en majuscule pour assurer la cohérence
            letter = Character.toUpperCase(letter);

            // Vérifier si le caractère est une lettre de A à Z
            if (letter >= 'A' && letter <= 'Z') {
                int number = letter - 'A' + 10; // Si c'est le cas, elle retourne la valeur numérique correspondante sous forme de chaîne de caractères en utilisant le calcul letter - 'A' + 10.
                return String.valueOf(number);
            } else {
                return String.valueOf(letter); // Si ce n'est pas une lettre, elle retourne le caractère original sous forme de chaîne de caractères.
            }
        }

        // Cette méthode prend une chaîne de caractères en entrée et utilise un StringBuilder pour construire la chaîne de sortie.
        public static String convertString(String input) {
            StringBuilder result = new StringBuilder();

            for (char c : input.toCharArray()) {
                result.append(letterToNumber(c));// Pour chaque caractère de la chaîne d'entrée, elle utilise letterToNumber pour obtenir la valeur numérique correspondante et l'ajoute à la chaîne de sortie.
            }

            return result.toString();
        }

        // Méthode pour vérifier si un IBAN est valide
        public static boolean isValidIban(String iban) {
            // Vérifier si l'IBAN correspond au format général
             Matcher matcher = IBAN_PATTERN.matcher(iban);
        if (!matcher.matches()) {
            return false; // Si le format est incorrect, retourner false
        }
            // Placer les quatre premiers caractères à la fin de la chaîne
            String rearrangedIban = iban.substring(4) + iban.substring(0, 4);
            // Convertir en chaîne de chiffres
            String numberString = convertString(rearrangedIban);
            // Convertit cette chaîne de chiffres en un nombre entier (long pour gérer de
            // grands nombres)
            long number = Long.parseLong(numberString); // Utiliser long pour éviter un débordement pour de grands nombres
            // Vérifie si le reste de la division par 97 est égal à 1 et retourne le résultat de cette vérification (true si le reste est 1, sinon false).
            return number % 97 == 1;
        }

    }

    public static void transfer(int i, Account account1, Account account2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }

}
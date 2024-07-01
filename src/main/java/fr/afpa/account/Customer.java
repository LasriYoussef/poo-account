package fr.afpa.account;

import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */

public class Customer {
    private final int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Adding of the account : " + account + " to " + this.lastName);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        System.out.println("Removing of the account: " + account + "to" + this.lastName);
    }

    @Override
    public String toString() {
        return "Customer {"
                + "Id : " + getId()
                + " | First Name : " + getFirstName()
                + " | Last Name : " + getLastName()
                + " | Account(s) : " + getAccounts()
                + " }";
    }

}
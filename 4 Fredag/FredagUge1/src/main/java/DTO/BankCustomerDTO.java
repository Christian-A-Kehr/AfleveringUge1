/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.BankCustomer;

/**
 *
 * @author Christian
 */
public class BankCustomerDTO {

    private int customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public BankCustomerDTO(BankCustomer bankCustomer) {
        this.customerID = bankCustomer.getId();
        this.fullName = bankCustomer.getFirstName() + " " + bankCustomer.getLastName();
        this.accountNumber = bankCustomer.getAccountNumber();
        this.balance = bankCustomer.getBalance();
    }

    @Override
    public String toString() {
        return "BankCustomerDTO{" + "customerID=" + customerID + ", fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }

    
}

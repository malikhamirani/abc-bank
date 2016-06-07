package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
    	StringBuilder summary = new StringBuilder("Customer Summary");
    	for (Customer c : customers) {
    		summary.append("\n - ").append(c.getName()).append(" (");
    		format(summary,c.getNumberOfAccounts(), "account"); 
    		summary.append(")");
    	}
    	summary.trimToSize();
    	return summary.toString();
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private void format(StringBuilder summary, int number, String word) {
        //return number + " " + (number == 1 ? word : word + "s");
    	summary.append(number).append(" ").append(word);
    	if (number > 1) {
    		summary.append("s");
    	}
    }

    public double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    public String getFirstCustomer() {
        /*try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }*/
    	if (customers != null && customers.size() > 0)
    		return customers.get(0).getName();
    	
    	return null;
    }
    
    /**
     * Transfer funds between accounts
     * @param accFrom
     * @param accTo
     * @param amount
     * @throws Exception
     */
    public void transferFunds(Account accFrom, Account accTo, double amount) throws Exception {

    	if(accFrom.sumTransactions() > amount) {
    		synchronized (accFrom) {
    			synchronized (accTo) {
    				accFrom.withdraw(amount);
    				accTo.deposit(amount);
    			}

    		}
    	}
    	else throw new Exception("Not Enough Balance");
    }
    
}

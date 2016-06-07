package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static com.abc.util.CommonConstants.NEW_LINE;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Statement for ").append(name).append(NEW_LINE);
        double total = 0.0;
        for (Account a : accounts) {
            statement.append(NEW_LINE).append(statementForAccount(a)).append(NEW_LINE);
            total += a.sumTransactions();
        }
        statement.append(NEW_LINE).append("Total In All Accounts ").append(toDollars(total));
        statement.trimToSize();
        return statement.toString();
    }

    private String statementForAccount(Account a) {
    	StringBuilder transStatement = new StringBuilder();

       //Translate to pretty account type
        switch(a.getAccountType()){
            case Account.CHECKING:
            	transStatement.append("Checking Account\n");
                break;
            case Account.SAVINGS:
            	transStatement.append("Savings Account\n");
                break;
            case Account.MAXI_SAVINGS:
            	transStatement.append("Maxi Savings Account\n");
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
        	transStatement.append( "  " + (t.amount < 0 ? "withdrawal" : "deposit"));
        	transStatement.append(" ").append(toDollars(t.amount)).append(NEW_LINE);
            total += t.amount;
        }
        transStatement.append("Total ").append(toDollars(total));
        transStatement.trimToSize();
        return transStatement.toString();
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
    
    
}

package com.driver;

public class BankAccount {

     String name;
     double balance;
     double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
    	this.name = name;
    	this.balance = balance;
    	this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
    	
    	if(digits*9 < sum || sum < 0) throw new Exception("Account Number can not be generated");
    	
    	StringBuilder sb = new StringBuilder();
    	while(digits-- > 0) {
    		
    		if(sum >= 9) {
    			sb.append(9);
    			sum -= 9;
    		}else {
    			sb.append(sum);
    			sum = 0;
    		}
    	}

        return sb.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
    	balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
    	if(this.balance-amount < minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance-=amount;
    }

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
    
    
	

}
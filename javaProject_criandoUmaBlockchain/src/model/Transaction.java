package model;

import interfaces.Transaction_IF;

public class Transaction implements Transaction_IF {
	
	//atributes
	private String sender;
    private String receiver;
    private double amount;

    //constructor
    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
    
    //getters and setters
	@Override
	public String getSender() {
		return sender;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public double getAmount() {
		return amount;
	}
	
	//to string method
	@Override
    public String toString() {
        return sender + " -> " + receiver + ": " + amount + "\n";
    }
	
}

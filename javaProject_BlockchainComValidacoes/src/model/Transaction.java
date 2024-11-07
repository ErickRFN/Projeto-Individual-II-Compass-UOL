package model;

import interfaces.Transaction_IF;

public class Transaction implements Transaction_IF {
	
	//atributes
	private String addressSender;
    private String addressReceiver;
    private double amount;

    //constructor
    public Transaction(String sender, String receiver, double amount) {
        this.addressSender = sender;
        this.addressReceiver = receiver;
        this.amount = amount;
    }
    
    //getters and setters
	@Override
	public String getSender() {
		return addressSender;
	}

	@Override
	public String getReceiver() {
		return addressReceiver;
	}

	@Override
	public double getAmount() {
		return amount;
	}
	
	//to string method
	@Override
    public String toString() {
        return addressSender + " -> " + addressReceiver + ": " + amount + "\n";
    }
	
}

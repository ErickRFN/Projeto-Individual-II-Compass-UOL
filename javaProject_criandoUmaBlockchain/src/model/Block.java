package model;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Block_IF;
import util.HashUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Block implements Block_IF {
	
	//attributes
	private int id;
	private String timestamp;
	private ArrayList<Transaction> transactions;
	private String previousHash;
	private String hash;
	private int nonce;
	
	//constructor
	public Block(int id, ArrayList<Transaction> transactions, String previousHash) {
		// Guardando atributos já transmitidos
		this.id = id;
		this.transactions = transactions;
        this.previousHash = previousHash;
		
        // Solicita a hora local, formata ela no padrão BR e guarda no carimbo de tempo
        this.timestamp = generateTimestamp();
		
        // Gera um número aleatório para o nonce, já que o processo de mineração não está implementado
        this.nonce = generateRandomNonce();
        
        // Calcula o hash do bloco
        this.hash = calculateHash();;
	}
	
	//methods
	private String generateTimestamp() {
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter DTFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return DTFormat.format(currentDateTime);
	}
	
	private int generateRandomNonce() {
		Random random = new Random();
        return random.nextInt(1000000);
	}
	
	public void updateHashCode() {
		this.hash = calculateHash();
	}
	
	@Override
	public String calculateHash() {
		// Concatena todos os dados necessários para gerar o hash do bloco.
		String dataToHash = this.id + this.timestamp + this.transactions
				+ this.previousHash + this.nonce;
		
		// Envia o hash para a função applySHA256 e retorna o resultado.
		return HashUtil.applySHA256(dataToHash);
	}
	
	//getters and setters
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getPreviousHash() {
		return this.previousHash;
	}

	@Override
	public String getHash() {
		return this.hash;
	}

	@Override
	public String getTimestamp() {
		return this.timestamp;
	}

	@Override
	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	@Override
	public int getNonce() {
		return this.nonce;
	}
	
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
		updateHashCode();
	}

}

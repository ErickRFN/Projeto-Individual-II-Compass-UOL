package main;

import java.util.ArrayList;
import model.*;
import util.TextColor;

public class Main {
	
	public static void start() throws InterruptedException {
		System.out.println(TextColor.BLUE + "############################################" + TextColor.RESET);
		System.out.println(TextColor.GREEN_BOLD + "PROJETO: Construindo uma " + TextColor.YELLOW_BOLD +
				"Blockchain " + TextColor.GREEN_BOLD + "com Java" + TextColor.RESET);
        System.out.println(TextColor.BLUE + "############################################" + TextColor.RESET);
        
        Thread.sleep(1000);
        
        System.out.println("\n-> Nesse projeto, demonstrarei uma \nblockchain de transações utilizando"
        		+ " a \nlinguagem java.");
        
        Thread.sleep(1500);
        
        System.out.println("\n-> Para iniciar, irei gerar uma nova \nblockchain e adicionar a primeira transação"
        		+ "\ncoinbase no bloco Gênesis direcionada \npara mim mesmo.");

        threePoints();
        Blockchain blockchain = new Blockchain();
        System.out.println("\n" + TextColor.GREEN_BOLD + "BLOCKCHAIN GERADA COM SUCESSO" + TextColor.RESET);
        Thread.sleep(1500);
        
        Thread.sleep(1000);
        
        System.out.println("\n-> Abaixo irei mostrar a blockchain atual.");
        
        displayBlockchain(blockchain);
        
        System.out.println("-> Agora, irei adicionar mais 2 blocos "
        		+ "\na blockchain, cada um com duas transações, \nalém da "
        		+ "coinbase sempre para mim.");
        
        addTransactionToBlockAndBlockchain(blockchain);
        
        threePoints();
        System.out.println("\n" + TextColor.GREEN_BOLD + "BLOCOS CRIADOS E ADICIONADOS COM SUCESSO" + TextColor.RESET);
        Thread.sleep(1500);
        
        System.out.println("\n-> A nova blockchain");
        
        displayBlockchain(blockchain);
        
        System.out.println("-> Validando a blockchain");
        
        Thread.sleep(1500);
        threePoints();
        validateBlockchain(blockchain);
        
        System.out.println("\n-> Por fim, digamos que dois Hackers "
        		+ "\ninvadiram e adulteraram as transações \ndo bloco com ID = 1");
        
        Thread.sleep(2000);
        threePoints();
        adulterateBlockchain(blockchain);
        System.out.println("\n" + TextColor.RED_BOLD + "HACKERS ADULTERARAM O BLOCO ID 1" + TextColor.RESET);
        Thread.sleep(2000);
        
        System.out.println("\n-> Você pode verifificar abaixo que "
        		+ "\na blockchain está adulterada. Porém "
        		+ "\nverifique que o Hash anterior do bloco ID 2 "
        		+ "\nnão é o mesmo que o Hash de seu anterior, "
        		+ "\no bloco adulterado com ID 1.");
        
        Thread.sleep(2000);
        displayBlockchain(blockchain);
        Thread.sleep(2000);
        
        System.out.println("-> Logo, irei executar a validação da "
        		+ "\nblockchain que deve confirmar a invalidade "
        		+ "\nda mesma.");
	
        Thread.sleep(1500);
        threePoints();
        validateBlockchain(blockchain);
        
        /*
         * Tive que fazer assim por que java utiliza passagem por referência
         * em quase todas as estrutura e não tem um método clone para um onjeto,
         * para que eu conseguisse clonar eu teria q mexer bastante nas classes,
         * já que as 3 estão interligadas, então não seria interessante nem prático,
         * e, por fim, recolocar as transações antigas não faz com que o hash seja
         * o mesmo, já que o timestamp vai ser outro, melhor refazer a blockchain.
         */
        System.out.println("\n-> Após esse teste, irei "
        		+ "\nrefazer a blockchain");
        
        Thread.sleep(1500);
        threePoints();
        blockchain = new Blockchain();
        addTransactionToBlockAndBlockchain(blockchain);
        System.out.println("\n" + TextColor.GREEN_BOLD + "BLOCKCHAIN REFEITA COM SUCESSO" + TextColor.RESET);
        Thread.sleep(1500);
        
        System.out.println("\n-> Agora, uma última exibição");
        
        Thread.sleep(2000);
        displayBlockchain(blockchain);
        
        System.out.println("-> Por último, uma última validação");
        
        Thread.sleep(1500);
        threePoints();
        validateBlockchain(blockchain);
	}
	
	@SuppressWarnings("unchecked")
	public static void addTransactionToBlockAndBlockchain(Blockchain blockchain) {
		// Criando e adicionando o primeiro bloco
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("Coinbase", "Erick", 1000.00));
        transactions.add(new Transaction("Erick", "Aryosmar", 200.78));
        transactions.add(new Transaction("Erick", "Pedro", 250.02));
        
        Block block1 = new Block(blockchain.getLatestBlock().getId()+1, (ArrayList<Transaction>) transactions.clone(), blockchain.getLatestBlock().getHash());
        blockchain.addBlock(block1);
        transactions.clear();
        
        // Criando e adicionando o segundo bloco
        transactions.add(new Transaction("Coinbase", "Erick", 1000.00));
        transactions.add(new Transaction("Erick", "Sangela", 307.87));
        transactions.add(new Transaction("Pedro", "Gabriel", 179.44));
        
        Block block2 = new Block(blockchain.getLatestBlock().getId()+1, (ArrayList<Transaction>) transactions.clone(), blockchain.getLatestBlock().getHash());
        blockchain.addBlock(block2);
        transactions.clear();
	}
	
	public static void adulterateBlockchain(Blockchain blockchain) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("Coinbase", "Erick", 1000.00));
        transactions.add(new Transaction("Erick", "Hacker 1", 200.78));
        transactions.add(new Transaction("Erick", "Hacker 2", 250.02));
		
		blockchain.getChain().get(1).setTransactions(transactions);;
	}
	
	public static void fixBlockchainTampering(Blockchain blockchain) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("Coinbase", "Erick", 1000.00));
        transactions.add(new Transaction("Erick", "Aryosmar", 200.78));
        transactions.add(new Transaction("Erick", "Pedro", 250.02));
		
		blockchain.getChain().get(1).setTransactions(transactions);
	}
	
	public static void validateBlockchain(Blockchain blockchain) {
		if(blockchain.isChainValid()) {
			System.out.println("\n" + TextColor.GREEN_BOLD + "BLOCKCHAIN É VÁLIDA" + TextColor.RESET);
        }else {
        	System.out.println("\n" + TextColor.RED_BOLD + "BLOCKCHAIN É INVÁLIDA" + TextColor.RESET);
        }
	}
	
	public static void displayBlockchain(Blockchain blockchain) throws InterruptedException {
		Thread.sleep(1500);
        System.out.println();
        blockchain.displayChain();
        System.out.println();
        Thread.sleep(2000);
	}
	
	public static void threePoints() throws InterruptedException {
		Thread.sleep(600);
        System.out.print("\n.");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(600);
	}

	public static void main(String[] args) throws InterruptedException {
		
		start();
		
	}

}

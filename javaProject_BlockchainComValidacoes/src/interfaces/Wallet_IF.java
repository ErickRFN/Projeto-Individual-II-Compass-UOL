package interfaces;

import java.security.PublicKey;

public interface Wallet_IF {

	void generateKeyPair();
	String generateAddress();
	void updateBalance(Double attBalance);
	PublicKey getPublicKey();
	void setNickname(String nickname);
	String getNickname();
	String getAddress();
	Double getBalance();
	
}

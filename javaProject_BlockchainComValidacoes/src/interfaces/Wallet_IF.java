package interfaces;

import java.security.PublicKey;

public interface Wallet_IF {

	void generateKeyPair();
	String generateAddress();
	PublicKey getPublicKey();
	String getAddress();
	
}

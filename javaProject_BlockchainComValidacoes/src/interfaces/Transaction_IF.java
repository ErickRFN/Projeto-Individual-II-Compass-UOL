package interfaces;

public interface Transaction_IF {

    String getSender();
    String getReceiver();
    double getAmount();

    @Override
    String toString();
	
}

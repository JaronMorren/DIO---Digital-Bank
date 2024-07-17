
public class SavingsAccount extends Account {

	public SavingsAccount(Client client) {
		super(client);
	}
@Override
	public void printExtract() {
		System.out.println("=== Savings Account Extract ===");
		super.displayInfo();
	}
}


public class Main {

	public static void main(String[] args) {
		Client JohnDoe = new Client();
		JohnDoe.setName("John Doe");
		
		Account currentAccount = new CurrentAccount(JohnDoe);
		Account savingsAccount = new SavingsAccount(JohnDoe);

		currentAccount.deposit(500);
		currentAccount.transfer(500, savingsAccount);
		
		currentAccount.printExtract();
		savingsAccount.printExtract();
	}

}

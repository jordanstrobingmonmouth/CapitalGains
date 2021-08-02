import java.util.Scanner;
public class Transaction {

	public static void main(String[] args) {
		CapitalGains c = new CapitalGains();
		
		c.buy(100, 20);
		c.buy(20, 24);
		c.buy(200, 36);
		
		c.sell(150, 30);

		c.display();
		
		
		transact();
	}

	public static void transact() {
		CapitalGains c = new CapitalGains();
		Scanner in = new Scanner(System.in);
		
		boolean loop = false;
		System.out.println("buy or sell?");
		String buysell = in.next();
		if (buysell.equals("buy") || buysell.equals("Buy")) {
			loop = true;
		}
		else {
			System.err.println("Nothing to sell");
			System.exit(0);
		}
		
		while (loop) {
			System.out.println("How many shares? How much does each share cost? ");
			int shares = in.nextInt();
			double cost = in.nextDouble();
			c.buy(shares, cost);
			System.out.println("Do you want to buy again, or sell? ");
			String decision = in.next();
			if (decision.equals("sell") || decision.equals("Sell")) {
				loop = false;
			}
			else if ((decision.equals("buy") || decision.equals("Buy"))) {
				continue;
			}
			else {
				System.err.println("Invalid input");
				System.exit(0);
			}
		}
		
		System.out.println("How many shares do you want to sell? How much does each share you want to sell cost?");
		int shares = in.nextInt();
		double cost = in.nextDouble();
		c.sell(shares, cost);
		c.display();
	}
}

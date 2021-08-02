import java.util.LinkedList;
import java.util.Queue;


public class CapitalGains {

	private double gains;
	private Queue<Buy> q = new LinkedList<>();
	
	public void buy(int shares, double price) {
		Buy b = new Buy(shares, price);
		q.add(b);
	}
	
	//sell
	//sell 150 at 6.00
	// 100 * (6-2.5) if you had first 100 at 2.5
	// 50 * (6-5) + ^ = gains
	
	public void sell(int shares, double price) {
		int sold = shares;
		while (sold > 0) {
			if (q.peek().getShares() < sold) {
				gains = gains + ((price - q.peek().getPrice()) * q.peek().getShares());
				sold = sold - q.remove().getShares();
			}
			else if (q.peek().getShares() == sold) {
				gains = gains + ((price - q.peek().getPrice()) * sold);
				q.remove();
				return;
			}
			else if (q.peek().getShares() > sold) {
				gains = gains + ((price - q.peek().getPrice()) * sold);
				q.peek().setShares(q.peek().getShares() - sold);
				return;
			}
		}
		
	}
	
	public void display() {
		System.out.println("Capital gains = " + gains);
	}
	
}

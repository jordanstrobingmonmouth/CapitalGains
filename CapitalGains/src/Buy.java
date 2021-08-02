
public class Buy {

	private int shares;
	private double price;
	
	Buy(int shares, double price){
		this.shares = shares;
		this.price = price;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

package lesson3.labs.prob3;


public class Trailer extends Property {
	private static final double RENT = 500;
	public Trailer(Address address) {
		super(address);
	}
	public double computeRent(){
		return RENT;
	}
	
}

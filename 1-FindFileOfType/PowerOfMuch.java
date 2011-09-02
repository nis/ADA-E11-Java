import java.math.BigInteger;

public class PowerOfMuch {
	
	public static void main (String[] args) {
		PowerOfMuch my_class = new PowerOfMuch();
		long time = System.currentTimeMillis();
		my_class.exp(2, 8413);
		time = System.currentTimeMillis() - time;
		System.out.println("The calculation took " + time + "ms.");
	}
	
	public void exp(Integer b, Integer ex) {
		System.out.println(b + "^" + ex + " =\t" + worker(b, ex) );
	}
	
	public BigInteger worker(Integer b, Integer ex) {
		BigInteger return_value = BigInteger.valueOf(b);
		if (ex == 0) {
			return BigInteger.valueOf(1);
		} if ( ex == 1 ) {
			return return_value;
		} else {
			return return_value.multiply(worker(b, --ex));
		}
	}
}
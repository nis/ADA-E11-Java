import java.math.BigInteger;

public class PowerOfMuch {
	
	public static void main (String[] args) {
		PowerOfMuch my_class = new PowerOfMuch();
		int start = 0;
		int end = 8413;
		long time = System.currentTimeMillis();
		for(int i=0; i<8413; i++){
			my_class.exp(2, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("The calculation took " + time/1000 + "s.");
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
import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon_2935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = new BigInteger(sc.next());
		String operater = sc.next();
		BigInteger B = new BigInteger(sc.next());
		
		if(operater.equals("+")) {
			System.out.println(A.add(B));
		}
		else {
			System.out.println(A.multiply(B));
		}

	}

}

import java.util.Scanner;

public class Baekjoon_10707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int use = sc.nextInt();
		
		int resultA = use * A;
		int resultB = B;
		if(use > C) {
			resultB += ((use-C) * D);
		}

		System.out.println(resultA < resultB ? resultA : resultB);
	}

}

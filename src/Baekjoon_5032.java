import java.util.Scanner;

public class Baekjoon_5032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		
		int buttle = e + f;
		int result = 0;
		while(buttle >= c) {
			buttle -= c;
			result++;
			buttle++;
		}
		System.out.println(result);
	}

}

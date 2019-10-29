import java.util.Scanner;

public class Baekjoon_1773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int time = sc.nextInt();
		int[] p = new int[people];
		boolean[] check = new boolean[time+1];
		for (int i = 0; i < people; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 0; i < p.length; i++) {
			for (int j = 1; j <= time/p[i]; j++) {
				check[p[i]*j] = true;
			}
		}
		int count = 0;
		for (int i = 0; i < check.length; i++) {
			if(check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}

import java.util.Scanner;

public class Baekjoon_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i * j <= N) {
					result++;
				}
				else {
					break;
				}
			}
		}
		System.out.println(result);

	}

}

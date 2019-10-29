import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		int[] sum = new int[10];
		int s = 0;
		for (int i = 0; i < mushroom.length; i++) {
			s += mushroom[i];
			sum[i] = s;
		}
		int result = Integer.MAX_VALUE;
		int res = 0;
		for (int i = sum.length-1; i >=0; i--) {
			if(Math.abs(sum[i] - 100) < result) {
				result = Math.abs(sum[i] - 100);
				res = sum[i];
			}
		}
		System.out.println(res);
	}

}

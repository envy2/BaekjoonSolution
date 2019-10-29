import java.util.Scanner;

public class Baekjoon_5557 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int[] arr = new int[number];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] num = new int[arr.length][21];
		num[0][arr[0]] = 1;
		for (int i = 1; i < arr.length-1; i++) {
			for (int x = 0; x < num[0].length; x++) {
				if(num[i-1][x] > 0) {
					if(check(x + arr[i])) {
						num[i][x+arr[i]] += num[i-1][x];
					}
					if(check(x - arr[i])) {
						num[i][x-arr[i]] += num[i-1][x];
					}
				} 
			}
		}
		
		System.out.println(num[arr.length-2][arr[arr.length-1]]);
	}
	public static boolean check(int n) {
		return n >= 0 && n <= 20;
	}
}

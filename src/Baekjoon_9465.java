import java.util.Scanner;

public class Baekjoon_9465 {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			int[][] dp = new int[2][N+1];
			int[][] point = new int[2][N+1];
			for (int s = 0; s < point.length; s++) {
				for (int p = 1; p < point[0].length; p++) {
					point[s][p] = sc.nextInt();
				}
			}
			dp[0][1] = point[0][1];
			dp[1][1] = point[1][1];
			for (int j = 2; j < dp[0].length; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + point[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + point[1][j];
			}
			
			int result = Math.max(dp[0][N], dp[1][N]);
			System.out.println(result);
		}

	}

}

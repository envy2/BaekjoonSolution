import java.util.Scanner;

public class Baekjoon_1915 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] maps = new int[n][m];
		int[][] DP = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				maps[i][j] = line.charAt(j)-'0';
				DP[i][j] = line.charAt(j) -'0';
			}
		}
		int count = 0;
		for (int x = 1; x < maps.length; x++) {
			for (int y = 1; y < maps[0].length; y++) {
				if(maps[x][y] == 1) {
					DP[x][y] = Min(DP[x-1][y-1], DP[x][y-1],DP[x-1][y]) + 1;
					count = Math.max(DP[x][y], count);
				}
			}
		}
//		for (int x = 0; x < DP.length; x++) {
//			for (int y = 0; y < DP[0].length; y++) {
//				System.out.print(DP[x][y]);
//			}
//			System.out.println();
//		}
		System.out.println(count*count);

	}
	public static int Min(int a, int b, int c) {
		int n = Math.min(a, b);
		n = Math.min(n, c);
		return n;
	}
}

import java.util.Scanner;

public class Baekjoon_1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		int[][] tri = new int[iT][iT];
		for (int i = 0; i < iT; i++) {
			for (int j = 0; j <= i; j++) {
				tri[i][j] = sc.nextInt();
			}
		}
		
		int[][] DP = new int[iT][iT];
		DP[0][0] = tri[0][0];
		for (int i = 1; i < DP.length; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0) {
					DP[i][j] = DP[i-1][j] + tri[i][j];
				}
				else if(j == i) {
					DP[i][j] = DP[i-1][j-1] + tri[i][j];
				}
				else {
					DP[i][j] = Math.max(DP[i-1][j-1] + tri[i][j], DP[i-1][j] + tri[i][j]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < DP[DP.length-1].length; i++) {
			max = Math.max(DP[DP.length-1][i],max);
		}
		System.out.println(max);
	}

}

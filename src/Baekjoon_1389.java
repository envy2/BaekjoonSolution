import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1389 {
	static boolean[][] friend;
	static boolean[] visit;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		friend = new boolean[N+1][N+1];
		
		
		for (int i = 0; i < M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			friend[first][second] = true;
			friend[second][first] = true;
		}
		int[] point = new int[N+1];
		
		for (int i = 1; i < friend.length; i++) {
			int sum = 0;
			for (int j = 1; j < friend.length; j++) {
				if(i==j) {
					continue;
				}
				else {
					min = Integer.MAX_VALUE;
					visit = new boolean[N+1];
					dfs(i,j,0);
					sum += min;
				}
			}
			point[i] = sum;
		}
		System.out.println(Arrays.toString(point));
		int res = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i < point.length; i++) {
			if(res > point[i]) {
				res = point[i];
				result = i;
			}
		}
		System.out.println(result);

				
	}
	public static void dfs(int start,int end,int value) {
		if(start == end) {
			min = Math.min(min, value);
			return;
		}
		visit[start] = true;
		
		for (int i = 1; i < friend.length; i++) {
			if(!visit[i] && friend[start][i]) {
				visit[i] = true;
				dfs(i,end,value+1);
				visit[i] = false;
			}
		}
	}
}

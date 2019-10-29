import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon_1937 {
	static int[][] maps,DP;
	static ArrayList<Point> point;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		maps = new int[n][n];
		DP = new int[n][n];
		
		point = new ArrayList<>();
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				maps[i][j] = sc.nextInt();
				DP[i][j] = 1;
				point.add(new Point(maps[i][j],i,j));
			}
		}
		
		Collections.sort(point, new PSort());
		for (int i = 0; i < point.size(); i++) {
			EAT(point.get(i).x,point.get(i).y);
		}
		
		int result = 0;
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				result = result > DP[i][j] ? result : DP[i][j];
			}
		}
		
		System.out.println(result);
	}
	public static void EAT(int x,int y) {
		if(x - 1 >= 0 && maps[x-1][y] > maps[x][y]) {
			DP[x-1][y] = Math.max(DP[x-1][y], DP[x][y]+1);
		}
		if(x + 1 < maps.length && maps[x+1][y] > maps[x][y]) {
			DP[x+1][y] = Math.max(DP[x+1][y], DP[x][y]+1);
		}
		if(y - 1 >= 0 && maps[x][y-1] > maps[x][y]) {
			DP[x][y-1] = Math.max(DP[x][y-1], DP[x][y]+1);
		}
		if(y + 1 < maps.length && maps[x][y+1] > maps[x][y]) {
			DP[x][y+1] = Math.max(DP[x][y+1], DP[x][y]+1);
		}
	}
	
	static class PSort implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			return o1.value > o2.value ? 1 : -1;
		}
		
	}
	static class Point{
		int value,x,y;
		public Point(int v, int x ,int y) {
			this.value = v;
			this.x = x;
			this.y = y;
		}
	}
}

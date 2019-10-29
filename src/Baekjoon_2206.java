import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2206 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] maps;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][][] visit = new boolean[N][M][2];
		Queue<Point> q = new LinkedList<>();
		maps = new int[N][M];
		int result = 0;
		
		for (int x = 0; x < maps.length; x++) {
			String line = sc.next();
			for (int y = 0; y < maps[0].length; y++) {
				maps[x][y] = line.charAt(y) - '0';
			}
		}
		
		q.add(new Point(0,0,0,1));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == N - 1 && p.y == M - 1) {
				result = p.move;
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				if(check(p.x + dx[i], p.y + dy[i])) {
					if(p.hit == 1) {
						if(!visit[p.x + dx[i]][p.y + dy[i]][1] && maps[p.x + dx[i]][p.y + dy[i]] == 0) {
							visit[p.x + dx[i]][p.y + dy[i]][1] = true;
							q.add(new Point(p.x + dx[i], p.y + dy[i] , 1, p.move + 1));
						}
					}
					else {
						if(!visit[p.x + dx[i]][p.y + dy[i]][0] && maps[p.x + dx[i]][p.y + dy[i]] == 1) {
							visit[p.x + dx[i]][p.y + dy[i]][0] = true;
							q.add(new Point(p.x + dx[i], p.y + dy[i] , 1, p.move + 1));
						}
						if(!visit[p.x + dx[i]][p.y + dy[i]][0] && maps[p.x + dx[i]][p.y + dy[i]] == 0) {
							visit[p.x + dx[i]][p.y + dy[i]][0] = true;
							q.add(new Point(p.x + dx[i], p.y + dy[i] , 0, p.move + 1));
						}
					}
				}
			}
		}
		if(result == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	public static boolean check(int x, int y) {
		if( x < 0 || x >= maps.length || y < 0 || y >= maps[0].length) {
			return false;
		}
		return true;
	}
	public static class Point{
		int x,y,hit,move;
		
		public Point(int x, int y, int hit, int move) {
			super();
			this.x = x;
			this.y = y;
			this.hit = hit;
			this.move = move;
		}
		
	}

}
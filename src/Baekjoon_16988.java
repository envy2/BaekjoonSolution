import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_16988 {
	static int[][] maps;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int result;
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void init() {
		boolean check;
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				check = false;
				for (int d = 0; d < dx.length; d++) {
					if(over(i+dx[d], j+dy[d])) {
						continue;
					}
					if(maps[i][j] == 1 || maps[i][j] == 2 || (maps[i][j] == 0 && maps[i + dx[d]][j + dy[d]] == 2)) {
						check = true;
					}
				}
				if(!check) {
					maps[i][j] = -1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		maps = new int[x][y];
		result = 0;
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		init();
		put(0);
		System.out.println(result);
	}
	public static int kill() {
		int[][] copylist = copy();
		Queue<Point> q = new LinkedList<>();
		int dieStone = 0;
		
		for (int i = 0; i < copylist.length; i++) {
			for (int j = 0; j < copylist[0].length; j++) {
				boolean[][] visit = new boolean[copylist.length][copylist[0].length];
				if(copylist[i][j] == 2) {
					q.add(new Point(i,j));
					boolean death = true;
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						visit[p.x][p.y] = true;
						
						for (int d = 0; d < dx.length; d++) {
							if(over(p.x + dx[d], p.y + dy[d])) {
								continue;
							}
							else if(copylist[p.x + dx[d]][p.y + dy[d]] == 0) {
								death = false;
								break;
							}
							else if(!visit[p.x + dx[d]][p.y + dy[d]] && copylist[p.x + dx[d]][p.y + dy[d]] == 2) {
								q.add(new Point(p.x + dx[d], p.y + dy[d]));
							}
						}
						if(!death) {
							break;
						}
					}
					if(death) {
						for (int k = 0; k < visit.length; k++) {
							for (int k2 = 0; k2 < visit[0].length; k2++) {
								if(visit[k][k2]) {
									copylist[k][k2] = 0;
									dieStone++;
								}
							}
						}
					}
				}
			}
		}
		
		return dieStone;
	}
	public static void put(int depth) {
		if(depth == 2) {
			int death = kill();
			result = result > death ? result : death;
			return;
		}
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				if(maps[i][j] == 0) {
					maps[i][j] = 1;
					put(depth+1);
					maps[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean over(int x, int y) {
		if(x < 0 || x >= maps.length || y < 0 || y >= maps[0].length) {
			return true;
		}
		return false;
	}
	
	public static void print() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				System.out.print(maps[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] copy(){
		int[][] copylist = new int[maps.length][maps[0].length];
		
		for (int i = 0; i < copylist.length; i++) {
			for (int j = 0; j < copylist[0].length; j++) {
				copylist[i][j] = maps[i][j];
			}
		}
		return copylist;
	}
}

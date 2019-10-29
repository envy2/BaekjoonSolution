import java.util.Scanner;

public class Baekjoon_10709 {
	static char[][] maps;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		maps = new char[H][W];
		map = new int[H][W];
		
	
		
		for (int x = 0; x < maps.length; x++) {
			String line = sc.next();
			for (int y = 0; y < maps[0].length; y++) {
				map[x][y] = -1;
				maps[x][y] = line.charAt(y);
			}
		}
		
		for (int i = 0; i < map[0].length; i++) {
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps[0].length; y++) {
					if(maps[x][y] == 'c' && map[x][y] == -1) {
						map[x][y] = i;
					}
				}
			}
			cloud();
		}

		for (int x = 0; x < maps.length; x++) {
			for (int y = 0; y < maps[0].length; y++) {
				System.out.print(map[x][y]+" ");
			}
			System.out.println();
			
		}
	}
	public static void cloud() {
		for (int x = 0; x < maps.length; x++) {
			for (int y = maps[0].length-1; y >= 1 ; y--) {
				maps[x][y] = maps[x][y-1];
			}
			maps[x][0] = '.';
		}
	}
}

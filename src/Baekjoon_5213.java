import java.util.Scanner;

public class Baekjoon_5213 {
	static int[][] maps;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		maps = new int[N][N*2];
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 1; j < maps[0].length; j+=2) {
				if(i % 2 == 0) {
					maps[i][j-1] = sc.nextInt();
					maps[i][j] = sc.nextInt();
				}
				else if(j > maps[0].length-2){
					continue;
				}
				else {
					maps[i][j] = sc.nextInt();
					maps[i][j+1] = sc.nextInt();
				}
			}
		}
		
		
	}
	public static void print() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				System.out.print(maps[i][j]+" ");
			}
			System.out.println();
		}
	}
}

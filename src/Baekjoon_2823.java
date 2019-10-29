import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2823 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		char[][] maps = new char[x+2][y+2];
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				maps[i][j] = 'X';
			}
		}
		
		for (int i = 1; i < maps.length-1; i++) {
			String line = sc.next();
			for (int j = 1; j < maps[0].length-1; j++) {
				maps[i][j] = line.charAt(j-1);
			}
		}

		boolean result = false;
		for (int i = 1; i < maps.length-1; i++) {
			for (int j = 1; j < maps[0].length-1; j++) {
				if(!result && maps[i][j] == '.') {
					if(maps[i-1][j] == 'X' && maps[i][j-1] == 'X' && maps[i+1][j] == 'X') {
						result = true;
						break;
					}
					if(maps[i-1][j] == 'X' && maps[i][j-1] == 'X' && maps[i][j+1] == 'X') {
						result = true;
						break;
					}
					if(maps[i][j+1] == 'X' && maps[i][j-1] == 'X' && maps[i+1][j] == 'X') {
						result = true;
						break;
					}
					if(maps[i-1][j] == 'X' && maps[i][j+1] == 'X' && maps[i+1][j] == 'X') {
						result = true;
						break;
					}
				}
				
			}
		}
		if(result) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}

	}

}

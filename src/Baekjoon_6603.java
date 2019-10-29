import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_6603 {
	static int selectNum = 0;
	
	public static void init() {
		Scanner sc = new Scanner(System.in);
		int len = -1;
		
		while((len = sc.nextInt()) != 0) {
			int[] balls = new int[len];
			for (int i = 0; i < balls.length; i++) {
				balls[i] = sc.nextInt();
			}
			
			lotto(balls);
		}
	}
	public static void lotto(int[] balls) {
		for (int i = 0; i < balls.length - 5; i++) {
			selectNum = 1;
			String result = balls[i] + "";
			back(i, balls,result);
		}
		
	}
	public static void back(int depth, int[] balls, String result) {
		if(selectNum == 6) {
			System.out.println(result);
			return;
		}
		else {
			for (int i = depth + 1; i < balls.length; i++) {
				selectNum++;
				result = result + " " + balls[i];
				back(depth+1, balls,result);
			}
		}
		selectNum--;
	}
	
	public static void main(String[] args) {
		init();

	}

}

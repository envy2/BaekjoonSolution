import java.util.Scanner;

public class Baekjoon_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sugar = sc.nextInt();
		
		int count = sugar / 5;
		sugar %= 5;
		while(count > -1) {
			if(sugar % 3 == 0) {
				count += sugar / 3;
				break;
			}
			else {
				sugar += 5;
				count--;
			}
		}
		
		
		System.out.println(count);
		

	}

}

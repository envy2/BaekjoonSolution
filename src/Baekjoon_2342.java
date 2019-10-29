import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2342 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int i = 0;
		while(true) {
			i = sc.nextInt();
			if(i == 0) {
				break;
			}
			arr.add(i);
		}
		Foot foot = new Foot(0,0);
		int[] DP = new int[arr.size()];
		for (int j = 0; j < DP.length; j++) {
			if( move(foot.left,arr.get(j)) < move(foot.right,arr.get(j)) ) {
				DP[j] = move(foot.left,arr.get(j));
				foot.left = arr.get(j);
			}
			else {
				DP[j] = move(foot.right,arr.get(j));
				foot.right = arr.get(j);
			}
		}
		int result = 0;
		for(int a : DP) {
			result += a;
		}
		System.out.println(result);
	}
	
	public static int move(int a,int b) {
		if(a == 0) {
			return 2;
		}
		else if(a == 1) {
			switch(b) {
			case 1:
				return 1;
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 3;
			}
		}
		else if(a == 2) {
			switch(b) {
			case 1:
				return 3;
			case 2:
				return 1;
			case 3:
				return 3;
			case 4:
				return 4;
			}
		}
		else if(a == 3) {
			switch(b) {
			case 1:
				return 4;
			case 2:
				return 3;
			case 3:
				return 1;
			case 4:
				return 3;
			}
		}
		else {
			switch(b) {
			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 3;
			case 4:
				return 1;
			}
		}
		return 0;
	}
	
	static class Foot{
		int left,right;
		public Foot(int l , int r) {
			this.left = l;
			this.right = r;
		}
	}
}

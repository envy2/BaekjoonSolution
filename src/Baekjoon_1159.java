import java.util.Scanner;
import java.util.TreeSet;

public class Baekjoon_1159 {
	static char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alpabet = new int[26];
		
		int people = sc.nextInt();
		for (int i = 0; i < people; i++) {
			alpabet[sc.next().charAt(0) - 'a']++;
		}
		TreeSet<Integer> tree = new TreeSet<>();
		
		for (int i = 0; i < alpabet.length; i++) {
			if(alpabet[i] >= 5) {
				tree.add(i);
			}
		}
		
		if(tree.size() > 0) {
			for(Integer alpa : tree) {
				System.out.print(c[alpa]);
			}
		}
		else {
			System.out.print("PREDAJA");
		}
	}

}

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon_2037 {
	static HashMap<Character, Integer> h = new HashMap<>();
	
	public static void main(String[] args) {
		h.put(' ', 11);
		h.put('A', 21);
		h.put('B', 22);
		h.put('C', 23);
		h.put('D', 31);
		h.put('E', 32);
		h.put('F', 33);
		h.put('G', 41);
		h.put('H', 42);
		h.put('I', 43);
		h.put('J', 51);
		h.put('K', 52);
		h.put('L', 53);
		h.put('M', 61);
		h.put('N', 62);
		h.put('O', 63);
		h.put('P', 71);
		h.put('Q', 72);
		h.put('R', 73);
		h.put('S', 74);
		h.put('T', 81);
		h.put('U', 82);
		h.put('V', 83);
		h.put('W', 91);
		h.put('X', 92);
		h.put('Y', 93);
		h.put('Z', 94);
		
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int w = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int count = ( h.get(str.charAt(0)) % 10 ) * p;
		for (int i = 1; i < str.length(); i++) {
			if(h.get(str.charAt(i-1)) / 10 != 1 && h.get(str.charAt(i-1)) / 10 == h.get(str.charAt(i)) / 10 ) {
				count += w;
			}
			count += (h.get(str.charAt(i)) % 10) * p;
		}
		System.out.println(count);
	}

}

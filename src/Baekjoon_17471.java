import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_17471 {
	static boolean[][] city;
	static int[] people;
	static ArrayList<Integer> area1, area2;
	static int result, sum, sum1, sum2;
	
	static ArrayList<Integer> tmpArray = new ArrayList<>();
	
	public static void init() {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt() + 1;
		city = new boolean[temp][temp];
		people = new int[temp];
		result = Integer.MAX_VALUE;
		
		for (int i = 1; i < people.length; i++) {
			people[i] = sc.nextInt();
		}
		
		for (int start = 1; start < city.length; start++) {
			int end = sc.nextInt();
			for (int i = 0; i < end; i++) {
				city[start][sc.nextInt()] = true;
			}
		}
	}
	public static void main(String[] args) {
		init();
		boolean[] used = new boolean[people.length -1];
		powerSet(used,0);
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
		System.out.println(tmpArray);
	}
	public static boolean linked(ArrayList<Integer> area) {
		if(area.size() == 0 || area.size() == people.length - 1) {
			return false;
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[people.length];
		
		q.add(area.get(0));
		while(!q.isEmpty()) {
			int start = q.poll();
			visit[start] = true;
			
			for (int i = 0; i < area.size(); i++) {
				if(!visit[area.get(i)] && city[start][area.get(i)]) {
					q.add(area.get(i));
				}
			}
		}
		
		for (int i = 0; i < area.size(); i++) {
			if(!visit[area.get(i)]) {
				return false;
			}
		}
		return true;
	}
	public static void powerSet(boolean[] use, int depth) {
		if(depth == use.length - 1) {
			area1 = new ArrayList<>();
			area2 = new ArrayList<>();
			
			for (int i = 0; i < use.length; i++) {
				if(use[i]) {
					area1.add(i+1);
				}
				else {
					area2.add(i+1);
				}
			}
			
			if(linked(area1) && linked(area2)) {
				sum = sum1 = sum2 = 0;
				for (int i = 0; i < area1.size(); i++) {
					sum1 += people[area1.get(i)];
				}
				for (int i = 0; i < area2.size(); i++) {
					sum2 += people[area2.get(i)];
				}
				sum = Math.abs(sum1 - sum2);
				//result = result < sum ? result : sum;
				if(result > sum) {
					result = sum;
					tmpArray = area1;
				}
			}
			return;
		}
		use[depth] = false;
		powerSet(use, depth+1);
		use[depth] = true;
		powerSet(use, depth+1);
	}

}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon_16235 {
	static int[][] maps,nut;
	static ArrayList<Tree> tree;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		maps = new int[N][N];
		nut = new int[N][N];
		tree = new ArrayList<>();
		
		for (int x = 0; x < maps.length; x++) {
			for (int y = 0; y < maps.length; y++) {
				maps[x][y] = 5;
				nut[x][y] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < M; i++) {
			tree.add(new Tree(sc.nextInt(),sc.nextInt(),sc.nextInt(),true));
		}
		
		Seasons(K);
		int count = 0;
		for (int i = 0; i < tree.size(); i++) {
			if(tree.get(i).alive) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	public static void Seasons(int k) {
		Collections.sort(tree, new TSort());
		for (int i = 0; i < k; i++) {
			Spring();
			Summer();
			Fall();
			Winter();
		}
	}
	public static void Spring() {
		for (int i = 0; i < tree.size(); i++) {
			if(tree.get(i).alive && maps[tree.get(i).x][tree.get(i).y] >= tree.get(i).age) {
				maps[tree.get(i).x][tree.get(i).y] -= tree.get(i).age;
				tree.get(i).age++;
			}
			else if(tree.get(i).alive) {
				tree.get(i).alive = false;
			}
		}
	}
	public static void Summer() {
		for (int i = 0; i < tree.size(); i++) {
			if(!tree.get(i).alive && tree.get(i).age > 0) {
				maps[tree.get(i).x][tree.get(i).y] += tree.get(i).age/2;
				tree.get(i).age = 0;
			}
		}
	}
	
	public static void Fall() {
		int x = 0;
		int y = 0;
		int size = tree.size();
		for (int i = 0; i < size; i++) {
			if(tree.get(i).alive && tree.get(i).age % 5 == 0) {
				x = tree.get(i).x;
				y = tree.get(i).y;
				for (int d = 0; d < dx.length; d++) {
					if(x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < maps.length && y + dy[d] < maps.length) {
						tree.add(0,new Tree(x + dx[d] +1 , y + dy[d] + 1, 1, true));
						i++;
						size++;
					}
				}
			}
		}
	}
	public static void Winter() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				maps[i][j] += nut[i][j];
			}
		}
	}
	
	static class TSort implements Comparator<Tree>{

		@Override
		public int compare(Tree o1, Tree o2) {
			if(o1.age > o2.age) {
				return 1;
			}
			else if(o1.age == o2.age) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}
	static class Tree{
		int x,y,age;
		boolean alive;
		public Tree(int x, int y, int a, boolean live) {
			this.x = x - 1;
			this.y = y - 1;
			this.age = a;
			this.alive = live;
		}
		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}
		
	}
}

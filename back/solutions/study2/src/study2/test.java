package study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static int N, M;
	static int [][]arr;
	static boolean[][] visit;
	
	static int[] moveX = {-1, 1, 0, 0}; //상 하 좌 우 
	static int[] moveY = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			for(int j = 0; j<c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		visit = new boolean[N][M];
		visit[0][0] = true;
		bfs(0,0);
		
		System.out.println(arr[N-1][M-1]);
		
	}
	public static void bfs(int x, int y) {
		Queue<t> q = new LinkedList<>();
		q.add(new t(x,y));
		
		while(!q.isEmpty()) {
			t s = q.poll(); // 0,0 꺼내오기 
			for(int i = 0; i<4; i++) {
				int nextX = s.x + moveX[i];
				int nextY = s.y + moveY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY>=M) {
					continue;
				}
				if(visit[nextX][nextY] || arr[nextX][nextY]==0) {
					continue;
				}
				
				q.add(new t(nextX, nextY));
				arr[nextX][nextY] = arr[s.x][s.y] + 1;
				visit[nextX][nextY] = true;
				
				
			}
		}
	}

}

class t{
	int x;
	int y;
	t(int x, int y){
		this.x = x;
		this.y = y;
	}
}

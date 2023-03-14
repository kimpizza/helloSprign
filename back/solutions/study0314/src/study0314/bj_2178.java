package study0314;

import java.io.*;
import java.util.*;

public class bj_2178 {
	static int N, M, start;
	static boolean [][] bool ;
	static int [][]arr;
	//상 하 좌 우 이동 좌표 
	static int [] moveX = {-1, 1, 0, 0};
	static int [] moveY = {0, 0, -1, 1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bool = new boolean[N][M];
		arr = new int[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			char [] c = s.toCharArray();
			
			for(int j = 0; j<c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		
		bool[0][0] = true;
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	public static void bfs(int x, int y) {
		Queue<nowSpot> q = new LinkedList<>();
		q.add(new nowSpot(x, y));
		
		while(!q.isEmpty()) {
			nowSpot nowS = q.poll();
			for(int i = 0; i<4; i++) {
				int nextX = nowS.x + moveX[i];
				int nextY = nowS.y + moveY[i];
				
				if(nextX < 0 || nextY <0 || nextX >= N || nextY>=M) {
					continue;
				}
				if(bool[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				
				q.add(new nowSpot(nextX, nextY));
				bool[nextX][nextY] = true;
				arr[nextX][nextY] = arr[nowS.x][nowS.y] + 1;
			}
		}
	}
	
}

class nowSpot{
	int x;
	int y;
	
	nowSpot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

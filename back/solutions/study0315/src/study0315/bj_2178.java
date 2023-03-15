package study0315;

import java.util.*;
import java.io.*;
public class bj_2178 {
	
	static int[][] arr;
	static boolean[][] visit;
	static int N, M;
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String a = br.readLine();
			char [] c = a.toCharArray();
			for(int j = 0; j < c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		System.out.println(N+" "+M);
		visit[0][0] = true;
		start(0,0);
		System.out.println(arr[N-1][M-1]);
		
	}

	private static void start(int x, int y) {

		Queue<position1> q = new LinkedList<>();
		q.add(new position1(x, y));
		
		while(!q.isEmpty()) { //끊기면 다음찾기 ? 
			position1 p = q.poll();
			
			//방향대로 움직이기 
			for(int i = 0 ; i<4; i++) {
				int nextX = p.x + moveX[i];
				int nextY = p.y + moveY[i];
				
				if(nextX<0||nextY<0 || nextX>=N || nextY>=M) {
					continue;
				}
				if(visit[nextX][nextY]||arr[nextX][nextY]==0) {
					continue;
				}
				q.add(new position1(nextX, nextY));
				
				arr[nextX][nextY] = arr[p.x][p.y]+1;

				visit[nextX][nextY]=true;

			}
		}
	}

}
class position1{
	int x, y;
	
	position1(int x, int y){
		this.x = x;
		this.y = y;
	}
}

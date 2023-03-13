package ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test2178 {

	static int N, M; 
	static boolean [][] visit;
	static int[][]map;
	static int [] moveX = {-1,1,0,0};
	static int [] moveY = {0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			String str = sc.next();
			char [] c = str.toCharArray();
			
			for(int j = 0 ; j<c.length; j++) {
				map[i][j] = Character.getNumericValue(c[j]);
			}
		}
		
		visit[0][0] = true;
		start(0,0);
		System.out.println(map[N-1][M-1]);
		sc.close();
	}
	
	public static void start(int x, int y) {
		Queue<spot1> q = new LinkedList<>();
		q.add(new spot1(x,y));
		while(!q.isEmpty()) {
			spot1 s = q.poll();
		
			//동서남북 움직이기
			for(int i = 0; i<4; i++) {
				int nextX = s.x + moveX[i];
				int nextY = s.y + moveY[i];
				
				if(nextX < 0 || nextY <0 || nextX >=N||nextY>=M) {
					continue;
				}
				if(visit[nextX][nextY]|| map[nextX][nextY] == 0) {
					continue;
				}
				
				q.add(new spot1(nextX,nextY));
				visit[nextX][nextY] = true;
				map[nextX][nextY] = map[s.x][s.y]+1;
				
			}
		}
	
	}

}
class spot1 {
	int x;
	int y;
	
	spot1(int x, int y){
		this.x = x;
		this.y = y;
	}
}
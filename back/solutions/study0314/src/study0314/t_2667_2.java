package study0314;
import java.util.*;
import java.io.*;

public class t_2667_2 {
	static int [][] arr ;
	static boolean [][] visit;
	static int [] moveX = {-1, 1, 0, 0};
	static int [] moveY = {0, 0, -1, 1};
	static int cnt, line, number;
	static int nextX, nextY;
	static List<Integer>list = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = Integer.parseInt(br.readLine());	
		arr = new int[line][line];
		visit = new boolean[line][line];
		
		//배열 초기화 
		for(int i =0; i<line; i++) {
			String str = br.readLine();
			char [] c = str.toCharArray();
			
			for(int j = 0; j<c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		
		for(int i = 0; i<line; i++) {
			for(int j = 0; j<line; j++) {
				if(arr[i][j] == 1 && !visit[i][j]){
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		} 
        br.close();
	}
		 
 static void dfs(int i, int j) {
		visit[i][j] = true;
		cnt++;
		
		for(int k = 0; k<4; k++) {
			nextX = moveX[k] + i;
			nextY = moveY[k] + j;
			
			if((nextX >=0 && nextY >=0 && nextX <line && nextY<line) && !visit[nextX][nextY] && arr[nextX][nextY]==1){
				visit[nextX][nextY] = true;
				arr[nextX][nextY] = number;
				
				dfs(nextX, nextY);
			}
		}
	}
}
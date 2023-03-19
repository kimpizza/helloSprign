package study0319;

import java.util.*;
import java.io.*;
public class bj1931 {

	/* 1. 첫번째 들어온 사람은 회의실을 무조건 사용 가능하다.
	 * 2. 회의실 사용 시간이 겹치면 회의실을 사용할 수 없다. 
	 * 3. 회의실 사용이가능하다면 별도의 공간에 그 정보를 저장해준다??
	 * 4. 리스트 사용해볼까???
	 * */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][]arr = new int [n][2];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = a;
			arr[i][1] = b;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			//새로운 정렬기준 세우기 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					//종료 시간이 같다면 ?
					return o1[0] - o2[0];
				}
				return o1[1]-o1[1];
			}
		});
		int cnt = 0; 
		int prev = 0;
		
		for(int i = 0 ; i<n; i++) {
			if(prev <=arr[i][0]) { //새로 들어오는 시간의 시작 시간이 이전의 종료시간보다 더 크면
				prev = arr[i][1];
				System.out.println(arr[i][0]+ " " + arr[i][1]);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

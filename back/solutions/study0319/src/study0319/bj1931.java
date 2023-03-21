package study0319;

import java.util.*;
import java.io.*;
public class bj1931 {
   
	/* 1. 첫번째 들어온 사람은 회의실을 무조건 사용 가능하다.
	 * 2. 회의실 사용 시간이 겹치면 회의실을 사용할 수 없다. 
	 * 3. 회의실 사용이가능하다면 별도의 공간에 그 정보를 저장해준다??
	 * 4. 리스트 사용해볼까?
	 * */
	public static void main(String[] args) throws IOException{
		
				Scanner in = new Scanner(System.in);
				
				int N = in.nextInt();
				
				
				/*
				  time[][0] 은 시작시점을 의미 
				  time[][1] 은 종료시점을 의미 
				*/
				int[][] time = new int[N][2];
				
				
				for(int i = 0; i < N; i++) {
					time[i][0] = in.nextInt();	// 시작시간 
					time[i][1] = in.nextInt();	// 종료시간 
				}
				
				
				// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의 
				Arrays.sort(time, new Comparator<int[]>() {
					
					@Override
					public int compare(int[] o1, int[] o2) {
						
						// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
						if(o1[1] == o2[1]) {
							return o1[0] - o2[0];
						}
						
						return o1[1] - o2[1];
					}
		 
				});
				
				int count = 0;
				int prev_end_time = 0;
				
				for(int i = 0; i < N; i++) {
					
					// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
					if(prev_end_time <= time[i][0]) {
						prev_end_time = time[i][1];
						count++;
					}
				}
				
				System.out.println(count);
			}
		 
		}
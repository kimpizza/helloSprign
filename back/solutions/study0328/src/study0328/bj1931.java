package study0328;
import java.util.*;
import java.io.*;

public class bj1931 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int in = Integer.parseInt(br.readLine());
		
		int [][]arr = new int [in][2];
		
		for(int i=0; i<arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1]- o2[1];
			}
		});
		int cnt = 0;
		int end = 0;
		
		for(int i = 0; i<in; i++) {
			if(end<=arr[i][0]) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

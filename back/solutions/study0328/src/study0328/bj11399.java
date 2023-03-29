package study0328;
import java.util.*;
import java.io.*;

public class bj11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int []arr = new int [N];
		String a = br.readLine();
		
		StringTokenizer st = new StringTokenizer(a);
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		Arrays.sort(arr);
		int sum = 0; // 총 합 
		int add = 0; // 더할 수  
		
		
		for(int i = 0; i < N; i++) {
			add += arr[i];
			sum += add;
		}
	System.out.println(sum);
	}

}

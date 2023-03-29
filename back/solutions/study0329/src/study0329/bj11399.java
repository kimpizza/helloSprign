package study0329;
import java.util.*;
import java.io.*;

public class bj11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int [] arr = new int[N];
		int idx = 0;
		// 배열에 값 저장 
		while(st.hasMoreElements()) {
			arr[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		int sum = 0;
		int result = 0;
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			sum+=arr[i];
			result+=sum;
		}
		System.out.println(result);
		
	}

}

package study0329;

import java.util.*;
import java.io.*;


public class bj1541 {
	static long result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str,"-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer str2 = new StringTokenizer(st.nextToken(),"+");
			while(str2.hasMoreTokens()) {
				temp += Integer.parseInt(str2.nextToken());
			}
			if(result == Integer.MAX_VALUE) {
				result = temp;
			}
			else {
				result -= temp;
			}
		}
		System.out.println(result);
	}

}

package ex;

import java.util.*;
import java.io.*;

public class test10451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < T_case; t++) {
			int cnt = 0;
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[num + 1];
			boolean[] bool = new boolean[num + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < arr.length; i++) {
				if (!bool[i]) {
					bool[i] = true;
					int go = arr[i];

					while (true) {
						if (bool[go]) {
							cnt++;
							break;
						}
						bool[go] = true;
						go = arr[go];
					}
				}
			}
			System.out.println(cnt);
		}

	}

}

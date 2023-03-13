package ex;

import java.util.*;
import java.io.*;

public class bj2331 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(A);

		while (true) {
			int temp = list.get(list.size() - 1); // 리스트 가장 최근값 꺼내오기
			int result = 0;
			while (temp != 0) {
				result += (int) Math.pow(temp % 10, (double) P);
				temp /= 10;
			} // 값 구하기

			// result가 이미 리스트에 있다면
			// 그 result가 가리키는 인덱스 반환
			if (list.contains(result)) {
				int num = list.indexOf(result);
				sb.append(num + " ");
				break;
			}

			list.add(result);
		}
		System.out.println(sb);
	}

}

package study0328;


import java.util.*;
import java.io.*;

public class bj11047 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		int cnt = 0;
		while(K!=0) {
			int coin = list.get(0);
			if(coin>K) {
				list.remove(0);
			}else {
				cnt += K / coin; 
				K %= coin;
			}
		}
		System.out.println(cnt);
	}

}

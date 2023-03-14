package study0314;
import java.util.*;

public class bj_2331 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();
		
		List<Integer> list = new LinkedList<>();
		list.add(A);
		
		while(true) {
			int temp = list.get(list.size()-1);
			int result = 0;
			
			while(temp!=0) {
				result += (int)Math.pow(temp%10, P);
				temp/=10;
			}
			
			if(list.contains(result)) {
				System.out.println(list.indexOf(result));
				break;
			}
			list.add(result);
		}
	}

}

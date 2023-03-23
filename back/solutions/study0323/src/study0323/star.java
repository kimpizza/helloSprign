package study0323;

import java.util.Scanner;

public class star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int ln = 0; ln< num; ln++) {
			for(int star = 0; star < num-ln; star++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

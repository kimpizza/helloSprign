package study0323;
import java.io.*;
import java.util.*;

public class rever_star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			for (int j = 1; j < num - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

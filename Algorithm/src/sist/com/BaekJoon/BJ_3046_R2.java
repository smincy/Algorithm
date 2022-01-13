package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3046_R2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int r1 = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);

		System.out.println((2 * s) - r1);
	}
}

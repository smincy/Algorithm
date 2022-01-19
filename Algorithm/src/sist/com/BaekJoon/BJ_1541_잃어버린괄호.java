package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int sum = Integer.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");

		while (st1.hasMoreTokens()) {
			int tmp = 0;
			
			// "-" 로 나눈 블록을 다시 "+"로 나눠서 더해주기
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
			
			while (st2.hasMoreTokens()) {
				tmp += Integer.parseInt(st2.nextToken());
			}

			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
		System.out.println(sum);
	}
}

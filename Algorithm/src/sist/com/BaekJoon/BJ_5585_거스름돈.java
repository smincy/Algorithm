package sist.com.BaekJoon;

import java.io.*;

public class BJ_5585_거스름돈 {

	public static int N;
	public static int pay = 1000;
	public static int[] re = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int temp = pay - N; // 거스름든
		int cnt = 0; // 거스름돈 개수
		int i = 0;
		while (true) {
			if (temp == 0) {
				break;
			}
			if (temp >= re[i]) {
				cnt += temp / re[i];
				temp = temp % re[i];
			}
			i++;
		}
		System.out.println(cnt);
	}
}

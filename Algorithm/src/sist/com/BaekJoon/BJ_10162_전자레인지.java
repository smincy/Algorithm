package sist.com.BaekJoon;

import java.io.*;

public class BJ_10162_전자레인지 {

	public static int T;
	public static int[] arr = { 300, 60, 10 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		int[] cnt = new int[3];
		int i = 0;
		while (true) {
			if (T == 0) {
				System.out.print(cnt[0] + " " + cnt[1] + " " + cnt[2]);
				break;
			} else if (T < 10) {
				System.out.println(-1);
				break;
			}

			if (T >= arr[i]) {
				cnt[i] = T / arr[i];
				T = T % arr[i];
			}
			i++;
		}
	}
}

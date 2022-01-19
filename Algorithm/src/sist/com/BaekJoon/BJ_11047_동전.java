package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11047_동전 {

	public static int N, K, cnt;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		cnt = 0;
		int a = N - 1;
		while (true) {
			if (K == 0) {
				break;
			}

			if (K >= arr[a]) {
				K = K - arr[a];
				cnt++;
			} else {
				a--;
			}
		}
		System.out.println(cnt);
	}
}

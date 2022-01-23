package sist.com.BaekJoon;

import java.io.*;
import java.util.Arrays;

// 무조건 0이 필요, 각 자리수 합이 3의 배수

public class BJ_10610_30 {

	public static String N;
	public static int total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = br.readLine();

		int arr[] = new int[N.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(N.substring(i, i + 1));
			total += arr[i];
		}

		if (!N.contains("0") || total % 3 != 0) { // 0 이 없거나, 모든 자리수의 합이 3의 배수가 아니면 종료
			System.out.println(-1);
			return;
		}
		
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();

		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());

	}
}

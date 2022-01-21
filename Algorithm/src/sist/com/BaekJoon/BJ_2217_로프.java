package sist.com.BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BJ_2217_로프 {

	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int max = 0;

		for (int j = N-1; j >= 0; j--) {
			if (max < (arr[j] * (N - j))) {
				max = arr[j] * (N - j);
			}
		}
		System.out.println(max);
	}
}

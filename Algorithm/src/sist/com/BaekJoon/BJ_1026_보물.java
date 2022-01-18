package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1026_보물 {

	public static int N;
	public static int[] arrA;
	public static int[] arrB;
	public static int sum = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arrA = new int[N];
		arrB = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA);
		Arrays.sort(arrB);

		for (int i = 0; i < N; i++) {
			sum += arrA[i] * arrB[N - 1 - i];
		}

		System.out.println(sum);
	}

}

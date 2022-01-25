package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

public class BJ_1389_케빈베이컨 {

	public static int N, M;
	public static int[][] arr;
	public static int num = 999999;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = num;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = arr[b - 1][a - 1] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int temp, output = 0;

		for (int i = 0; i < N; i++) {
			temp = 0;
			for (int j = 0; j < N; j++) {
				temp += arr[i][j];
			}
			if (num > temp) {
				num = temp;			// 가장 작은 값을 가지고 있는 i = 사람 을 찾는 것
				output = i + 1;		// i 가 0 부터 시작하므로 +1
			}
		}
		System.out.println(output);
	}

}

package sist.com.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

	public static int N, m;
	public static final int num = 987654321;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		// 출발지 a, 도착지 b, 비용 c
		// i에서 j로 갈 수 없는 경우는 0 을 출력

		int arr[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = num;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = Math.min(arr[a - 1][b - 1], c);
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][k] + arr[k][j] < arr[i][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == num) {
					arr[i][j] = 0;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}

package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10026_적록색약 {

	public static int N, cnt;
	public static char arr[][];
	public static boolean vis[][];
	public static int[] x = { 1, -1, 0, 0 };
	public static int[] y = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BJ_10026_적록색약 s = new BJ_10026_적록색약();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		vis = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j] == false) {
						s.dfs(i, j, k);
						cnt++;
					}
				}
			}
			sb.append(cnt).append(" ");
			cnt = 0;
			vis = new boolean[N][N];
		}
		System.out.println(sb);

	}

	public void dfs(int ni, int nj, int k) {
		if (k == 0) {

			vis[0][0] = true;

			int nextI, nextJ;

			for (int i = 0; i < 4; i++) {
				nextI = ni + x[i];
				nextJ = nj + y[i];

				if (nextI >= N || nextJ >= N || nextI < 0 || nextJ < 0) {
					continue;
				}

				if (!vis[nextI][nextJ] && arr[ni][nj] == arr[nextI][nextJ]) {
					vis[nextI][nextJ] = true;
					dfs(nextI, nextJ, k);
				}

			}

		} else {

			vis[0][0] = true;

			int nextI, nextJ;

			for (int i = 0; i < 4; i++) {
				nextI = ni + x[i];
				nextJ = nj + y[i];

				if (nextI >= N || nextJ >= N || nextI < 0 || nextJ < 0) {
					continue;
				}

				if (arr[ni][nj] == 'R' && arr[nextI][nextJ] == 'G') {
					arr[ni][nj] = arr[nextI][nextJ];
				} else if (arr[ni][nj] == 'G' && arr[nextI][nextJ] == 'R') {
					arr[ni][nj] = arr[nextI][nextJ];
				}

				if (!vis[nextI][nextJ] && arr[ni][nj] == arr[nextI][nextJ]) {
					vis[nextI][nextJ] = true;
					dfs(nextI, nextJ, k);
				}

			}
		}

	}

}

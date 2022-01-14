package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1018_체스판2 {

	public static boolean arr[][];

	public static int min = 64;

	public static void main(String[] args) throws Exception {

		BJ_1018_체스판2 s = new BJ_1018_체스판2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		arr = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}

		int N_r = N - 7;
		int M_c = M - 7;

		for (int i = 0; i < N_r; i++) {
			for (int j = 0; j < M_c; j++) {
				s.check(i, j);
			}
		}
		System.out.println(min);
	}

	public void check(int x, int y) {
		int endx = x + 8;
		int endy = y + 8;

		int cnt = 0; // 칠하는 횟수

		boolean st = arr[x][y];

		for (int i = x; i < endx; i++) {
			for (int j = y; j < endy; j++) {
				if (arr[i][j] == st) {
					cnt++;
				}
				st = !st;
			}
			st = !st;
		}
		cnt = Math.min(cnt, 64 - cnt);

		min = Math.min(cnt, min);
	}

}

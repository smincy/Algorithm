package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {

	public static int M, N, K;
	public static int cnt = 0;
	public static int[][] arr;
	public static int[] x = { -1, 0, 1, 0 };
	public static int[] y = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BJ_2583_영역구하기 s = new BJ_2583_영역구하기();
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> list = new ArrayList<Integer>();

		// N = j, M = i
		M = Integer.parseInt(st.nextToken()); // 높이 | Y좌표 | 행
		N = Integer.parseInt(st.nextToken()); // 너비 | X좌표 | 열
		K = Integer.parseInt(st.nextToken());

		arr = new int[M][N];

		// 왼쪽 아래, 오른쪽 위 ( x 가 j (열) , y 가 i (행) )
		int lx, ly;
		int rx, ry;

		for (int i = 0; i < K; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			rx = Integer.parseInt(st.nextToken());
			ry = Integer.parseInt(st.nextToken());

			for (int j = ly; j < ry; j++) {
				for (int q = lx; q < rx; q++) {
					arr[j][q] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					cnt = 0;
					s.dfs(i, j);
					list.add(cnt);
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (Integer i : list) {

			System.out.print(i + " ");
		}
	}

	public void dfs(int ni, int nj) {

		arr[ni][nj] = 1;

		int nextX, nextY;
		cnt++;
		for (int i = 0; i < 4; i++) {
			nextX = ni + x[i];
			nextY = nj + y[i];

			if (nextX < M && nextY < N && nextX >= 0 && nextY >= 0) {
				if (arr[nextX][nextY] == 0) {
					dfs(nextX, nextY);
				}
			}
		}
	}
}
package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessHandle.Info;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {

	public static int T, N, M, K, result;
	public static int map[][];
	public static boolean vis[][];
	public static int[] x = { 1, -1, 0, 0 };
	public static int[] y = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BJ_1012_유기농배추 s = new BJ_1012_유기농배추();
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			result = 0;
			
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			vis = new boolean[M][N];

			for (int j = 0; j < K; j++) {
				String temp = br.readLine();
				st = new StringTokenizer(temp, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}

			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] == 1 && vis[j][k] == false) {
						s.bfs(j, k);
					}
				}
			}
			System.out.println(result);
		}

	}

	public void bfs(int hang, int yul) {
		Queue<int[]> que = new LinkedList<>();

		int cnt = 0;
		int tx, ty;

		que.add(new int[] { hang, yul });
		vis[hang][yul] = true;

		while (!que.isEmpty()) {

			int[] p = que.poll();

			int xnow = p[0];
			int ynow = p[1];

			cnt++;

			for (int i = 0; i < 4; i++) {
				tx = xnow + x[i];
				ty = ynow + y[i];

				if (tx >= M || tx < 0 || ty >= N || ty < 0) {
					continue;
				}

				if (map[tx][ty] == 1 && vis[tx][ty] == false) {
					que.add(new int[] { tx, ty });
					vis[tx][ty] = true;
				}

			}

		}
		if (cnt != 0) {
			result++;
		}
	}
}

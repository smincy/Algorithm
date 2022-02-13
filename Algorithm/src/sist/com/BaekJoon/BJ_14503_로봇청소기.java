package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {

	public static int N, M, r, c, d, cnt;
	public static int map[][];
	public static boolean vis[][];
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BJ_14503_로봇청소기 s = new BJ_14503_로봇청소기();
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 세로 N, 가로 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		vis = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0; // 청소하는 방

		s.clean(r, c, d);

		System.out.println(cnt);

	}

	public void clean(int r, int c, int d) {
		if (!vis[r][c]) {
			vis[r][c] = true;
			cnt++;
		}

		boolean flag = false;
		int orig = d;
		for (int i = 0; i < 4; i++) {
			int nextD = (d + 3) % 4;
			int nextR = r + dr[nextD];
			int nextC = c + dc[nextD];

			if (nextR > 0 && nextC > 0 && nextR < N && nextC < M) {
				if (map[nextR][nextC] == 0 && !vis[nextR][nextC]) {
					clean(nextR, nextC, nextD);
					flag = true;
					break;
				}
			}
			d = (d + 3) % 4;
		}

		// (경우 c) 네 방향 모두 청소가 되어있거나 벽인 경우

		if (!flag) {
			int next_d = (orig + 2) % 4;
			int next_br = r + dr[next_d];
			int next_bc = c + dc[next_d];

			if (next_br > 0 && next_bc > 0 && next_br < N && next_bc < M) {
				if (map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, orig); // 바라보는 방향 유지한 채 후진
				}
			}
		}
	}
}

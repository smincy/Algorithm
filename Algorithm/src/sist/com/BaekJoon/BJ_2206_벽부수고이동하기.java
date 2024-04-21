package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {
	/*
	N*M 지도
	0은 이동할 수 있는 곳
	1은 이동할 수 없는 곳

	1,1 에서 N,M 의 위치까지 이동하려는데 최단경로로 이동하려고 한다
	시작, 끝나는 칸도 포함
	경로가 짧아 진다면 벽 1개는 부수고 이동 가능

	 */
	static int N, M, wall;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int tmp = str.charAt(j) - '0';
				if (tmp == 1) {
					map[i][j] = tmp;
				}
			}
		}
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(bfs());

	}

	public static int bfs() {
		int[][][] vis = new int[2][N][M];    // 방문체크, 0=벽안부순, 1=벽부순
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0, 0, 0));
		vis[0][0][0] = 1;
		while (true) {
			Point p = que.poll();
			int w = p.w;
			for (int[] ints : dir) {
				int nextR = p.n + ints[0];
				int nextC = p.m + ints[1];
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
					continue;
				}

				if (map[nextR][nextC] == 0) {        // 다음 위치가 벽이 아닌 경우
					if (vis[w][nextR][nextC] == 0) {
						que.add(new Point(w, nextR, nextC));
						vis[w][nextR][nextC] = vis[w][p.n][p.m] + 1;
						if (nextR == N - 1 && nextC == M - 1) {        // 다음 위치가 마지막 자리이면 끝
							return vis[w][nextR][nextC];
						}
					}
				} else {                            // 다음 위치가 벽인 경우
					if (w == 0) {        // 벽안 안 부수고
						if (vis[1][nextR][nextC] == 0) {
							que.add(new Point(1, nextR, nextC));
							vis[1][nextR][nextC] = vis[0][p.n][p.m] + 1;
							if (nextR == N - 1 && nextC == M - 1) {        // 다음 위치가 마지막 자리이면 끝
								return vis[1][nextR][nextC];
							}
						}
					}
				}
			}
			if (que.isEmpty()) {
				return -1;
			}
		}
	}


	public static class Point {
		int w, n, m;

		public Point(int w, int a, int b) {
			this.w = w;
			this.n = a;
			this.m = b;
		}
	}
}

package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14940_쉬운최단거리 {
	static int N, M, x, y; // 세로 , 가로, 목표지점 x, y
	static int[][] map;
	static boolean[][] vis;
	static StringTokenizer st;
	static BufferedReader br;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		vis = new boolean[N][M];
		initMap();
		Point target = new Point(x, y);
		bfs(target);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!vis[i][j] && map[i][j] == 1) {
					System.out.print(-1 + " ");
				} else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs(Point start) {
		Queue<Point> que = new LinkedList<>();
		que.add(start);
		map[start.c][start.r] = 0;

		while (!que.isEmpty()) {
			Point p = que.poll();
			vis[p.c][p.r] = true;
			for (int[] ints : dir) {
				int nextR = p.r + ints[0];
				int nextC = p.c + ints[1];
				if (nextR < 0 || nextC < 0 || nextC >= N || nextR >= M)
					continue;

				if (map[nextC][nextR] == 1 && !vis[nextC][nextR]) {
					que.add(new Point(nextR, nextC));
					map[nextC][nextR] = map[p.c][p.r] + 1;
				}
			}
		}
	}

	public static void initMap() throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					y = i;
					x = j;
				}
			}
		}
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) { // 가로, 세로
			this.r = r;
			this.c = c;
		}
	}
}

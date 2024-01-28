package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502_연구소 {
	static int N, M; // 세로⬇️, 가로➡️
	static int[][] map;
	static ArrayList<Point> list;
	static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Point(i, j));
				}
			}
		}
		// 0 인 위치마다 벽을 세워보기 (dfs) -> 안전지대 체크 (bfs)
		dfs(0);
		System.out.println(result);
	}

	public static void dfs(int w) {
		if (w == 3) {
			bfs();
			return;
		}
		for (Point t : list) {
			if (map[t.r][t.c] == 0) {
				map[t.r][t.c] = 1;
				dfs(w + 1);
				map[t.r][t.c] = 0;
			}
		}
	}

	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					que.add(new Point(i, j));
				}
			}
		}
		// 기존의 지도가 아닌 새로운 지도(복사된)에서 확인
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			newMap[i] = map[i].clone();
		}

		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int[] ints : dir) {
				int nR = p.r + ints[0];
				int nC = p.c + ints[1];
				if (!checkRange(nR, nC) || newMap[nR][nC] != 0) {
					continue;
				}
				if (newMap[nR][nC] == 0) {    // 다음 자리가 0 이면 큐에 넣고 2로 변경
					que.add(new Point(nR, nC));
					newMap[nR][nC] = 2;
				}
			}
		}
		checkSafe(newMap);
	}

	public static void checkSafe(int[][] nM) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nM[i][j] == 0) {
					cnt++;
				}
			}
		}
		result = Math.max(result, cnt);
	}

	public static boolean checkRange(int nextR, int nextC) {
		return nextR >= 0 && nextC >= 0 && nextR < N && nextC < M;
	}

	public static class Point {
		int r; // 가로 row ➡️
		int c; // 세로 col ⬇️
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

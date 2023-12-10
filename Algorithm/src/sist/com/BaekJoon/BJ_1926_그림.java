package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1926_그림 {
	static int n, m;    // 세로⬇️, 가로➡️
	public static int[] x = {-1, 0, 1, 0};
	public static int[] y = {0, -1, 0, 1};
	static int cnt = 0;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxArea = Integer.MIN_VALUE;
		int areaCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					areaCnt++;
					cnt = 0;
					int area = bfs(i, j);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		if (areaCnt == 0){
			maxArea = 0;
		}
		System.out.println(areaCnt);
		System.out.println(maxArea);
	}

	public static int bfs(int ni, int nj) {
		map[ni][nj] = 0;
		int area = 1;
		int nextN, nextM;
		for (int i = 0; i < 4; i++) {
			nextN = ni + x[i];
			nextM = nj + y[i];
			if (nextN < n && nextM < m && nextN >= 0 && nextM >= 0) {
				if (map[nextN][nextM] == 1) {
					area += bfs(nextN, nextM);
				}
			}
		}
		return area;
	}
}

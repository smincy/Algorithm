package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
	static int R, C;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		if (R == 1 && C == 1){
			System.out.println(1);
			return;
		}
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		System.out.println(ans);
	}

	public static void dfs(int a, int b, int c) {
		if (visited[map[a][b]]) {
			ans = Math.max(ans, c);
			return;
		} else {
			visited[map[a][b]] = true;
			for (int[] dir : dir) {
				int x = a + dir[0];
				int y = b + dir[1];
				if (x >= 0 && x < R && y >= 0 && y < C) {
					dfs(x, y, c + 1);
				}
			}
			visited[map[a][b]] = false;
		}
	}
}

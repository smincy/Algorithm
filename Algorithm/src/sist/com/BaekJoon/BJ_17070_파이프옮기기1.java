package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 현재 방향, 가능한 다음 방향 체크, 해당 방향의 필요빈공간 체크
		// 목적지 도달 가능한 루트의 개수
		dfs(0, 1, 0);
		System.out.println(result);

	}

	// dir = 0 세로, 1 가로, 2 대각
	public static void dfs(int a, int b, int dir) {
		if (a == N - 1 && b == N - 1) {
			result++;
			return;
		}
		switch (dir) {
			case 0:
				if (b + 1 < N && map[a][b + 1] == 0) {
					dfs(a, b + 1, dir);
				}
				break;
			case 1:
				if (a + 1 < N && map[a + 1][b] == 0) {
					dfs(a + 1, b, dir);
				}
				break;
			case 2:
				if (a + 1 < N && map[a + 1][b] == 0) {
					dfs(a + 1, b, 1);
				}
				if (b + 1 < N && map[a][b + 1] == 0) {
					dfs(a, b + 1, 0);
				}
				break;
		}
		if (a + 1 < N && map[a + 1][b] == 0 && b + 1 < N && map[a][b + 1] == 0 && map[a + 1][b + 1] == 0) {
			dfs(a + 1, b + 1, 2);
		}
	}
}

/**
 * dfs 호출 시 다음 위치와 방향을 실수하지 않도록 조심...
 */

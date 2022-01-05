package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백트래킹

public class BJ_15649_N과M1 {
	// 방문 확인 배열
	public static boolean[] vis;
	// 출력용 배열
	public static int[] arr;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BJ_15649_N과M1 s = new BJ_15649_N과M1();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp[] = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		// 1부터 N 까지 중복없이 M 개를 고른 수열

		vis = new boolean[N];

		arr = new int[M];

		s.dfs(N, M, 0);
		
		System.out.println(sb);

	}

	public void dfs(int N, int M, int dep) { // dep : 깊이
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) { // 0 부터 N 까지 확인

			// 방문하지 않은 곳이라면?
			if (vis[i] == false) {
				// 방문처리
				vis[i] = true;
				// 깊이를 index로 사용해서 출력배열에 입력
				arr[dep] = i + 1;
				// 다음 깊이 재귀호출
				dfs(N, M, dep + 1);
				// 재귀에서 돌아온 후에는 방문노드 false 처리
				vis[i] = false;
			}
		}
	}
}

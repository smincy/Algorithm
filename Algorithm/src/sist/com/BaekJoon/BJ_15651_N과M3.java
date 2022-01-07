package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트레킹

public class BJ_15651_N과M3 {

	public static int N, M;
	public static int[] arr;;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BJ_15651_N과M3 s = new BJ_15651_N과M3();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		s.dfs(0);
		
		System.out.println(sb);
	}

	public void dfs(int dep) {
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[dep] = i;
			dfs(dep + 1);
		}
	}
}

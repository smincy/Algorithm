package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백트레킹

public class BJ_15652_N과M4 {

	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;

	public static void main(String[] args) throws Exception {

		BJ_15652_N과M4 s = new BJ_15652_N과M4();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		arr = new int[M];

		s.dfs(1,0);

		System.out.println(sb);

	}

	public void dfs(int a, int dep) {
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = a; i <= N; i++) {
			arr[dep] = i;
			dfs(a, dep + 1);
			a++;
		}
	}
}

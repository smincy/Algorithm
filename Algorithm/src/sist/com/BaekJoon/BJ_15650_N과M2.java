package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백트레킹

public class BJ_15650_N과M2 {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BJ_15650_N과M2 s = new BJ_15650_N과M2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		arr = new int[M];

		s.dfs(1, 0);

		System.out.println(sb);
	}

	public void dfs(int a, int dep) { // a 는 어디서 부터 시작하는지, 1부터 시작하므로
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = a; i <= N; i++) {
			arr[dep] = i;
			dfs(i + 1, dep + 1);	// 다음탐색구간은 탐색시작도 1 증가해야하므로
						// 그냥 i 로 할 경우 1 1 , 2 2 자신과 같은 위치도 탐색 
		}
	}
}

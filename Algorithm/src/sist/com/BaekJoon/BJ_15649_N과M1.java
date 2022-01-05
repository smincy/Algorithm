package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ��Ʈ��ŷ

public class BJ_15649_N��M1 {
	// �湮 Ȯ�� �迭
	public static boolean[] vis;
	// ��¿� �迭
	public static int[] arr;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BJ_15649_N��M1 s = new BJ_15649_N��M1();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp[] = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		// 1���� N ���� �ߺ����� M ���� �� ����

		vis = new boolean[N];

		arr = new int[M];

		s.dfs(N, M, 0);
		
		System.out.println(sb);

	}

	public void dfs(int N, int M, int dep) { // dep : ����
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) { // 0 ���� N ���� Ȯ��

			// �湮���� ���� ���̶��?
			if (vis[i] == false) {
				// �湮ó��
				vis[i] = true;
				// ���̸� index�� ����ؼ� ��¹迭�� �Է�
				arr[dep] = i + 1;
				// ���� ���� ���ȣ��
				dfs(N, M, dep + 1);
				// ��Ϳ��� ���ƿ� �Ŀ��� �湮��� false ó��
				vis[i] = false;
			}
		}
	}
}

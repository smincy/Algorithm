package sist.com.BaekJoon;
// ȥ��Ǯ��
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15649_N��M1_2 {

	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static boolean vis[];

	public static void main(String[] args) throws Exception {

		BJ_15649_N��M1_2 s = new BJ_15649_N��M1_2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		arr = new int[M];
		vis = new boolean[N];
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

		for (int i = 0; i < N; i++) {
			if (vis[i] == false) {	// ���� ���ڴ� ������ �ȵ�
				vis[i] = true;
				arr[dep] = i + 1;
				dfs(dep + 1);
				// ��� Ż�� �� �湮 �ʱ�ȭ
				vis[i] = false;
			}
		}
	}
}

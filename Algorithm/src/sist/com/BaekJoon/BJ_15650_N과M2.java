package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ��Ʈ��ŷ

public class BJ_15650_N��M2 {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BJ_15650_N��M2 s = new BJ_15650_N��M2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		arr = new int[M];

		s.dfs(1, 0);

		System.out.println(sb);
	}

	public void dfs(int a, int dep) { // a �� ��� ���� �����ϴ���, 1���� �����ϹǷ�
		if (dep == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = a; i <= N; i++) {
			arr[dep] = i;
			dfs(i + 1, dep + 1);	// ����Ž�������� Ž�����۵� 1 �����ؾ��ϹǷ�
								// �׳� i �� �� ��� 1 1 , 2 2 �ڽŰ� ���� ��ġ�� Ž�� 
		}
	}
}

package sist.com.BaekJoon;

// DP 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_�����ﰢ�� {
	public static int N;
	public static int[][] arr;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BJ_1932_�����ﰢ�� s = new BJ_1932_�����ﰢ��();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}

		System.out.println(s.sam(0, 0));

	}

	public int sam(int h, int y) { // ��/�� �� �Է�
		if (h == N - 1) {
			// ������ ���� ������ �� ���� ��ȯ
			return dp[h][y];
		}

		if (dp[h][y] == -1) { // ã�� ���� ����̸� ���� ��,���� ��/�� ������ ���
			// ���� ��ġ�� ��/�� ���� ū���� �ش���ġ arr ���� ���ؼ� ����
			dp[h][y] = Math.max(sam(h + 1, y), sam(h + 1, y + 1)) + arr[h][y];
		}
		// �������� ���� ū���� ���� �ǵ��� ����� �� ���� ����
		return dp[h][y];
	}
}

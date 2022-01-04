package sist.com.BaekJoon;

// DP 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형 {
	public static int N;
	public static int[][] arr;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BJ_1932_정수삼각형 s = new BJ_1932_정수삼각형();

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

	public int sam(int h, int y) { // 행/열 을 입력
		if (h == N - 1) {
			// 마지막 행을 만나면 그 값을 반환
			return dp[h][y];
		}

		if (dp[h][y] == -1) { // 찾는 곳이 빈곳이면 다음 행,열의 좌/우 값으로 재귀
			// 다음 위치의 좌/우 값중 큰갑과 해당위치 arr 값과 더해서 저장
			dp[h][y] = Math.max(sam(h + 1, y), sam(h + 1, y + 1)) + arr[h][y];
		}
		// 마지막에 가장 큰값이 저장 되도록 만들고 그 값을 리턴
		return dp[h][y];
	}
}

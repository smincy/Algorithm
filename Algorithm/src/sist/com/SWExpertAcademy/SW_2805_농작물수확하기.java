package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_2805_농작물수확하기 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int j = 0; j < N; j++) {
				String tmp = br.readLine();
				for (int k = 0; k < N; k++) {
					map[j][k] = tmp.charAt(k) - '0';
				}
			}
			// 농장을 위/아래 반으로 나눠서 계산
			int sum = 0;
			// 위
			for (int j = 0; j < N / 2; j++) {
				for (int k = N / 2 - j; k <= N / 2 + j; k++) {
					sum += map[j][k];
				}
			}
			// 하단 농장
			for (int j = N / 2; j >= 0; j--) {
				for (int k = N / 2 - j; k <= N / 2 + j; k++) {
					sum += map[N - j - 1][k];
				}
			}
			System.out.println("#" + (i + 1) + " " + sum);
		}
	}
	/*
	하단 농장 for문 범위 지정에서 -- 하는 부분과, map[N-j-1] 부분을 주의 깊게 봐야 할듯...
	 */
}

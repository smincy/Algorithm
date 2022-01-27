package sist.com.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2458_키순서 {

	public static int N, M;
	public static boolean[][] arr, check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new boolean[N][N];
		check = new boolean[N][N];

		// a 번호 학생이 b 번호 학생보다 키가 작다
		// arr[a>b] = check[b>a]
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a][b] = true;
			// 반대로도 비교가 되므로
			check[b][a] = true;
		}

		// arr, check 에 대해서 플로이드와샬 수행
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
					if (check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}

		// arr 에 check값과 or 비교연산 해서 값 대입
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] |= check[i][j];
			}
		}

		int cnt = 0;

		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				// 키 비교 불가능하면 다음 사람으로 continue
				if (!arr[i][j]) {
					continue outer;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}

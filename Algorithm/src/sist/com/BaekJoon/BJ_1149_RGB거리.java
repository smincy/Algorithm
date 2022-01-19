package sist.com.BaekJoon;

//다이나믹 프로그래밍
//1번집은 2번집과 색이 달라야한다, N번(끝집)은 N-1(끝전집)집과 색이 달라야 한다
//중간범위에서는 위아래 집과 색이 달라야 한

//for문으로도 풀이가능

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {

	public static int N;
	public static int[][] arr;
	public static int[][] dp;

	final static int red = 0;
	final static int green = 1;
	final static int blue = 2;

	public static void main(String[] args) throws Exception {
		BJ_1149_RGB거리 s = new BJ_1149_RGB거리();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 금액 입력
			arr[i][red] = Integer.parseInt(st.nextToken());
			arr[i][green] = Integer.parseInt(st.nextToken());
			arr[i][blue] = Integer.parseInt(st.nextToken());
		}

		// dp 첫번째 집값은 비용 첫번째 값으로 초기화
		// (첫번째집이 곧 마지막으로 탐색할 집, cost에서 0값으로 인식되지 않도록)
		dp[0][red] = arr[0][red];
		dp[0][green] = arr[0][green];
		dp[0][blue] = arr[0][blue];
		
		// 셋 중에 작은값 찾기
		int tmp = Math.min(s.cost(N - 1, red), Math.min(s.cost(N - 1, green), s.cost(N - 1, blue)));
		System.out.println(tmp);
	}

	public int cost(int N, int color) {
		// 입력한 집이 한번도 탐색하지 않은 집이라면
		// N번째 집 컬러색에 따라 이전집의 컬러금액 중 작은 값을 찾아서 더한 값을 dp에 저장
		if (dp[N][color] == 0) {
			if (color == red) {
				dp[N][red] = Math.min(cost(N - 1, green), cost(N - 1, blue)) + arr[N][red];
			} else if (color == green) {
				dp[N][green] = Math.min(cost(N - 1, red), cost(N - 1, blue)) + arr[N][green];
			} else {
				dp[N][blue] = Math.min(cost(N - 1, green), cost(N - 1, red)) + arr[N][blue];
			}
		}		// 컬러에 작은값을 더해서 넣어주고 더해서 넣어주고 끝나면 반환
		return dp[N][color];
	}
}

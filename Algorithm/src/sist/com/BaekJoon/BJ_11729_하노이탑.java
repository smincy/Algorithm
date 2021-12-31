package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/96
// 재귀

public class BJ_11729_하노이탑 {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BJ_11729_하노이탑 s = new BJ_11729_하노이탑();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		sb.append((int) (Math.pow(2, N) - 1)).append("\n");	// 형변환 주의
		
		s.Hano(N, 1, 2, 3);

		System.out.println(sb);

	}

	public void Hano(int N, int start, int mid, int to) {
		// 옮겨야 되는 탑이 1개 인 경우
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}

		// N-1개를 1번판에서 2번판으로 이동
		Hano(N - 1, start, to, mid);

		// 1번판 가장 아래탑을 3번판으로 이동 (횟수 1번 이므로)
		sb.append(start + " " + to + "\n");

		// N-1개를 2번판에서 3번판으로 이동
		Hano(N - 1, mid, start, to);
	}
}

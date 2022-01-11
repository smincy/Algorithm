package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백트레킹
// 좀더공부필요(2022.01.11)

public class BJ_9663_NQueen {

	public static int N; // 주어지는 체스판의 크기
	public static int arr[];
	public static int cnt = 0; // 구해야 하는 값

	public static void main(String[] args) throws Exception {
		BJ_9663_NQueen s = new BJ_9663_NQueen();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		s.Queen(0);
		System.out.println(cnt);

	}

	public void Queen(int dep) { 
		// dep 는 열
		if (dep == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[dep] = i;
			// 놓을 수 있는 위치라면 재귀호출
			if (check(dep)) {
				Queen(dep + 1);
			}
		}

	}

	public boolean check(int col) { // 열
		for (int i = 0; i < col; i++) {
			// 들어온 열의 행값과 같은 행에 있으면 안되므로 열마다 같은 행의 값이 있는지 확인, 있다면 false
			if (arr[col] == arr[i]) {
				return false;
			}
			// 행의 차와 열의 차가 같은 경우 대각선에 위치한 것
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		// 모든 false 조건 확인 완료되었다면 ture 리턴
		return true;
	}

}

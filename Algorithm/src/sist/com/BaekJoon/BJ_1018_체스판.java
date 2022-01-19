package sist.com.BaekJoon;

//브루트포스
//8x8로 자른다고 하였으므로 (가로-7) x (세로-7) , 흑백 두가지 이므로
//총 경우의 수는  2 x (가로-7) x (세로-7)

//코드 분석은 되었으나, 문제를 접하고 혼자서 풀이과정을 만들어내기까지 아직 역량부족한듯... (2022.01.12) 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1018_체스판 {

	public static int M, N; // M행, N열
	public static boolean map[][];

	public static int min = 64; // 최소값

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BJ_1018_체스판 s = new BJ_1018_체스판();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		map = new boolean[N][M];

		// 체스판 상태 입력
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == 'W') {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}

		int N_row = N - 7; // 행 차이
		int M_col = M - 7; // 열 차이

		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				// 가로,세로 차이만큼 경우의수가 늘어나므로 그만큼 하나하나 확인
				s.find(i, j);
			}
		}
		
		System.out.println(min);

	}

	public void find(int x, int y) {
		// 8칸으로 잘라져있으므로 가로, 세로의 마지막 index는 시작값의 +8
		int ex = x + 8;
		int ey = y + 8;
		
		int cnt = 0; // 색을 칠하는 경우의 수

		boolean st = map[x][y]; // ù��° ĭ�� ���¸� �������� ��Ƴ���

		for (int i = x; i < ex; i++) {	// 시작값 x 부터 시작
			for (int j = y; j < ey; j++) {  // 시작값 y 부터 시작
				if (map[i][j] == st) { // 기준상태과 다를 경우 색 칠해주기
					cnt++;
				}
				// 다음 (열)칸은 색 상태가 바뀌어야 하므로
				st = !st;
			}
			// 다음 (행)줄의 시작색 상태도 바뀌어야 하므로
			st = !st;
		}
		// 시작 기준 색이 서로 다른 경우에 색을 치하는 횟수 중에서 더 작은 값을 저장
		cnt = Math.min(cnt, 64 - cnt);

		// 이전에 저장했던 min에 저장한 cnt보다 더 작은 cnt가 나올 경우 갱신
		min = Math.min(min, cnt);

	}
}

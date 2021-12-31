package sist.com.BaekJoon;
// 3줄 빙고시 게임끝

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {
	public static int Map[][] = new int[5][5];
	public static int bingCnt = 0;

	public static void main(String[] args) throws Exception {
		BJ_2578_빙고 s = new BJ_2578_빙고();

		int num[] = new int[25]; // 사회자가 부르는 숫자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < Map.length; i++) {
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp, " ");
			for (int j = 0; j < 5; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int a = 0;

		for (int i = 0; i < 5; i++) {
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp, " ");
			for (int j = 0; j < 5; j++) {
				num[a] = Integer.parseInt(st.nextToken());
				a++;
			}
		}
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (Map[j][k] == num[i]) {
						Map[j][k] = 0;
						if (s.bingGo(Map)) {
							int result = i;
							System.out.println(result + 1);
							return;
						}
					}
				}
			}
		}

	}// Main

	public boolean bingGo(int[][] num) {

		if (Map[0][0] == 0 && Map[1][1] == 0 && Map[2][2] == 0 && Map[3][3] == 0 && Map[4][4] == 0) {
			++bingCnt;
		}
		if (Map[4][0] == 0 && Map[3][1] == 0 && Map[2][2] == 0 && Map[1][3] == 0 && Map[0][4] == 0) {
			++bingCnt;
		}

		int tmp = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (Map[i][j] == 0) {
					tmp++;
				}
			}
			if (tmp == 5) { // 행검사
				++bingCnt;
			}
			tmp = 0;

			for (int j = 0; j < 5; j++) {
				if (Map[j][i] == 0) {
					tmp++;
				}
			}
			if (tmp == 5) { // 열검사
				++bingCnt;
			}
			tmp = 0;
		}

		if (bingCnt >= 3) {
			return true;
		} else {
			bingCnt = 0;
			return false;
		}
	}
}

package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1220_Magnetic {

	// 1 은 N극, 2 는 S극
	// 테이블 윗부분은 N극, 아래부분은 S극

	static int length;
	static BufferedReader br;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			length = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			setMap(map);
			int result = 0;
			for (int j = 0; j < 100; j++) {
				int magnet = 0;
				for (int k = 0; k < 100; k++) {
					if (map[k][j] == 1) {
						magnet = 1;
					} else if (map[k][j] == 2) {
						if (magnet == 1) {
							result++;
						}
						magnet = 2;
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + result);
		}
	}

	public static void setMap(int[][] map) throws IOException {
		for (int i = 0; i < 100; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 100; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if ((i == 0 && map[i][j] == 2) || (i == 99 && map[i][j] == 1)) {
					map[i][j] = 0;
				}
			}
		}
	}
}

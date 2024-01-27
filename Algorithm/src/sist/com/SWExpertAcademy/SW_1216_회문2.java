package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1216_회문2 {
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(br.readLine());
			map = new char[100][100];

			for (int j = 0; j < 100; j++) {
				String tmp = br.readLine();
				for (int k = 0; k < 100; k++) {
					map[j][k] = tmp.charAt(k);
				}
			}
			System.out.println("#" + T + " " + search(map));
		}
	}

	public static int search(char[][] map) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		String str = "";
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sb.setLength(0);

				for (int k = j; k < 100; k++) {
					sb.append(map[i][k]);
					str = sb.toString();
					if (str.contentEquals(sb.reverse())) {
						result = Math.max(result, str.length());
						sb.reverse();
					} else
						sb.reverse();
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sb.setLength(0);
				for (int k = j; k < 100; k++) {
					sb.append(map[k][i]);
					str = sb.toString();
					if (str.contentEquals(sb.reverse())) {
						result = Math.max(result, str.length());
						sb.reverse();
					} else
						sb.reverse();
				}
			}
		}
		return result;
	}
}

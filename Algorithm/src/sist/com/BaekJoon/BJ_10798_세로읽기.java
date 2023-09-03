package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10798_세로읽기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		char[][] str = new char[5][15];
		for (int i = 0; i < 5; i++) {
			String tmp = br.readLine();
			max = Math.max(max, tmp.length());
			for (int j = 0; j < tmp.length(); j++) {
				str[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (str[j][i] == '\0')
					continue;
				System.out.print(str[j][i]);
			}
		}
	}
}

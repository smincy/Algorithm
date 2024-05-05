package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10431_줄세우기 {
	static int P;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		P = Integer.parseInt(br.readLine());
		arr = new int[20];
		// 테스트케이스 번호, 뒤로 물러난 걸음 수의 총합
		for (int i = 0; i < P; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int tcNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 20; j++) {
				for (int k = 0; k < j; k++) {
					if (arr[j] < arr[k]) {
						cnt++;
					}
				}
			}
			System.out.println(tcNum + " " + cnt);
		}
	}
}

package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1217_거듭제곱 {
	static int N, M, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 1;

			power(N, 1);
			System.out.println("#" + T + " " + result);
		}
	}

	public static void power(int n, int p) {
		if (p <= M) {
			result *= n;
			power(n, p + 1);
		}
	}
}

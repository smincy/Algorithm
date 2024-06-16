package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ_1417_국회의원선거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}
		Integer[] arr = new Integer[N - 1];

		// 다솜이는 기호 1번
		int dasom = Integer.parseInt(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int result = 0;

		while (true) {
			Arrays.sort(arr, Collections.reverseOrder());
			if (arr[0] < dasom)
				break;
			dasom += 1;
			arr[0] -= 1;
			result++;
		}
		System.out.println(result);
	}
}

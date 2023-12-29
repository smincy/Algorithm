package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_예산 {
	static int N, M, min, max;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		max = Integer.MIN_VALUE;
		min = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		M = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		if (sum <= M) {
			System.out.println(max);
		} else {
			System.out.println(search());
		}
	}

	public static int search() {
		while (min < max) {
			int mid = (min + max) / 2;
			int midSum = 0;
			for (int i = 0; i < N; i++) {
				if (mid < arr[i]) {
					midSum += mid;
				} else {
					midSum += arr[i];
				}
			}
			if (M < midSum) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return (min - 1);
	}
}

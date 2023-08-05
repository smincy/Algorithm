package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_25400_제자리 {
	static int N, result;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			que.add(arr[i]);
		}

		if (que.isEmpty()) {
			System.out.println(N);
			return;
		}
		result = 0;

		int idx = 1;
		while (!que.isEmpty()) {
			int num = que.poll();
			if (num != idx) {
				result++;
			} else {
				idx++;
			}
		}
		System.out.println(result);
	}
}

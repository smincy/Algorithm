package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기 {
	static int N, num;
	static int[] arr;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			que.add(Integer.parseInt(br.readLine()));
		}

		while (que.size() > 1) {
			int num1 = que.poll();
			int num2 = que.poll();

			num += num1 + num2;
			que.add(num1 + num2);
		}
		System.out.println(num);
	}
}

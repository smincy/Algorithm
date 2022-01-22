package sist.com.BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1946_신입사원 {
	public static int N;
	public static int arr[][];
	

	public static void main(String[] args) throws Exception {
		BJ_1946_신입사원 s = new BJ_1946_신입사원();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][2];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			System.out.println(s.emp());

		}

	}

	public static int emp() {
		int cnt = 1;		// 서류점수 1등은 일단 선발
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int gen = arr[0][1]; // 서류심사 1등의 면접성적을 기준으로

		for (int i = 1; i < N; i++) {
			if (arr[i][1] < gen) { // 기준값 보다 작다는건 순위가 높다는 말이므로 선발
				// 선발된 사람의 면접성적을 다시 기준값으로 넣어준다
				gen = arr[i][1];
				cnt++;
			}
		}
		return cnt;
	}

}

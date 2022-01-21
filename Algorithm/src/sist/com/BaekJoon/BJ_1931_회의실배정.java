package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

public class BJ_1931_회의실배정 {

	public static int N;
	public static int[][] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 끝나는 시간이 같은 경우 시작시간을 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int cnt = 0; // 구해야 하는 값, 몇개?
		int end = 0; // 끝나는 시간 저장소

		for (int i = 0; i < N; i++) {
			if (end <= arr[i][0]) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

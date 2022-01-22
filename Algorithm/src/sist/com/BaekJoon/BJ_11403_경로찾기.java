package sist.com.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {

	public static int N;
	public static int[][] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int k = 0; k < N; k++) { // 거쳐가는 곳
			 sb = new StringBuilder();
			for (int i = 0; i < N; i++) { // 출발지점
				for (int j = 0; j < N; j++) { // 도착지점
					if (arr[i][k] == 1 && arr[k][j] == 1) { // 갈수 있는 정점이라고 1로 주어져있다면
						arr[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}

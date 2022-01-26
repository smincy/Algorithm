package sist.com.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1956_운동 {

	public static int V, E; // V 개 마을, E개 도로
	public static int arr[][];
	public static final int num = 987654321;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		arr = new int[V][V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				arr[i][j] = num;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < E; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int output = num;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j) {
					continue;
				}

				if (arr[i][j] != num && arr[j][i] != num) {
					output = Math.min(output, arr[i][j] + arr[j][i]);
				}
			}
		}
		output = (output == num) ? -1 : output;
		System.out.println(output);
	}
}

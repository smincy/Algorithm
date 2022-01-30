package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

public class BJ_2606_바이러스 {

	public static int N, M;
	public static int arr[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		bfs();

	}

	public static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		int cnt = 0;
		boolean vis[] = new boolean[N];
		
		que.add(0);
		vis[0] = true;
		
		while (!que.isEmpty()) {
			int p = que.poll();

			for (int i = 0; i < N; i++) {
				if (arr[p][i] == 1 && vis[i] == false) {
					arr[p][i] = 0;
					arr[i][p] = 0;
					que.add(i);
					vis[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}

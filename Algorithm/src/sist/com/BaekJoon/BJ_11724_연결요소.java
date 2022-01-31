package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

public class BJ_11724_연결요소 {

	public static int N, M;
	public static int arr[][];
	public static boolean vis[];
	public static int cnt = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BJ_11724_연결요소 s = new BJ_11724_연결요소();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		vis = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (vis[i] == false) {
				s.bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.add(start);
		vis[0] = true;

		while (!que.isEmpty()) {
			int p = que.poll();
			for (int i = 0; i < N; i++) {
				if (arr[p][i] == 1 && vis[i] == false) {
					que.add(i);
					vis[i] = true;
				}
			}
		}
	}

}

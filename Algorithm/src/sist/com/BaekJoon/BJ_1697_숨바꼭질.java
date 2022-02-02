package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질 {
	public static int N, K, time;
	public static int vis[] = new int[100001];

	public static void main(String[] args) throws Exception {

		BJ_1697_숨바꼭질 s = new BJ_1697_숨바꼭질();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		s.bfs(N);

	}

	public void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.add(start);
		vis[start] = 1;

		while (!que.isEmpty()) {
			int n = que.poll();

			if (n == K) {
				System.out.println(vis[n] - 1);
				return;
			}

			if (n - 1 >= 0 && vis[n - 1] == 0) {
				que.add(n - 1);
				vis[n - 1] = vis[n] + 1;
			}
			if (n + 1 <= 100000 && vis[n + 1] == 0) {
				que.add(n + 1);
				vis[n + 1] = vis[n] + 1;
			}
			if (n * 2 <= 100000 && vis[n * 2] == 0) {
				que.add(n * 2);
				vis[n * 2] = vis[n] + 1;
			}

		}

	}

}

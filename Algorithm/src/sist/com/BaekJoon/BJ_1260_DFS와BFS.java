package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

public class BJ_1260_DFS와BFS {

	public static int N, M, V;
	public static int map[][];
	public static boolean vis[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BJ_1260_DFS와BFS s = new BJ_1260_DFS와BFS();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()) - 1;

		map = new int[N][N];
		vis = new boolean[N];

		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// 주어지는 간선은 양방향
			map[a][b] = 1;
			map[b][a] = 1;
		}

		s.dfs(V);
		System.out.print(sb);
		System.out.println();
		// bfs 검사 하기 전에 방문처리배열 초기화
		Arrays.fill(vis, false);
		sb.setLength(0);
		s.bfs(V);
		System.out.print(sb);

	}

	public void dfs(int V) {
		vis[V] = true;
		sb.append(V + 1 + " ");
		for (int i = 0; i < N; i++) {
			// dfs 들어온 정점에서 목적지로의 간선이 있으면 1 이므로
			// 그리고 방문하지 않은 정점이라면 그 지검을 dfs 재귀수행
			if (map[V][i] == 1 && vis[i] == false) {
				dfs(i);
			}
		}
	}

	public void bfs(int V) {
		Queue<Integer> que = new LinkedList<Integer>();
		// 시작값을 큐에 넣고
		que.add(V);
		// 방문처리
		vis[V] = true;

		while (!que.isEmpty()) { 	// 큐가 빌때 까지 반복 수행
			int num = que.poll(); 	// 큐에 들어있는 수를 빼줌
			sb.append((num + 1) + " ");

			for (int i = 0; i < N; i++) {
				// 뺀 수와 다른 노드이고, 간선이 있는 노드이면서, 방문하지 않은 노드라면
				if (map[num][i] == 1 && vis[i] == false) {
					que.add(i); 	// 다시 큐에 넣어주기
					vis[i] = true; 	// 넣으면서 방문처리
				}
			}
		}
	}
	
}

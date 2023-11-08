package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
	static int V, E, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		boolean[] vis = new boolean[V + 1];
		int[] result = new int[V + 1];
		List<Node>[] list = new List[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
			result[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}

		PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		result[K] = 0;
		que.add(new Node(K, 0));

		while (!que.isEmpty()) {
			Node now = que.poll();
			if (!vis[now.end])
				vis[now.end] = true;
			for (int i = 0; i < list[now.end].size(); i++) {
				Node next = list[now.end].get(i);
				if (!vis[next.end] && now.weight + next.weight < result[next.end]) {
					result[next.end] = now.weight + next.weight;
					que.add(new Node(next.end, result[next.end]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (result[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}
	}
}

/*
 참고 : https://sa11k.tistory.com/75
 */
class Node {
	int end;
	int weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

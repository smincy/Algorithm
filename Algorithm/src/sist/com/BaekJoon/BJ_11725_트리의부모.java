package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모 {

	public static int N;
	public static int arr[];
	public static boolean vis[];
	public static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BJ_11725_트리의부모 s = new BJ_11725_트리의부모();
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// 부모노드 번호 저장 배열
		arr = new int[N];

		// 방문확인
		vis = new boolean[N];

		// 각 노드별로 연결되어 있는 노드 번호 입력해둘 리스트 배열
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			// 각 노드마다 리스트 형태로 선언 (연결된 노드번호 입력)
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// a 리스트에 a - b 연결 되어 있으므로 b 입력
			list[a].add(b);
			// b 리스트에 b - a 연결 되어 있으므로 a 입력
			list[b].add(a);
		}

		s.dfs(0);
		for (int i = 1; i < N; i++) {
			System.out.println(arr[i] + 1);
		}

	}

	public void dfs(int s) {
		// dfs 들어온 값 방문 처리
		vis[s] = true;

		// 들어온 s와 연결되어 있는 노드 중 방문하지 않은 노드를 dfs 에 넣어주고,
		// 방문하지 않았다는건 자식 노드 이므로 s가 부모노드
		for (int i : list[s]) {
			if (!vis[i]) {
				arr[i] = s;
				dfs(i);
			}
		}
	}

}

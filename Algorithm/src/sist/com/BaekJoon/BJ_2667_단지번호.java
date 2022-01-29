package sist.com.BaekJoon;

import java.io.*;
import java.util.*;

// 		Loc 클래스를 만들지 않고, que만을 이용하여도 문제 풀이 가능

public class BJ_2667_단지번호 {

	static class Loc {
		int i;
		int j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static int N;
	public static int map[][];
	public static boolean vis[][];
	public static int[] x = { 1, -1, 0, 0 };
	public static int[] y = { 0, 0, 1, -1 };
	public static ArrayList<Integer> al = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BJ_2667_단지번호 s = new BJ_2667_단지번호();
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		vis = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && vis[i][j] == false) {
					s.bfs(i, j);
				}
			}
		}

		Collections.sort(al); // 내림차순 출력을 위한 리스트 정렬
		System.out.println(al.size());
		for (int i : al) {
			System.out.println(i);
		}

	}

	public void bfs(int i, int j) {
		// 전달 받은 좌표로부터 주변집의 좌표를 저장할 큐 생성
		Queue<Loc> que = new LinkedList<>();
//		Queue<int[]> que = new LinkedList<>();

		int nx, ny; // 상화 좌우 임시로 넣어줄 변수
		int cnt = 0; // 단지별 집의 개수 카운타변수

		que.add(new Loc(i, j)); // 들어온 좌표를 큐에 넣고
//		que.add(new int[] {i, j});
		vis[i][j] = true; // 방문처리

		while (!que.isEmpty()) {
			Loc p = que.poll();
			
			// 현재위치
//			int xnow = que.peek()[0];
//			int ynow = que.peek()[1];
			
			// 건물 좌표 확인 했으므로 cnt 증가
			cnt++;
			for (int k = 0; k < 4; k++) { // 상하좌우 확인
				nx = p.i + x[k];
				ny = p.j + y[k];

				// 지도 범위 밖으로 넘어가는 경우는 패스
				if (nx >= N || nx < 0 || ny >= N || ny < 0) {
					continue;
				}

				// 방문하지 않은 지점이면 방문처리 후 큐에 넣어준다
				if (!vis[nx][ny] && map[nx][ny] == 1) {
					vis[nx][ny] = true;
					que.add(new Loc(nx, ny));
				}
			}
		}
		// 큐가 빌때까지 수행 후 cnt(건물개수) 를 리스트에 넣어준다
		al.add(cnt);
	}

}

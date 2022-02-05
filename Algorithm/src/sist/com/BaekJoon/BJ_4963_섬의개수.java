package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수 {

	public static int w, h, cnt;
	public static int arr[][];
	public static boolean vis[][];
	public static int[] x = { 1, -1, 0, 0, 1, -1, -1, 1 };
	public static int[] y = { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BJ_4963_섬의개수 s = new BJ_4963_섬의개수();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			cnt = 0;
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w]; // h = i, w = j
			vis = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				String temp = br.readLine();
				st = new StringTokenizer(temp, " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (vis[i][j] == false && arr[i][j] == 1) {
						s.dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

	public void dfs(int nh, int nw) { // nh = i, nw = j
		if (nh == 0 && nw == 0 && arr[nh][nw] == 0) {
			return;
		}

		vis[nh][nw] = true;

		int nextX, nextY;

		for (int i = 0; i < 8; i++) {
			nextX = nw + x[i];
			nextY = nh + y[i];

			if (nextX >= w || nextX < 0 || nextY >= h || nextY < 0) {
				continue;
			}

			if (!vis[nextY][nextX] && arr[nextY][nextX] == 1) {
				vis[nextY][nextX] = true;
				dfs(nextY, nextX);
			}

		}

	}

}

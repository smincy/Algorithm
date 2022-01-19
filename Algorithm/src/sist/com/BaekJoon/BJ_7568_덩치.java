package sist.com.BaekJoon;

//브루트포스 알고리즘

//StringBuilder 로 만드는게 더 효율적일듯

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_7568_덩치 {
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 N = Integer.parseInt(br.readLine());

		int body[][] = new int[N][2];

		String tmp[];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			body[i][0] = Integer.parseInt(tmp[0]);
			body[i][1] = Integer.parseInt(tmp[1]);
		}

		BJ_7568_덩치 s = new BJ_7568_덩치();

		s.rank(body);
	}

	public void rank(int a[][]) {

		for (int i = 0; i < N; i++) {
			int rnk = 1;
			for (int j = 0; j < N; j++) {
				// i번째 j번째 사람 같은 경우는 패스
				if (i == j) {
					continue;
				}
				if (a[i][0] < a[j][0] && a[i][1] < a[j][1]) {
					// i번째 사람과 j번째 사람의 몸무게 비교 && 키 비교
					// i번째 사람보다 큰 사람이 있으면 순위는 +1
					rnk++;
				}
			}
			System.out.print(rnk + " ");
		}
	}
}

package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// // 정렬 / new Comparator<int[]> 사용방법 공부필요(22.01.02)

public class BJ_11651_좌표정렬2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BJ_11651_좌표정렬2 s = new BJ_11651_좌표정렬2();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2];

		String[] tmp;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				point[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		s.sort(point);
	}

	public void sort(int[][] p) {

		Arrays.sort(p, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}

		});

		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}

	}
}

package sist.com.BaekJoon;

// ���Ʈ���� �˰���

// StringBuilder �� ����°� �� ȿ�����ϵ�

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_7568_��ġ {
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

		BJ_7568_��ġ s = new BJ_7568_��ġ();

		s.rank(body);
	}

	public void rank(int a[][]) {

		for (int i = 0; i < N; i++) {
			int rnk = 1;
			for (int j = 0; j < N; j++) {
				// i��° j��° ��� ���� ���� �н�
				if (i == j) {
					continue;
				}
				if (a[i][0] < a[j][0] && a[i][1] < a[j][1]) {
					// i��° ����� j��° ����� ������ �� && Ű ��
					// i��° ������� ū ����� ������ ������ +1
					rnk++;
				}
			}
			System.out.print(rnk + " ");
		}
	}
}

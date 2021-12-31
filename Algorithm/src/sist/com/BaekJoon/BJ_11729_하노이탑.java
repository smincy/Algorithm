package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/96
// ���

public class BJ_11729_�ϳ���ž {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BJ_11729_�ϳ���ž s = new BJ_11729_�ϳ���ž();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		sb.append((int) (Math.pow(2, N) - 1)).append("\n");	// ����ȯ ����
		
		s.Hano(N, 1, 2, 3);

		System.out.println(sb);

	}

	public void Hano(int N, int start, int mid, int to) {
		// �Űܾ� �Ǵ� ž�� 1�� �� ���
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}

		// N-1���� 1���ǿ��� 2�������� �̵�
		Hano(N - 1, start, to, mid);

		// 1���� ���� �Ʒ�ž�� 3�������� �̵� (Ƚ�� 1�� �̹Ƿ�)
		sb.append(start + " " + to + "\n");

		// N-1���� 2���ǿ��� 3�������� �̵�
		Hano(N - 1, mid, start, to);
	}
}

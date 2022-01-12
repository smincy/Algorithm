package sist.com.BaekJoon;

// ���Ʈ����
// 8x8�� �ڸ��ٰ� �Ͽ����Ƿ� (����-7) x (����-7) , ��� �ΰ��� �̹Ƿ�
// �� ����� ����  2 x (����-7) x (����-7)

// �ڵ� �м��� �Ǿ�����, ������ ���ϰ� ȥ�ڼ� Ǯ�̰����� ��������� ���� ���������ѵ�... (2022.01.12) 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1018_ü���� {

	public static int M, N; // M��, N��
	public static boolean map[][];

	public static int min = 64; // �ּҰ�

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BJ_1018_ü���� s = new BJ_1018_ü����();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		map = new boolean[N][M];

		// ü���� ���� �Է�
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == 'W') {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}

		int N_row = N - 7; // �� ����
		int M_col = M - 7; // �� ����

		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				// ����,���� ���̸�ŭ ����Ǽ��� �þ�Ƿ� �׸�ŭ �ϳ��ϳ� Ȯ��
				s.find(i, j);
			}
		}
		
		System.out.println(min);

	}

	public void find(int x, int y) {
		// 8ĭ���� �߶��������Ƿ� ����, ������ ������ index�� ���۰��� +8
		int ex = x + 8;
		int ey = y + 8;
		
		int cnt = 0; // ���� ĥ�ϴ� ����� ��

		boolean st = map[x][y]; // ù��° ĭ�� ���¸� �������� ��Ƴ���

		for (int i = x; i < ex; i++) {	// ���۰� x ���� ����
			for (int j = y; j < ey; j++) { // ���۰� y ���� ����
				if (map[i][j] == st) { // ���ػ��°� �ٸ� ��� �� ĥ���ֱ�
					cnt++;
				}
				// ���� (��)ĭ�� �� ���°� �ٲ��� �ϹǷ�
				st = !st;
			}
			// ���� (��)���� ���ۻ� ���µ� �ٲ��� �ϹǷ�
			st = !st;
		}
		// ���� ���� ���� ���� �ٸ� ��쿡 ���� ġ�ϴ� Ƚ�� �߿��� �� ���� ���� ����
		cnt = Math.min(cnt, 64 - cnt);

		// ������ �����ߴ� min�� ������ cnt���� �� ���� cnt�� ���� ��� ����
		min = Math.min(min, cnt);

	}
}

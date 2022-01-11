package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ��Ʈ��ŷ
// ���������ʿ�(2022.01.11)

public class BJ_9663_NQueen {

	public static int N; // �־����� ü������ ũ��
	public static int arr[];
	public static int cnt = 0; // ���ؾ� �ϴ� ��

	public static void main(String[] args) throws Exception {
		BJ_9663_NQueen s = new BJ_9663_NQueen();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		s.Queen(0);
		System.out.println(cnt);

	}

	public void Queen(int dep) { 
		// dep �� ��
		if (dep == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[dep] = i;
			// ���� �� �ִ� ��ġ��� ���ȣ��
			if (check(dep)) {
				Queen(dep + 1);
			}
		}

	}

	public boolean check(int col) { // ��
		for (int i = 0; i < col; i++) {
			// ���� ���� �ప�� ���� �࿡ ������ �ȵǹǷ� ������ ���� ���� ���� �ִ��� Ȯ��, �ִٸ� false
			if (arr[col] == arr[i]) {
				return false;
			}
			// ���� ���� ���� ���� ���� ��� �밢���� ��ġ�� ��
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		// ��� false ���� Ȯ�� �Ϸ�Ǿ��ٸ� ture ����
		return true;
	}

}

package sist.com.BaekJoon;

// ���̳��� ���α׷���
//1������ 2������ ���� �޶���Ѵ�, N��(����)�� N-1(������)���� ���� �޶�� �Ѵ�
//�߰����������� ���Ʒ� ���� ���� �޶�� ��

// for�����ε� Ǯ�̰���

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB�Ÿ� {

	public static int N;
	public static int[][] arr;
	public static int[][] dp;

	final static int red = 0;
	final static int green = 1;
	final static int blue = 2;

	public static void main(String[] args) throws Exception {
		BJ_1149_RGB�Ÿ� s = new BJ_1149_RGB�Ÿ�();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// �ݾ� �Է�
			arr[i][red] = Integer.parseInt(st.nextToken());
			arr[i][green] = Integer.parseInt(st.nextToken());
			arr[i][blue] = Integer.parseInt(st.nextToken());
		}

		// dp ù��° ������ ��� ù��° ������ �ʱ�ȭ
		// (ù��°���� �� ���������� Ž���� ��, cost���� 0������ �νĵ��� �ʵ���)
		dp[0][red] = arr[0][red];
		dp[0][green] = arr[0][green];
		dp[0][blue] = arr[0][blue];
		
		// �� �߿� ������ ã��
		int tmp = Math.min(s.cost(N - 1, red), Math.min(s.cost(N - 1, green), s.cost(N - 1, blue)));
		System.out.println(tmp);
	}

	public int cost(int N, int color) {
		// �Է��� ���� �ѹ��� Ž������ ���� ���̶��
		// N��° �� �÷����� ���� �������� �÷��ݾ� �� ���� ���� ã�Ƽ� ���� ���� dp�� ����
		if (dp[N][color] == 0) {
			if (color == red) {
				dp[N][red] = Math.min(cost(N - 1, green), cost(N - 1, blue)) + arr[N][red];
			} else if (color == green) {
				dp[N][green] = Math.min(cost(N - 1, red), cost(N - 1, blue)) + arr[N][green];
			} else {
				dp[N][blue] = Math.min(cost(N - 1, green), cost(N - 1, red)) + arr[N][blue];
			}
		}		// �÷��� �������� ���ؼ� �־��ְ� ���ؼ� �־��ְ� ������ ��ȯ
		return dp[N][color];
	}
}

package sist.com.BaekJoon;
//https://crazykim2.tistory.com/507

// ���� n �� ������ n�� ���ڸ��� ���ڸ� ���� ��
// ��) 34 => 34 + 3 + 4 = 41
// 34 % 10 = 4 , 34 / 10 = 3

// �����ڰ� ���� ���ڸ� �����ѹ� ��� �Ѵ�. �����ѹ��� ����϶�

public class BJ_4673_�����ѹ� {

	public static void main(String[] args) {
		BJ_4673_�����ѹ� s = new BJ_4673_�����ѹ�();

		// �����ѹ��� �ƴ� ��� true
		boolean check[] = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			int n = s.Self(i);
			if (n < 10001) {
				check[n] = true;
				// Self �Ի�⿡�� ������ ���ڵ��� �� �����ڰ� �ִ� �����̹Ƿ� �����ѹ��� �ƴ�
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (check[i] != true) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	public int Self(int n) {
		int total = n;
		while (n != 0) {
			total += (n % 10); // 1 �� �ڸ� ���ϱ�
			n /= 10; // 10�� �ڸ� ����� �ٽ� ����Ȯ��
		}
		return total;
	}
}

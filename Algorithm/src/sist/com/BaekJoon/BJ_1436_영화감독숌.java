package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���Ʈ���� �˰���

// 1 ~ 10000 ���� �ϳ��ϳ� �˻縦 �ϸ鼭 666�� �����ϴ� ���ڸ� ī��Ʈ
// ã�� ������ ī��Ʈ�� ������ �˻��� ���ڸ� ���
public class BJ_1436_��ȭ������ {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// ù��° �����Ǽ��� 666 / 1
		int num = 666;
		int cnt = 1;

		while (N != cnt) {
			num++;

			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}

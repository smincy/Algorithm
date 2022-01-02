package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 브루트포스 알고리즘

// 1 ~ 10000 까지 하나하나 검사를 하면서 666을 포함하는 숫자를 카운트
// 찾는 순서의 카운트와 같을때 검사한 숫자를 출력
public class BJ_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 첫번째 종말의숫자 666 / 1
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

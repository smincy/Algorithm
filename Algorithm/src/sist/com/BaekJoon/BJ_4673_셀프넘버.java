package sist.com.BaekJoon;
//https://crazykim2.tistory.com/507

//숫자 n 이 들어오면 n과 각자리의 숫자를 더한 값
//예) 34 => 34 + 3 + 4 = 41
//34 % 10 = 4 , 34 / 10 = 3

//생성자가 없는 숫자를 셀프넘버 라고 한다. 셀프넘버를 출력하라

public class BJ_4673_셀프넘버 {

	public static void main(String[] args) {
		BJ_4673_셀프넘버 s = new BJ_4673_셀프넘버();

		// 셀프넘버가 아닌 경우 true
		boolean check[] = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			int n = s.Self(i);
			if (n < 10001) {
				check[n] = true;
				// Self 게산기에서 나오는 숫자들은 다 생성자가 있는 숫자이므로 셀프넘버가 아님
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
			total += (n % 10); // 1 의 자리 더하기
			n /= 10; // 10의 자리 남기고 다시 루프확인
		}
		return total;
	}
}

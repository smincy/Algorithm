package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(br.readLine());
			Queue<Integer> que = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int minus = 1;
			while (!que.isEmpty()) {
				int num = que.poll();
				if (num - minus <= 0) {
					que.add(0);
					break;
				} else {
					que.add(num - minus++);
					if (minus > 5) {
						minus = 1;
					}
				}
			}
			System.out.print("#" + T + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
		}
	}
}

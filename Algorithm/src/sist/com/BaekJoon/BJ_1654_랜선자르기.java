package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {
	static int K, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());    // 가지고 온 랜선의 개수
		N = Integer.parseInt(st.nextToken());    // 필요한	랜선의 개수
		long max = 0;
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			// 입력과 동시에 랜선 길이 최댓값 저장
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		max++;

		long min = 0;		// 시작 최소값은 0
		long mid;

		while (min < max) {
			mid = (max + min) / 2;

			long cnt = 0;
			for (int j : arr) {
				cnt += (j / mid);
			}
			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		// UpperBound로 얻어진 값(min) = 타겟값을 초과하는 첫 위치의 인덱스이므로 -1
		System.out.println(min - 1);
	}
}
/*
	이분 탐색에 대한 문제인데 조금 관점을 다르게 봐야하는 문제,,
	조금 알것도 같지만,, 구글링이 필요했으므로 완벽하게 이해하지 못한 것 같다.
 */

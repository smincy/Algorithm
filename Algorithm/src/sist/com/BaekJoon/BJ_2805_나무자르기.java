package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());    // 나무의 수
		M = Integer.parseInt(st.nextToken());    // 필요한 길이

		int[] arr = new int[N];
		int max = 0;
		int min = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for (int i : arr) {
				if (i - mid > 0) {
					sum += (i - mid);
				}
			}
			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}
/*
// AI
package Algorithm.src.sist.com.BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> heights = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 첫 번째 줄 읽기
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int numTrees = Integer.parseInt(tokenizer.nextToken());
		int requiredLength = Integer.parseInt(tokenizer.nextToken());

		// 두 번째 줄 읽기
		tokenizer = new StringTokenizer(reader.readLine());
		int maxHeight = 0;

		// 나무들의 높이를 리스트에 저장하면서 가장 큰 높이 찾기
		for (int i = 0; i < numTrees; i++) {
			int height = Integer.parseInt(tokenizer.nextToken());
			heights.add(height);
			maxHeight = Math.max(maxHeight, height);
		}

		// 이진 탐색 시작
		int low = 0;
		int high = maxHeight;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			long total = 0;

			for (int height : heights) {
				if (height > mid) {
					total += height - mid;
				}
			}

			if (total >= requiredLength) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		// 결과 출력
		System.out.println(high);
	}
}*/

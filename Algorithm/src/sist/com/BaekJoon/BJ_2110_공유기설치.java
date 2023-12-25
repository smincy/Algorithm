package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
	static int N, C;    // 집의 개수, 공유기의 개수
	static int[] arr;    // 집의 좌표 x

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		// 공유기 설치 최소거리 최소값 1
		int lo = 1;
		// 설치가능거리 최대값
		int hi = arr[N - 1] - arr[0] + 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;    // 공유기 설치 가능거리의 중간값
			// 시작 설치가능거리 중간값으로 설치했을때 공유기 개수에 못미치면
			// 중간값을 내려야함 (거리를 좁혀야함) = hi를 줄인다.

			if (install(mid) < C) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}

	public static int install(int distance) {
		// 첫번째 집은 무조건 설치
		int cnt = 1;
		// 시작 당시의 마지막 집은 곳 첫집이므로 0
		int last = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int now = arr[i];
			// 현재 집 위치와 직전에 설치한 집의 위치간 거리가 최소거리(distance) 보다 크거나 같을 때
			// 공유기 설치 개수를 늘려주고
			// 마지막 설치 위치 갱신
			if (now - last >= distance) {
				cnt++;
				last = now;
			}
		}
		return cnt;
	}
}

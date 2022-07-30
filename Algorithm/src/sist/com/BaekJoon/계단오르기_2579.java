package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//  DP

public class 계단오르기_2579 {
    static int N;
    static int[] arr;
    static Integer[] dp;

    // 계단은 한단 or 두단계
    // 연속 3개는 X
    // 마지막 계단은 무조건 밟아야함

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        // N 에 1이 입력될 경우의 예외처리
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));


    }

    // Top-Down
    public static int find(int T) {
        if (dp[T] == null) {
            dp[T] = Math.max(find(T - 2), find(T - 3) + arr[T - 1]) + arr[T];
        }
        return dp[T];
    }

    // Bottom-Up
    public static int find2(int T2) {
        for (int i = 3; i <= T2; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }
        return dp[T2];
    }
}

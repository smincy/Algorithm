package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11049_행렬곱셈순서 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] in = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            in[i][0] = Integer.parseInt(st.nextToken());
            in[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else if (j == i + 1) {
                    dp[i][j] = in[i][0] * in[i][1] * in[j][1];
                } else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 2; i < N; i++) {  // 행렬 개수
            for (int j = 0; j < N - i; j++) {   // 시작 지점
                for (int k = j; k < j + i; k++) {   // 중간 지점
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + (in[j][0] * in[k][1] * in[i + j][1]));
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
// 점화식 만들어 내는게 너무 어려움...
// 다른 분들의 점화실을 봐도 이해하기 어려워서 좀 더 공부가 필요함
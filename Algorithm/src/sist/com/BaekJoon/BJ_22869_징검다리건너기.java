package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22869_징검다리건너기 {
    static int N, K;
    static int[] A;
    static boolean[] res;

    // i번째 돌에서 j번째 돌로 이동할 때 (j-i) * (1 + |Ai - Aj|) 만큼의 힘을 쓴다
    // 돌을 한번 건너갈 때마다 쓸 수 있는 힘은 최대 K
    // 이때, 가장 왼족 돌에서 가장 오른쪽 돌로 건너갈 수 있는지
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        res = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp(1);
        System.out.println(res[N] ? "YES" : "NO");
    }

    public static void dp(int i) {
        if (i == N) {
            res[i] = true;
            return;
        }
        if (res[i])
            return;

        res[i] = true;
        for (int j = i + 1; j <= N; j++) {
            if (((j - i) * (1 + Math.abs(A[i] - A[j]))) <= K) {
                dp(j);
            }
        }
    }
}

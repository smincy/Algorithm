package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_24499_blobyum {
    static int K, N;
    static int[] apple;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        apple = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }
        int right = K - 1;  // 오른쪽
        int left = 0;       // 왼쪽
        int sum = 0;
        for (int i = 0; i < K; i++) {
            // 시작자리의 맛의 합 입력
            sum += apple[i];
        }
        max = sum;
        while (true) {
            // 왼쪽 값 빼주고
            sum -= apple[left];
            // 왼쪽점, 오른쪽점 이동
            left = (left + 1) % N;
            right = (right + 1) % N;
            // 오른쪽 값 더해주기
            sum += apple[right];
            // 큰값 찾기
            if (left == 0) {
                break;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

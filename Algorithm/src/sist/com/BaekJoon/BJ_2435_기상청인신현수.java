package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2435_기상청인신현수 {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = i; j < i + K; j++) {
                if (j >= arr.length){
                    tmp = Integer.MIN_VALUE;
                    break;
                }
                tmp += arr[j];
            }
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }
}

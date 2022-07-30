package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 더하기123_9095 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 테스트케이스 만큼 주어지는 양수 n은 11 이하 양수
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = 4; j <= x; j++) {
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            System.out.println(arr[x]);
        }
    }
}

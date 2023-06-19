package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25377_빵 {
    static int N, min;
    static boolean check;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        // 현재 위치에서 이 가게까지 가는 데 걸리는 시간
        // 이 가게에 빵 들어올 때까지 남은 시간

        min = Integer.MAX_VALUE;
        check = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if (arr[i][0] <= arr[i][1]) {
                check = true;
                buy(arr[i][1]);
            }
        }

        if (check) {
            System.out.println(min);
        } else System.out.println(-1);

        // 빵을 살 수 없다면 -1
        // 살 수 있으면 최소 시간
        // 빵이 가게에 도착하는 순간이나 도착하기 전에 가게에 도착해야함,
        // 빵이 도착한 이후에 가게에 가면 이미 늦어서 빵이 없다.

    }

    public static void buy(int i) {
        if (i < min) {
            min = i;
        }
    }
}

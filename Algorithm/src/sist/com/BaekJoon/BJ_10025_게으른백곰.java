package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_10025_게으른백곰 {
    // 얼음 양동이 N 개
    // 얼음 g 개
    // 백곰크기 K (자리 잡으면 좌우로 K 만큼 닿을 수 있다)
    // 최적의 자리를 골랐을 대 얼음의 합, 최댓값을 구하라
    static int N, K, g, x;
    static int[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        list = new ArrayList<>();
        int tmpMax = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            g = Integer.parseInt(st.nextToken());   // 얼음의 양
            x = Integer.parseInt(st.nextToken());   // 좌표
            arr[i] = x;
            list.add(g);
            if (x > tmpMax)
                tmpMax = x;
        }
        int[] map = new int[tmpMax + 1];
        // 가장 큰값 15
        // map = 0 ~ 14
        for (int i = 0; i < N; i++) {
            // 해당 좌표에 얼음개수 입력
            map[arr[i]] = list.get(i);
        }
        // 시작위치
        int point = K;
        // 왼쪽점, 오른쪽점
        int left = 0, right = point + K;
        int sum = 0;
//        while (map.length > right) {
//            sum = 0;
//            for (int i = left; i <= right; i++) {
//                sum += map[i];
//            }
//            result = Math.max(result, sum);
//            left++;
//            right++;
//        }

        int len = (2 * K) + 1;
        for (int i = 0; i < map.length; i++) {
            if (i >= len) {
                sum -= map[i - len];
            }
            sum += map[i];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}

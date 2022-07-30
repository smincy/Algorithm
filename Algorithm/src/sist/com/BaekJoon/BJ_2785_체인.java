package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2785_체인 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int cnt = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        // 합친 체인의 길이는 상관없이
        // 가장 작은 체인을 이용하여 나머지 체인들을 연결하고 체인 개수 줄이기
        while (true) {
            if (arr.size() <= 1)
                break;
            // 가장 작은 체인의 길이를 1 줄이기
            arr.set(0, arr.get(0) - 1);
            // 체인 개수 줄이기
            arr.remove(arr.size() - 1);
            if (arr.get(0) == 0) {
                // 첫번째 가장 작은 체인이 0 이 되면 체인 없애기
                arr.remove(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}

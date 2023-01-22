package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12847_꿀아르바이트 {
    static int N, M;
    static Long[] arrT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrT = new Long[N];
        Long[] tmp = new Long[N];

        st = new StringTokenizer(br.readLine(), " ");
        long num = 0;
        for (int i = 0; i < N; i++) {
            arrT[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            num += arrT[i];
        }

        // M일 일 해서 벌 수 있는 최대 이익
        // max 에 0,1,2 의 합을 첫 최대이익으로 넣어줌
        long max = num;

        for (int i = M; i < N; i++) {
            // 그다음 날짜 3 위치부터 num에 더하고, 전날 값 빼주고
            num += arrT[i] - arrT[i - M];
            // 그 합을 max와 비교
            max = Math.max(max, num);
        }
        System.out.println(max);
    }
}

package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카약과강풍_2891 {
    static int N, S, R; // 팀수, 파손팀수, 여분팀수
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        // 두번째 줄에 손상된 팀의 번호가 S개 주어지고
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < S; i++) {
            arr[Integer.parseInt(st.nextToken())] -= 1;
        }
        // 세번째 줄에 여분 카약 있는 팀의 번호가 R개 주어
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < R; i++) {
            arr[Integer.parseInt(st.nextToken())] += 1;
        }

        // 출발 할 수 없는 팀의 최소값 = 가장 많이 출발

        for (int i = 1; i <= N; i++) {
            if (arr[i] == 1) {
                if (i == 1) {
                    if (arr[i + 1] == -1) {
                        arr[i] = 0;
                        arr[i + 1] = 0;
                    }
                } else if (i == N) {
                    if (arr[i - 1] == -1) {
                        arr[i - 1] = 0;
                        arr[i] = 0;
                    }
                } else {
                    if ((arr[i - 1] == -1 && arr[i + 1] == -1)
                            || (arr[i - 1] == -1 && arr[i + 1] >= 0)) {
                        arr[i - 1] = 0;
                        arr[i] = 0;
                    } else if (arr[i - 1] >= 0 && arr[i + 1] == -1) {
                        arr[i + 1] = 0;
                        arr[i] = 0;
                    }
                }
            }
        }

        result = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == -1) {
                result++;
            }
        }
        System.out.println(result);
    }
}

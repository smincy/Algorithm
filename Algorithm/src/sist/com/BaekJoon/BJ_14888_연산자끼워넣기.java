package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int[] oper = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 덧셈, 뺄셈, 곱셈, 나눗셈 순서
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 숫자와 첫 단계 (사용 숫자 1개)
        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    // 각 연산자를 배열로 두고, 수를 둔다면?
    // 연산자 개수 (4가지) 반복문 안에서 재귀호출로 1개씩 --, 0 인 경우 다음 연산자로 넘어가기
    public static void dfs(int num, int idx) {
        if (idx == N) {
            // idx가 숫자의 개수와 같은 경우 모든 숫자를 다 사용했다는 가정으로 최대, 최소값을 리턴
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                switch (i) {
                    case 0:
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                // 재귀호출 종료시 다시 연산자 개수 복귀
                oper[i]++;
            }
        }
    }
}

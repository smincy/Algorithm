package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_24479_알고리즘수업_깊이우선탐색1 {
    static int M, N, R;
    static int[] check; // 방문 체크
    static StringBuilder sb = new StringBuilder();
    static int cnt; // 방문 순서

    static ArrayList<ArrayList<Integer>> gr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // i 번째 줄에 정점 i 의 방문 순서를 출력, 방문할 수 없는 경우 0 출력

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        check = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gr.get(x).add(y);
            gr.get(y).add(x);
        }

        for (int i = 1; i < gr.size(); i++) {
            Collections.sort(gr.get(i));
        }

        cnt = 1;    // 시작 정점 초기값 1
        dfs(R);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int a) {
        check[a] = cnt;

        for (int i = 0; i < gr.get(a).size(); i++) {
            int newA = gr.get(a).get(i);
            if (check[newA] == 0) {
                cnt++;
                dfs(newA);
            }

        }
    }
}

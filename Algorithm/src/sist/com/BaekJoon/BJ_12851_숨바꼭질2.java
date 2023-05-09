package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12851_숨바꼭질2 {
    static int N, K, next_cur, count, minTime;
    static int[] vis;

    // 수빈 N , 동생 K
    // 걷거나 순간이동
    // 걷는다면 1초 후에 N-1 또는 N+1 로 이동
    // 순간이동을 한다면 1초 후에 2*N 으로 이동
    // 동생을 찾는 가장 빠른 시간, 가장 빠른 시간으로 동생을 찾는 방법의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        K = Integer.parseInt(st.nextToken());   // 동생의 위치

        vis = new int[100001];

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        bfs(N);
        System.out.println(minTime);
        System.out.println(count);


    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        count = 0;
        que.add(start);     // 큐에 수빈의 위치 입력
        vis[start] = 1;     // 현 위치(index)에서 다음 위치로 가기 위한 시간 (시작)

        minTime = Integer.MAX_VALUE / 16;

        while (!que.isEmpty()) {
            int curr = que.poll();  // 현재위치

            if (minTime < vis[curr]) {  // 동생을 찾기 전 이미 minTime 보다 시간이 높다면 리턴
                return;
            }
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        next_cur = curr + 1;    // 앞
                        break;
                    case 1:
                        next_cur = curr - 1;    // 뒤
                        break;
                    default:
                        next_cur = curr * 2;    // 순간이동
                }
                if (next_cur == K) {    // 다음 위치가 동생의 위치라면
                    minTime = vis[curr];    // 해당 위치를 index로 하는 시간을 minTime으로 입력
                    count++;                // 방법의 수 ++
                }

                if ((next_cur >= 0 && next_cur <= 100000) && (vis[next_cur] == 0 || vis[next_cur] == vis[curr] + 1)) {
                    // 범위 체크
                    que.add(next_cur);
                    vis[next_cur] = vis[curr] + 1;
                }
            }
        }
    }
}
// 위치를 인덱스로 하는 시간 배열 에 대한 이해도? 문제 해석(이해) 능력이 아직 좀 부족한 듯

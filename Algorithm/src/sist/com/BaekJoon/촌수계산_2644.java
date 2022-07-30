package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
    static int N, tA, tB, m, x, y, result;
    static int[][] arr;
    static boolean[] check;

    //전체 사람 수, 계산해야하는 사람 둘, 부모 자식 간의 관계의 개수, 부모자식관계인 번호
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        tA = Integer.parseInt(st.nextToken()) - 1;
        tB = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N];
        for (int i = 0; i < m; i++) {   // 앞 번호가 뒷 번호의 부모
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        dfs(tA, tB, 0);
        System.out.println(result == 0 ? -1 : result);
    }

    public static void dfs(int ta, int tb, int cnt) {
        check[ta] = true;
        if (ta == tb) {
            result = cnt;
            return;
        }
        for (int i = 0; i < N; i++) {
            // 방문하지 않았고, 관계가 1인 사람을 ta로 다시 넣기
            if (!check[i] && arr[ta][i] == 1) {
                check[i] = true;
                dfs(i, tB, cnt + 1);
                check[i] = false;
            }
        }
    }
}

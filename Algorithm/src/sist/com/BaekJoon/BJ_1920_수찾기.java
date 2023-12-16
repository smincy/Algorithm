package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
    static int N, M;
    static int[] arrN;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        M = Integer.parseInt(br.readLine());
        // 존재하면 1, 없으면 0
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            bsearch(arrN, target, 0, arrN.length - 1);
        }
    }
    // 재귀형식 (반복문 형식으로도 가능)
    public static void bsearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            System.out.println(0);
            return;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            System.out.println(1);
		} else if (arr[mid] > target) {
            bsearch(arr, target, start, mid - 1);
        } else {
            bsearch(arr, target, mid + 1, end);
        }
    }
}

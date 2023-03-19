package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1215_회문1 {
    static int[][] map;
    static boolean flag;
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            int pal = Integer.parseInt(br.readLine());
            initMap();

            if (pal == 1) {
                System.out.println("#" + i + " " + 64);
                continue;
            }
            result = 0;
            System.out.println("#" + i + " " + palindrome(pal));
        }
    }

    public static int palindrome(int p) {
        // 오른쪽, 아래
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8 - p; j++) {
                flag = false;
                pm(i, j, j + p - 1);
                if (flag)
                    result++;
                flag = false;
                pmr(i, j, j + p - 1);
                if (flag)
                    result++;
            }
        }
        return result;
    }

    public static void pm(int i, int leftj, int rightj) {
        int nextLj = leftj + 1;
        int nextRj = rightj - 1;
        if (map[leftj][i] == map[rightj][i]) {
            if (nextLj >= nextRj) {
                flag = true;
                return;
            }
            pm(i, nextLj, nextRj);
        }
        return;
    }

    public static void pmr(int i, int leftj, int rightj) {
        int nextLj = leftj + 1;
        int nextRj = rightj - 1;
        if (map[i][leftj] == map[i][rightj]) {
            if (nextLj >= nextRj) {
                flag = true;
                return;
            }
            pmr(i, nextLj, nextRj);
        }
        return;
    }

    public static void initMap() throws IOException {
        map = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
    }
}
package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1209_Sum {
    static int tmpRdSum, tmpLdSum, tmpRowSum, tmpColSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            int max = Integer.MIN_VALUE;
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            tmpRdSum = 0;
            tmpLdSum = 0;

            for (int j = 0; j < 100; j++) { // 행
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 100; k++) { // 열
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 100; j++) {
                tmpRowSum = 0;
                tmpColSum = 0;
                for (int k = 0; k < 100; k++) {
                    tmpColSum += map[j][k];
                    tmpRowSum += map[k][j];
                }

                tmpRdSum += map[j][j];
                tmpLdSum += map[j][99 - j];

                if (max <= tmpColSum) {
                    max = tmpColSum;
                }
                if (max <= tmpRowSum) {
                    max = tmpRowSum;
                }
            }
            if (max <= tmpRdSum) {
                max = tmpRdSum;
            }
            if (max <= tmpLdSum) {
                max = tmpLdSum;
            }
            System.out.println("#" + T + " " + max);
        }
    }
}
// 뭔가 더 간결하게, 간단하게 할 수 있지 않을까...

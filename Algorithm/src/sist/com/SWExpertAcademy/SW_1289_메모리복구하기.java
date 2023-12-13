package Algorithm.Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1289_메모리복구하기 {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String origin = br.readLine();
            int result = 0;
            char target = '0';
            for (int j = 0; j < origin.length(); j++) {
                if (target != origin.charAt(j)) {
                    result++;
                    target = origin.charAt(j);
                }
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}

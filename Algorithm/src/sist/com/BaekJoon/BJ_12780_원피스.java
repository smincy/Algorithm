package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_12780_원피스 {
    static String str, target;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        target = br.readLine();

        char tmp = target.charAt(0);
        cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tmp) {
                strCheck(i);
            }
        }
        System.out.println(cnt);
    }

    public static void strCheck(int a) {
        if (a + target.length() <= str.length() && str.startsWith(target, a)) {
            cnt++;
        }
    }
}

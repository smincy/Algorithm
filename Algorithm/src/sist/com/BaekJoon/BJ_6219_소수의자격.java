package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6219_소수의자격 {
    static int A, B, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = A; i <= B; i++) {
            String tmp = String.valueOf(i);
            if (tmp.contains(String.valueOf(D))) {
                if (prime(i)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean prime(int num) {
        // 0, 1 은 소수가 아니므로
        if (num < 2) {
            return false;
        }
        // 2는 소수
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // 소수가 아닌 경우 (약수가 존재)
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

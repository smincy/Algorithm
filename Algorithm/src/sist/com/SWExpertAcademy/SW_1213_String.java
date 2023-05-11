package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1213_String {
    static int T;
    static String target, str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int count = 0;
            T = Integer.parseInt(br.readLine());
            target = br.readLine();
            str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == target.charAt(0)) {
                    boolean flag = false;
                    for (int k = 0; k < target.length(); k++) {
                        if (j + k >= str.length()) {
                            flag = false;
                            break;
                        }
                        if (str.charAt(j + k) == target.charAt(k)) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count++;
                    }
                }
            }
            System.out.println("#" + T + " " + count);
        }
    }
}
// 엉뚱한 곳에서 시간 허비를 좀 한듯..
// 이 문제 역시 다른 방법으로 풀면 뭔가 더 효율적이지 않을까 하는 생각이 계속 듬..
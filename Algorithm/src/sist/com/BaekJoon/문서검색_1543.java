package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문서검색_1543 {
    static String str, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        target = br.readLine();
        int cnt = 0;
        while (str.length() > 0) {
            if (str.startsWith(target)) {   // target으로 시작하는 위치를 만나면
                cnt++;
                str = str.substring(target.length());   // 그 이후 단어부터 다시 str로
            }else {
                str = str.substring(1); // 한개 단어씩 재입력하면서 반복
            }
        }
        System.out.println(cnt);
    }
}

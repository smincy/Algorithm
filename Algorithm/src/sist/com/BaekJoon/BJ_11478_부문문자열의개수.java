package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_11478_부문문자열의개수 {
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= str.length(); i++) {
            // 글자 개수
            for (int j = 0; j <= str.length() - i; j++) {
                if (!map.containsKey(str.substring(j, j + i)) && !str.substring(j, j + i).isEmpty()) {
                    map.put(str.substring(j, j + i), 1);
                }
            }
        }
        System.out.println(map.size());
    }
}

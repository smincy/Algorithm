package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1302_베스트셀러 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		N = Integer.parseInt(br.readLine());
		int max = 0;
		String result = "";
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}

			if (map.get(str) > max || (map.get(str) == max && str.compareTo(result) < 0)) {
				max = map.get(str);
				result = str;
			}
		}
		System.out.println(result);
	}
}

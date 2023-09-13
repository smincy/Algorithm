package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		HashMap<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < N + M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for (String name : map.keySet()) {
			if (map.get(name) > 1) {
				result.add(name);
			}
		}

		System.out.println(result.size());
		result.sort(String::compareTo);
		for (String name : result) {
			System.out.println(name);
		}
	}
}

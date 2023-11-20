package Algorithm.src.sist.com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SW_1221_GNS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			map = new HashMap<>();
			String[] tmp = br.readLine().split(" ");
			String tc = tmp[0];

			String[] input = br.readLine().split(" ");
			for (String in : input) {
				map.put(in, map.getOrDefault(in, 1) + 1);
			}

			printMap(tc, map);
		}
	}

	public static void printMap(String tc, Map<String, Integer> map) {
		System.out.print(tc + " ");
		String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		for (String number : numbers) {
			for (int i = 1; i < map.getOrDefault(number, 0); i++) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
	}
}

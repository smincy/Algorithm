package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2920_음계 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp, " ");
		
		int arr[] = new int[8];

		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		String out =  "";
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] - 1) {
				out = "ascending";
			} else if (arr[i] == arr[i + 1] + 1) {
				out = "descending";
			} else {
				out = "mixed";
				break;
			}
		}
		System.out.println(out);

	}

}

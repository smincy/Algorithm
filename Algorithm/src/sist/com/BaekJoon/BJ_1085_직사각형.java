package sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1085_직사각형 {

	public static int x, y, w, h;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		int[] arr = new int[4];

		arr[0] = 0 + x;
		arr[1] = 0 + y;
		arr[2] = w - x;
		arr[3] = h - y;

		Arrays.sort(arr);
		System.out.println(arr[0]);

	}

}

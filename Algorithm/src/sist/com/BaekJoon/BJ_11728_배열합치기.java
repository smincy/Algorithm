package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_11728_배열합치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ab = br.readLine().split(" ");

        int A = Integer.parseInt(ab[0]);
        int B = Integer.parseInt(ab[1]);

        int[] arr = new int[A + B];

        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");

        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(arrA[i]);
        }

        for (int i = 0; i < B; i++) {
            arr[A + i] = Integer.parseInt(arrB[i]);
        }
        Arrays.sort(arr);
        for (int a : arr) {
            bw.write(a + " ");
        }
        bw.flush();
        bw.close();
    }
}

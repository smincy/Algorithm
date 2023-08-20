package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15720_카우버거 {
	static int B, C, D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int minCount = Math.min(Math.min(B, C), D);
		int maxCount = Math.max(Math.max(B, C), D);

		int totalCount = 0;

		List<Integer> blist = new ArrayList<>();
		List<Integer> clist = new ArrayList<>();
		List<Integer> dlist = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B; i++) {
			int b = Integer.parseInt(st.nextToken());
			blist.add(b);
			totalCount += b;
		}
		blist.sort(Comparator.reverseOrder());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			int c = Integer.parseInt(st.nextToken());
			clist.add(c);
			totalCount += c;
		}
		clist.sort(Comparator.reverseOrder());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < D; i++) {
			int d = Integer.parseInt(st.nextToken());
			dlist.add(d);
			totalCount += d;
		}
		dlist.sort(Comparator.reverseOrder());

		System.out.println(totalCount);

		totalCount = 0;
		for (int i = 0; i < minCount; i++) {
			int set = blist.get(i) + clist.get(i) + dlist.get(i);
			int sale = (int) (set * 0.9);
			totalCount += sale;
		}

		for (int i = minCount; i < maxCount; i++) {
			if (i < blist.size())
				totalCount += blist.get(i);
			if (i < clist.size())
				totalCount += clist.get(i);
			if (i < dlist.size())
				totalCount += dlist.get(i);
		}
		System.out.println(totalCount);

	}
}
package Algorithm.src.sist.com.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class assignment {
	int day;
	int score;

	assignment(int day, int score) {			// 마감기한과 점수를 클래스로 관리
		this.day = day;
		this.score = score;
	}
}


public class BJ_13904_과제 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 마감 기한이 가장 오래 남은 순으로 정렬
		// 각 마감 기한에 가장 높은 점수를 선택
		// 선택 후 남은 점수과제는 마감 기한이 남은 경우 아래 기한에 추가해서 선택
		List<assignment> list = new ArrayList<>();
		int maxDay = 0, totalScore = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new assignment(d, s));
			maxDay = Math.max(maxDay, d);			// 가장 큰 마감기한 찾아두기
		}

		for (int i = maxDay; i > 0; i--) {	// 마감 기한이 가장 큰 날짜부터 큰 점수 찾아서 더해주기
			totalScore += getAssig(list, i);
		}
		System.out.println(totalScore);
	}

	public static int getAssig(List<assignment> alist, int today) {
		int index = -1;
		int result = 0;
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).day >= today && alist.get(i).score > result) {	// 호출 된 마감기한 날짜와 같거나, 더 큰 날짜
				result = alist.get(i).score;    	// 제일 큰 점수 찾기
				index = i;                        	// 해당 점수의 index 저장
			}
		}
		if (result == 0)
			return 0;
		alist.remove(index);                    // 해당 과제 삭제
		return result;
	}
}

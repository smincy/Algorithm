package Algorithm.src.sist.com.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 다리에 올라갈 수 있는 트럭의 수
        // 다리가 견딜 수 있는 무게
        // 트럭별 무게

        int tweig = 0;
        int time = 0;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (que.isEmpty()) {
                    // 큐가 비어있음 (다리 위에 트럭이 하나도 없는 경우)
                    que.add(truck);
                    tweig += truck;
                    time++;
                    break;
                } else if (que.size() == bridge_length) {
                    // 큐가 가득 (다리 위에 트럭이 가득)
                    tweig -= que.poll();
                } else {
                    // 큐에 공간이 있음 (다리 위에 자리가 있는 경우)
                    if (tweig + truck <= weight) {
                        // 다음 트럭과의 무게합이 적당한 경우
                        que.add(truck);
                        tweig += truck;
                        time++;
                        break;
                    } else if (tweig + truck > weight) {
                        // 다음 트럭과의 무게합이 초과인 경우
                        que.add(0);
                        time++;
                    }
                }
            }
        }
        // 마지막 트럭이 다리 위에 올라가고 나면 break; 되므로 다리를 빠져 나오기까지 필요한 시간 + 해줌
        answer = time + bridge_length;
        return answer;
    }
}

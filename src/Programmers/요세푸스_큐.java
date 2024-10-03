package Programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 요세푸스_큐 {
    static int solution(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }
    public static void main(String[] args) {
        System.out.println(solution(7, 3));
    }
}

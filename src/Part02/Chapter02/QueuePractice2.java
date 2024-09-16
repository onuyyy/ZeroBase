package Part02.Chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueuePractice2 {

    public static ArrayList getJosephusPermutation(int N, int K) {
        /*
            요세푸스 문제
            N과 K가 주어졌을 떄 (N, K) 요세푸스 순열을 구하기
            N >= K
            1 ~ N 까지의 N명이 순서대로 원을 이루어 모여있다.
            이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
            모든 사람이 제외될 때까지 반복하며 이 때, 제외되는 순서가 요세푸스 순열.

            입력 : N = 5, K = 2
            결과 : 2, 4, 1, 5, 3

            입력 : N = 7, K = 3
            결과 : 3, 6, 2, 7, 5, 1, 4
         */

        Queue<Integer> queue = new LinkedList<>();
        ArrayList list = new ArrayList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        int cnt = 0;
        while (!queue.isEmpty()) {
            int data = queue.remove();
            cnt += 1;

            if (cnt % K == 0) {
                list.add(data);
            } else {
                queue.add(data);
            }
        }

        return list;
    }

    public static int finfdLastCard(int N) {
        /*
            카드 섞기
            1 ~ N 까지의 카드가 있는데.
            1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태이다.
            아래 동작을 카드 한 장만 남을 때까지 반복했을 떄 가장 마지막 카드 번호
            1. 가장 위의 카드 버린다.
            2. 그 다음 위의 카드는 가장 아래에 다시 넣는다

            입력 : N = 4 / 결과 : 4
            입력 : N = 7 / 결과 : 6
         */

        Queue<Integer> queue = new LinkedList();

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1){
            queue.remove();
            int data = queue.remove();
            queue.add(data);
        }

        return queue.peek();
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        System.out.println(finfdLastCard(4));
        System.out.println(finfdLastCard(7));
        System.out.println(finfdLastCard(9));
        System.out.println();

        System.out.println("Solution 2");
        System.out.println(getJosephusPermutation(5, 2));
        System.out.println(getJosephusPermutation(7, 3));
    }
}

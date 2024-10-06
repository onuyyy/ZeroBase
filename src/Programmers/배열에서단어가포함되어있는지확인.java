package Programmers;

import java.util.*;

public class 배열에서단어가포함되어있는지확인 {
    static int solution2(int[] cards) {

        Arrays.sort(cards);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int c : cards) {
            q.add(c);
        }

        while (q.size() != 1) {
            int a = q.poll();
            int b = q.poll();

            q.add(a - b);
        }

        return q.poll();
    }
    static int solution(String sentence, String word) {

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(solution("Hello every world","every"));

        int[] arr = {4,8,6,1,2};
        System.out.println(solution2(arr));
    }
}

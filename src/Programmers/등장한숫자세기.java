package Programmers;

import java.util.*;

public class 등장한숫자세기 {

    static int solution2(int[] A, int K) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    String tmp = A[i] + "" + A[j];
                    list.add(tmp);
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        answer = Integer.valueOf(list.get(K - 1));

        return answer;
    }
    static int solution(int N, int K) {
        int answer = 0;
        String kk = String.valueOf(K);

        for (int i = 0; i <= N; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (kk.equals(String.valueOf(str.charAt(j)))) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(25, 2));
        int[] arr = {1,2,3,4,5};
        System.out.println(solution2(arr, 1));

    }
}

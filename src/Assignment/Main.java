package Assignment;

import java.util.Scanner;


public class Main {
    public static int solution4(String S) {
        int answer = 0;

        int num = Integer.parseInt(S, 2);
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                answer += 1;
            } else {
                num = num - 1;
                answer += 1;
            }
        }

        return answer;
    }
    public static int solution3(String s) {
        int answer = 0;
        int[] cnt = new int[10];

        for (String i : s.split("")) {
            cnt[Integer.parseInt(i)] += 1;
        }

        int maxCnt = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                answer = i;
            } else if (cnt[i] == maxCnt) {
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }
    public static int solution2(int[] A) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int tmp = -1;

        for (int i = 0; i < A.length - 1; i++) {
            if (min > A[i]) {
                min = A[i];
                tmp = i;
            }
        }

        for (int i = tmp + 1; i < A.length; i++) {
            if (A[i] > max) max = A[i];
        }
        if (tmp != -1 && max > min) {
            return max - min;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{100000, 98000, 95000, 98000, 92000};
        System.out.println(solution2(A));

        System.out.println(solution3("55223"));
        System.out.println(solution4("1101"));
    }
}

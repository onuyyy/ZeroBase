package Part02.Chapter02;

import java.util.HashSet;

public class BasicMathPractice2 {
    public static boolean solution(int n) {
        /*
            각 자리수를 제곱한 것을 더하는 과정을 반복했을 때 1로 끝나는 수
            입력 : 19
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1
         */

        // 1에 도달하지 못하고 계속 반복되면 false니까 중간 값들을 저장하여
        // 반복되면 false 처리 하기 위해 hashSet 사용
        HashSet<Integer> set = new HashSet<>();

        // set.add는 들어가지면 1, 아니면 -1 반환돼서
        // 이미 존재하는 요소이면 자동으로 false
        while (set.add(n)) {
            int squareSum = 0;

            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }

            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}

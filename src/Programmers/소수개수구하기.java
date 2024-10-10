package Programmers;

import java.awt.event.TextEvent;

public class 소수개수구하기 {

    static long factorial(int n) {
        // 팩토리얼 : 1~n까지 모든 자연수의 곱
        // 3! = 1 * 2 * 3
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static long combination(int n, int r) {
        // 조합 combination : 서로 다른 n개 중 r개를 선택하는 경우의 수
        // 순서 X, 중복 X
        // 5C3 = 5! / 3!(5-3)!
        if (n < r || r < 0) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    static long permutation(int n, int r) {
        if (n < r) return 0;
        return factorial(n) / factorial(n - r);
    }

    static long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;

        // 학생 수
        int stu = N;

        // 각 교실에 학생 배치
        for (int i = 0; i < M; i++) {
            // 현재 교실에 배치할 수 있는 최대 학생 수
            int capacityLimit = capacity[i];

            // 현재 교실에 수용할 수 있는 학생 수를 배치
            if (stu >= capacityLimit) {
                answer *= combination(stu, capacityLimit); // 남아 있는 학생 중 선택
                stu -= capacityLimit; // 선택한 학생 수만큼 남은 학생 수 감소
            } else {
                answer *= combination(stu, stu); // 남은 학생 모두 선택
                stu = 0; // 남은 학생 수 0으로 설정
            }
        }

        // 감독관 배치: M개의 교실에 감독관을 배치하는 경우의 수
        answer *= factorial(K); // 감독관을 M명 배치

        return answer; // 최종 가능한 경우의 수 반환
    }
    static int solution(int n) {
        // 소수 : 1과 자기 자신으로만 나누어지는 수
        int answer = 2;
        int num = 3;

        while (answer < n) {
            for (int i = 3; i <= n; i++) {
                if (i != num && i % num != 0) {
                    break;
                }
                if (i == num && i % num == 0) {
                    answer++;
                }
            }
            num++;
        }

        return answer;
    }
    public static void main(String[] args) {
        //System.out.println(solution(15));

        int[] capacity1 = {3, 3, 4};  // 각 교실의 최대 수용 인원
        System.out.println(solution(10, 3, 4, capacity1));  // 출력: 100800

        int[] capacity2 = {5, 3, 4};  // 각 교실의 최대 수용 인원
        System.out.println(solution(10, 3, 4, capacity2));
    }
}

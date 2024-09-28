package Programmers;

import java.util.Stack;

public class 문자열계산식 {
    public static int solution(String s) {
        int answer = 0;

        Stack<Integer> stack = new Stack();
        int num = 0; // 현재 숫자
        char sign = '+'; // 이전 연산자 기본값은 '+'로 설정

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0'); // 여러 자리 숫자 처리
            }

            // 현재 문자가 연산자이거나 문자열의 끝에 도달한 경우
            if (!Character.isDigit(cur) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num); // 현재 숫자를 스택에 추가
                } else if (sign == '-') {
                    stack.push(-num); // 현재 숫자의 부호를 반전하여 스택에 추가
                }
                // 현재 연산자를 업데이트
                sign = cur;
                num = 0; // 다음 숫자를 위해 초기화
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("-3+26-7"));
    }
}

package Programmers;

import java.util.Stack;

public class 중복문자열제거2 {
    public static int solution(String S) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("ABBA"));
    }
}

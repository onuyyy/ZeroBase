package Programmers;

import java.util.Stack;

public class 중복문자열제거 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        for (char c : stack) {
            // stack은 후입선출이나 for문로 접근할 시 순차적으로 읽어올 수 있음
            answer.append(c);
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        중복문자열제거 s = new 중복문자열제거();
        System.out.println(s.solution("ssvdff"));
    }
}

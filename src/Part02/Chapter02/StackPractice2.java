package Part02.Chapter02;

import java.beans.PropertyEditorSupport;
import java.util.Stack;

public class StackPractice2 {

    public static boolean stringCompare(String s1, String s2) {
        // #은 백스페이스이며 s1과 s2의 문자 비교
        // s1 : tree , s2 : th#ree => true
        String s1After = doBackSpace(s1);
        String s2After = doBackSpace(s2);

        return s1After.equals(s2After);

    }

    public static String doBackSpace(String s) {
        Stack stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack);
    }

    public static double calculate(String str) {
        // 후위표기법 연산
        // 2 2 + > 4
        // 2 2 - > 0
        Stack<Double> stack = new Stack<>();

        for (String s : str.split(" ")) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push( - stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        return stack.pop();
    }

    public static void  checkParenthesis(String str) {
        // 괄호 짝 검사
        // ( > fail
        // () > Pass

        Stack stack = new Stack();
        boolean flag = true;

        for (String s : str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty() && flag) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
    public static String reverseString(String str) {
        // 문자열 뒤집기
        // Hello > olleH

        String result = "";

        Stack stack = new Stack<>();

        for (String s : str.split("")) {
            stack.add(s);
        }

        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {

        System.out.println("Practice 1");
        String s = reverseString("Hello");
        System.out.println(s);

        s = reverseString("1 3 5 7 9");
        System.out.println(s);
        System.out.println();

        System.out.println("Practice 2");
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("(())()");
        checkParenthesis("((())");
        System.out.println();

        System.out.println("Practice 3");
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));
        System.out.println();

        System.out.println("Practice 4");
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}

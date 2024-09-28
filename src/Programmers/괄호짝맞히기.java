package Programmers;

import java.util.HashMap;
import java.util.Stack;

public class 괄호짝맞히기 {
    public static int solution(String S) {
        int answer = 1;

        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        map.put("<", ">");

        for (String str : S.split("")) {
            if (map.containsKey(str)) {
                stack.push(str);
            } else if (map.containsValue(str)) {
                if (stack.isEmpty()) {
                    answer = 0;
                    break;
                }
                String cur = stack.pop();
                if (!str.equals(map.get(cur))) {
                    answer = 0;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("([[{}])"));

    }
}

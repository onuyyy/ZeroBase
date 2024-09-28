package Programmers;

import java.util.HashMap;
import java.util.Map;

public class 가장많이등장하는문자출력 {

    public static String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        char cc = ' ';
        for (char c : s.toCharArray()) {
            // c가 map에 있으면 그 값을 가져와 1을 더하고,
            // 없으면 기본값 0을 사용하여 1을 더한다
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
           char curChar = e.getKey();
           int curCnt = e.getValue();

           if (curCnt > cnt || (cnt == curCnt && curChar < cc )) {
               cnt = curCnt;
               cc = curChar;
           }
        }

        return String.valueOf(cc);
    }
    public static void main(String[] args) {
        System.out.println(solution("google"));
    }
}

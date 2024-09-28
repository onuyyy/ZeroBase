package Programmers;

import java.util.HashMap;
import java.util.Map;

public class 없는이름출력 {
    public static String solution(String[] bj, String[] one, String[] two) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String b : bj) {
            map.put(b, 1);
        }

        for (String name : one) {
            map.remove(name);
        }

        // two 배열에서 이름 제거
        for (String name : two) {
            map.remove(name);
        }

/*        if (!map.isEmpty()) {
            answer = "1350만원" + "(" + map.keySet().iterator().next() + ")";
        }*/

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            answer = "1350만원" + "(" + e.getKey() + ")";
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] name1 = {"혁준", "하밥", "양상", "심심이", "소스왕"};
        String[] name2 = {"혁준", "양상"};
        String[] name3 = {"심심이", "소스왕"};

        System.out.println(solution(name1, name2, name3));

    }
}

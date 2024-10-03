package Programmers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class 포함된횟수가많은순서대로문자열반환 {
    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Hashtable<String, Integer> ht = new Hashtable<>();

        for (String str : s.split("")) {
            ht.put(str, ht.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(String.valueOf(i));
        }

        list.sort((a, b) -> {
            int cnt1 = ht.getOrDefault(a, 0);
            int cnt2 = ht.getOrDefault(b, 0);

            // 왜 내림차순이 되는가? 자바의Comparator는 음수, 0, 양수 값을 반환하여 비교하는데
            // 음수 : a가 b보다 앞에
            // 양수 : b가 a보다 앞에
            // 0 : 두 값이 같음
            if (cnt1 != cnt2) {
                // 빈도수 내림차순으로
                // 빈도수를 비교했을 때 더 크면
                return cnt2 - cnt1;
                // b > a 이니까 b가 앞에
                // a > b 이면 음수니까 a가 앞에
            } else {
                // 같으면 오름차순
                return a.compareTo(b);
            }
        });

        for (int i = 0; i < list.size() - 1; i++) {
            answer.append(list.get(i) + " ");
        }
        answer.append(list.get(list.size() - 1));

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.print(solution("221123"));
        System.out.println("ㅂ");
    }
}

package Programmers;

import java.util.HashSet;

public class 중복제거후경우의수 {

    static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    static int solution(String[] names) {
        int answer = 0;

        HashSet<String> set = new HashSet<>();
        for (String s : names) {
            set.add(s);
        }

        if (set.size() >= 4) {
            answer = (int) (factorial(set.size()) / (factorial(4) * factorial(set.size() - 4)));
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] names = {"z","b","j","s","j","b","b","bb","h"};
        System.out.println(solution(names));
    }
}

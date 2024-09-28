package Programmers;

public class 양의양수구하기 {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}

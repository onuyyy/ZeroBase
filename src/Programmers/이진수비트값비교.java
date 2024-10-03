package Programmers;

public class 이진수비트값비교 {
    static int solution(int A, int B) {
        int answer = 0;

        // 이진수 비트 값을 비교하여 정수로 결과 반환하는 연산
        int xor = A ^ B;

        while (xor > 0) {
            // 두 비트가 모두 1일 때만 1을 반환하고 그 외 0 반환
            answer += xor & 1;
            // 비트를 1비트 옆으로 옮기기
            xor >>= 1;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(29, 15));
    }
}

package Programmers;

import java.util.Arrays;

public class 홀수일때배열에서밀어내기 {
    public static int solution2(int num) {
        // 음수인지 확인
        boolean isNegative = num < 0;

        // 음수일 경우, 양수로 변환
        if (isNegative) {
            num = -num;
        }

        // 숫자를 문자열로 변환 후 거꾸로 뒤집기
        String reversedNumber = new StringBuilder(Integer.toString(num)).reverse().toString();

        // 앞의 0 제거
        reversedNumber = reversedNumber.replaceAll("^0+", "");

        // 결과를 정수형으로 변환
        int result = Integer.parseInt(reversedNumber);

        // 음수일 경우 결과에 음수 부호 추가
        return isNegative ? -result : result;
    }

    public static int[] solution(int[] arr) {
        int n = arr.length; // 배열의 길이

        // 배열을 순회하며 홀수를 만나면 밀어내기
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) { // 홀수일 때
                // 요소를 한 칸씩 밀어내기
                for (int j = n - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1]; // 요소를 오른쪽으로 이동
                }
                arr[i + 1] = arr[i]; // 현재 홀수를 다음 위치에 추가
                i++; // 인덱스 증가 (추가된 홀수 건너뛰기)
            }
        }

        return arr; // 수정된 배열 반환
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 4, 3, 0}; // 입력 배열
       // System.out.println(Arrays.toString(solution(arr))); // 결과를 출력

        System.out.println(solution2(-315));
        System.out.println(solution2(430));
    }
}

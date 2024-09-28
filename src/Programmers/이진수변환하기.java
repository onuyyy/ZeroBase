package Programmers;

public class 이진수변환하기 {
    public static int solution3(String[] arr) {
        int answer = 0;

        for (String s : arr) {
            // (int) 캐스팅은 기본적으로 숫자 타입을 정수로 변환할 때 사용한다
            answer ^= Integer.parseInt(s, 2);
        }

        return answer;
    }
    public String solution2(String[] arr) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append(arr[arr.length - 1]);

        return sb.toString();
    }
    public static String solution(String s) {
        String answer = "";

        // int n = Integer.parseInt(s, 16);
        // answer = Integer.toBinaryString(n);

        return Integer.toBinaryString(Integer.parseInt(s,16));
    }
    public static void main(String[] args) {
        System.out.println(solution("f4"));

        String[] arr = {"10110", "1010", "11110"};
        System.out.println(solution3(arr));
    }
}

package Programmers;

public class 아스키코드값치환 {
    public static String solution(int[] arr) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append((char)i);
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        int[] arr = {71, 111, 111, 103, 108, 101};
        System.out.println(solution(arr));
    }
}

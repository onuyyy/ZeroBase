package Programmers;

public class 대소문자바꾸기 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // A 65 / a 97
        for (char c : s.toCharArray()) {
            if (c >= 65 && c < 97) {
                sb.append((char)(c + 32));
            } else {
                sb.append((char)(c - 32));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution("Naver"));
    }
}

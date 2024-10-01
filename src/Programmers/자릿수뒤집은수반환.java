package Programmers;

public class 자릿수뒤집은수반환 {
    public static int solution(int num) {
        int answer = 0;

        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        
        for (String str : s.split(s)) {
            sb.append(str);    
        }


        
        return answer;
    }

    public static void main(String[] args) {

    }
}

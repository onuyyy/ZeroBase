package Assignment;

import java.util.Random;
import java.util.Scanner;

public class mini4 {
    /*
        주민등록번호 생성 프로그램
        Scanner, Rendom 클래스 이용
        - 입력 값은 생년, 월, 일 성별과 임의의 번호 통하여 생성
        - 임의의 번호는 random의 nextInt 함수 통해 생성 (1 ~ 999999)
        - 입력 값은 2020년도 이후로 입력한다는 전제

        김윤영
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생 년도를 입력해 주세요. (yyyy) : ");
        String year = sc.nextLine();
        System.out.print("출생 월을 입력해 주세요. (mm) : ");
        int month = sc.nextInt();
        sc.nextLine();
        System.out.print("출생 일을 입력해 주세요. (dd) : ");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("성별을 입력해 주세요. (m/f) : ");
        String sex = sc.nextLine();

        String yearNum = year.substring(2);
        int sexNum = 0;
        if (sex.equals("m")) {
            sexNum = 3;
        } else {
            sexNum = 4;
        }
        Random random = new Random();
        int num = random.nextInt(100000);

        System.out.println(String.format("%s%02d%02d-%d%d",yearNum,month,day,sexNum,num));
        sc.close();
    }
}

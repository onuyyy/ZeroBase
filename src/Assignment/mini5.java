package Assignment;

import java.time.LocalDate;
import java.util.Scanner;

public class mini5 {
    /*
        달력 출력 프로그램
        입력 받은 년도와 월을 통한 달력 생성
        LocalDate 클래스 이용 (Calendar, Date 클래스도 이용 가능)
        입력한 달을 기준으로 이전, 입력, 이후 달 출력
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요. (yyyy) : ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("달력의 월을 입력해 주세요. (mm) : ");
        int month = sc.nextInt();
        sc.nextLine();

        LocalDate lc = LocalDate.of(year, month, 1);
        int day = lc.getDayOfWeek().getValue();
        int lastDay = lc.lengthOfMonth();

        System.out.println("[" + year + "년 " + String.format("%02d월]", month));
        System.out.println("일   월   화   수   목   금   토");

        sc.close();
    }
}

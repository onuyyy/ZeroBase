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

        for (int i = 0; i < 3; i++) {
            LocalDate lc = LocalDate.of(year, month - 1 + i, 1);
            // 요일을 1(월요일)~7(일요일)로 받음
            int day = lc.getDayOfWeek().getValue();
            // 일요일을 0으로 조정, 월요일은 1, 화요일은 2 ...
            day = (day == 7) ? 0 : day;
            int lastDay = lc.lengthOfMonth();

            System.out.println("[" + year + "년 " + String.format("%02d월]", month - 1 + i));
            System.out.print("일\t월\t화\t수\t목\t금\t토\n");

            for (int j = 0; j < day; j++) {
                System.out.print("\t");
            }

            for (int j = 1; j < lastDay; j++) {
                System.out.printf("%02d\t", j);

                if ((j + day) % 7 == 0 || j == lastDay) {
                    System.out.println();
                }
            }
            System.out.println();
        }



        sc.close();
    }
}

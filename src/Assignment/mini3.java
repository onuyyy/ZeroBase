package Assignment;

import java.util.Scanner;

public class mini3 {
    /*
        놀이동산 입장권 계산 프로그램
        - 나이, 입장시간, 국가유공자 여부, 복지카드 여부 순으로 입력
        - 할인 : 중복할인이 되지 않으며, 중복인 경우 할인 많이 받은 금액
            3세 미만 무료 입장
            복지카드, 국가유공자 : 일반 할인
            13세 미만, 17시 이후 입장 : 특별 할인
        입장료
            기본 : 10,000원
            특별 할인 : 4,000원
            일반 할인 : 8,000원
     */
    public static void main(String[] args) {

        int result = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요. (숫자) : ");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요. (숫자 입력) : ");
        int time = sc.nextInt();
        sc.nextLine();
        System.out.print("국가유공자 여부를 입력해 주세요. (y/n) : ");
        String national = sc.nextLine();
        System.out.print("복지카드 여부를 입력해 주세요. (y/n) : ");
        String welfare = sc.nextLine();

        while (true) {
            if (age < 3) {
                result = 0;
                break;
            } else if (age < 13 || time > 17) {
                result = 4000;
                break;
            } else if (welfare.equals("y") || national.equals("y")) {
                result = 8000;
                break;
            } else {
                result = 10000;
                break;
            }
        }

        System.out.println("입장료 : " + result);
        sc.close();
    }
}

package Assignment;

import java.util.Scanner;

public class mini2 {
    /*
        결제 금액 캐시백 계산 프로그램
        Scanner 함수 사용
        - 결제 금액의 10% 적립
        - 캐시백 포인트 단위는 백 원 단위
        - 한 건의 캐시백 포인트는 최대 300원을 넘을 수 없다.
        김윤영
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액) : ");
        int input = Integer.parseInt(sc.nextLine());

        double cashBack = Math.floor(input * 0.1 / 100) * 100;
        if (cashBack > 300) {
            cashBack = 300;
        }

        System.out.print(String.format("결제 금액은 %d원이고, 캐시백은 %.0f원 입니다.", input, cashBack));
        sc.close();
    }
}

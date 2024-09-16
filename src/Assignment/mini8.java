package Assignment;

import java.util.Arrays;
import java.util.Scanner;

// 김윤영
import java.util.Scanner;

// 김윤영

public class mini8 {
    public static void solution(int money) {
        double[] taxRates = {0.06, 0.15, 0.24, 0.35, 0.38, 0.4, 0.42, 0.45};
        int[] income = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        int[] taxRates2 = {0,1080000,5220000,14900000,19400000,25400000,35400000,65400000};
        int tax = 0;
        int tax2 = 0;

        // 계산할 때 이전 세율 구간의 최대치를 기억하는 변수
        int prevTax = 0;

        for (int i = 0; i < taxRates.length; i++) {
            if (money > prevTax) {
                // 현재 구간에서 계산해야 할 금액
                int taxableIncome = Math.min(money - prevTax,
                        (i < income.length ? income[i] : money) - prevTax);

                int tempTax = (int)(taxableIncome * taxRates[i]);
                tax += tempTax;

                tax2 = (int)(money * taxRates[i]) - taxRates2[i];

                System.out.println(String.format("%d * %s = %d", taxableIncome, taxRates[i], tempTax));

                // 다음 구간 계산을 위해 이전 구간의 최대치 업데이트
                prevTax = income[i];
            } else {
                break;
            }
        }

        System.out.println("[세율에 의한 세금]: " + tax);
        System.out.println("[누진공제 계산에 의한 세금]: " + tax2);
    }
    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");

        Scanner sc = new Scanner(System.in);
        System.out.print("연소득을 입력해 주세요. : ");
        int money = sc.nextInt();

        solution(money);
    }
}
package Part02.Chapter02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BasicMath2 {
    /*
        약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
        - 1 ~ 10의 수 중 A의 약수 또는 B의 약수인 경우의 수
        - 1 ~ 10의 수 중 A의 약수이면서 B의 약수인 경우의 수
     */

    public ArrayList getDivisor(int num) {
        // 약수 : 나눠서 나머지가 발생하지 않는 수
        // 4의 약수 ? 1, 2, 4 / 6의 약수 ? 1, 2, 3, 6
        ArrayList result = new ArrayList();

        for (int i = 1; i <= (int)num/2; i++) {
            // num이 6이라면, 3까지는 나눠떨어질 거고, 4부터는 나눠떨어지지 않을 테니까
            if (num % i == 0) {
                result.add(i);
            }
        }
        // 자기 자신까지 넣으면 된다
        result.add(num);

        return result;
    }

    public int getGCD(int numA, int numB) {
        // 최대 공약수 (GCD : the Greatest Common Denominator)
        // 최대 공약수? 약수들 중에서 공통 약수이면서 가장 큰 수 = 4,6 최대공약수 : 2
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for (int iA : (ArrayList<Integer>) divisorA) {
            for (int iB : (ArrayList<Integer>) divisorB) {
                if (iA == iB) {
                    if (iA > gcd) {
                        gcd = iA;
                    }
                }
            }
        }

        return gcd;
    }

    public int getLCM(int numA, int numB) {
        // 최소 공배수 (LCM : this Lowest Common Multiple)
        // 배수들 중에서 공통된 배수 중에 가장 작은 값
        // 4, 6 최소 공배수 : 12
        // 최소 공배수 = a * b / a,b의 최대공약수 (6 * 4 / 2 = 12)
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);

        if (gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }
    public static void main(String[] args) {
        System.out.println("합의 법칙");
        // 두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;

        // 기본 풀이
        for (int i1 : dice1) {
            for (int i2 : dice2) {
                if ((i1 + i2) % 3 == 0) {
                    nA += 1;
                }

                if ((i1 + i2) % 4 == 0) {
                    nB += 1;
                }

                if ((i1 + i2) % 12 == 0) {
                    // 공통된 케이스
                    nAandB += 1;
                }
            }
        }
        System.out.println("결과 : " + (nA + nB - nAandB));

        // HashSet 이용
        HashSet<ArrayList> allCase = new HashSet<>();
        for (int i1 : dice1) {
            for (int i2 : dice2) {
                if ((i1 + i2) % 3 == 0 || (i1 + i2) % 4 == 0) {
                    ArrayList list = new ArrayList(Arrays.asList(i1, i2));
                    allCase.add(list);
                }
            }
        }

        System.out.println("결과 : " + allCase.size());
        System.out.println(allCase);

        System.out.println("곱의 법칙");
        // a, b 주사위에서 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;

        for (int i1 : dice1) {
            if (i1 % 3 == 0) {
                nA++;
            }
        }

        for (int i1 : dice2) {
            if (i1 % 4 == 0) {
                nB++;
            }
        }

        System.out.println("결과 : " + nA * nB);
        System.out.println();

        System.out.println("Practice");
        BasicMath2 bm = new BasicMath2();
        int n1 = 10;
        int n2 = 6;
        ArrayList l1 = bm.getDivisor(n1);
        ArrayList l2 = bm.getDivisor(n2);

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수 : " + bm.getGCD(n1, n2));
        System.out.println("최대 공배수 : " + bm.getLCM(n1, n2));
    }
}

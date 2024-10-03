package Part02.Chapter02;

public class BasicMath5 {
    static int gcd(int a, int b) {
        // 최대공약수 : 공통 약수의 맥시멈 값
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    static int recursion1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 3 * recursion1(n - 1);
        }
    }

    static int recursion2(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + recursion1(n - 1);
        }
    }

    static int recursion3(int n) {
        if (n < 3) {
            return 1;
        } else {
            return recursion3(n - 2) + recursion3(n - 1);
        }
    }
    public static void main(String[] args) {

        System.out.println("점화식 / 재귀함수 연습 1");

        // 1, 3, 9, 27, ... 의 n번째 수
        int n = 4;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = 1;
            } else  {
                result *= 3;
            }
        }
        System.out.println("result = " + result);
        System.out.println();

        System.out.println("점화식 / 재귀함수 연습 2");
        // 1, 2, 3, 4, 5, 6, ... 의 n번째 까지의 합
        n = 5;
        result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += i;
        }
        System.out.println("result = " + result);
        System.out.println();

        System.out.println("점화식 / 재귀함수 연습 3");
        // 1, 1, 2, 3, 5, 8, 13, ... 의 n번 째 수 (피보나치 수열)
        n = 6;
        result = 0;
        int a1 = 1;
        int a2 = 1;

        if (n < 3) {
            result = 1;
        } else {
            for (int i = 2; i < n; i++) {
                result = a1 + a2;
                a1 = a2;
                a2 = result;
            }
        }
        System.out.println(result);
        System.out.println();

        System.out.println("Practice Factorial");
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println();

        System.out.println("Practice");
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
        /*
            최대공약수 재귀함수로 풀어보기
            8 % 12 = 8
                12 % 8 = 4
                     8 % 4 = 0
                        --- => 답은 4
         */
        System.out.println();
    }
}

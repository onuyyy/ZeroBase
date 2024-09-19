package CodingTest;

import java.util.Scanner;

public class BJ_26008_HashMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int a= sc.nextInt();
        int h= sc.nextInt();

        long result = 1;
        for (int i = 0; i < n -1; i++) {
            result = (result * m) % 1000000007;
        }

        System.out.println(result % 1000000007);

    }
}

package Assignment;

import java.util.Arrays;
import java.util.Scanner;

// 김윤영

public class mini7 {
    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int count = sc.nextInt();
        sc.nextLine();

        String[] input = new String[count];
        int[][] inputLotto = new int[count][6];
        int alph = (int)'A';

        for (int i = 0; i < count; i++) {
            System.out.print((char) alph + " ");
            String[] num = sc.nextLine().split(",");
            for (int j = 0; j < 6; j++) {
                inputLotto[i][j] = Integer.parseInt(num[j].trim());
            }
            // 로또 번호 정렬
            Arrays.sort(inputLotto[i]);
            alph++;
        }

        System.out.println("[로또 발표]");
        int[] realLotto = new int[6];
        boolean[] exist = new boolean[46];

        int numGenerated = 0;
        while (numGenerated < 6) {
            int randomNum = (int)(Math.random()*45) + 1;
            if(!exist[randomNum]) {
                realLotto[numGenerated] = randomNum;
                exist[randomNum] = true;
                numGenerated++;
            }

        }
        Arrays.sort(realLotto);
        System.out.println(Arrays.toString(realLotto));

        System.out.println("[내 로또 결과]");
        alph = (int)'A';
        for (int i = 0; i < count; i++) {
            int same = countMatch(inputLotto[i],realLotto);
            System.out.print((char) alph + " ");
            System.out.println(Arrays.toString(inputLotto[i]) + String.format(" => %d개 일치",same));
            alph++;
        }
    }

    private static int countMatch(int[] inputLotto, int[] realLotto) {
        int count = 0;
        for (int i = 0; i < inputLotto.length; i++) {
            if (Arrays.binarySearch(realLotto, inputLotto[i]) >= 0) {
                count++;
            }
        }
        return count;
    }

}
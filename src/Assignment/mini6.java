package Assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mini6 {
    public static void main(String[] args) {
        /*
            가상 선거 및 당선 시뮬레이션

            김윤영
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int total = sc.nextInt();
        sc.nextLine();
        System.out.print("가상 성거를 진행할 후보자 인원을 입력해 주세요.");
        int candidateCnt = sc.nextInt();
        sc.nextLine();

        String[] names = new String[candidateCnt];
        double[] namesPercent = new double[candidateCnt];
        int[] namesVote = new int[candidateCnt];

        for (int i = 0; i < candidateCnt; i++) {
            System.out.println(i + 1 + "번째 후보자 이름을 입력해 주세요.");
            names[i] = sc.nextLine();
        }

        Random r = new Random();
        for (int i = 1; i <= total; i++) {
            int vote = r.nextInt(candidateCnt) + 1;

            namesVote[vote - 1] += 1;

            double percent = (i / (double) total) * 100;
            System.out.println("[투표진행률] : " + percent + "%, " + i + "명 투표 => " + names[vote - 1]);

            for (int j = 0; j < candidateCnt; j++) {
                namesPercent[j] = (namesVote[j]/ (double) total) * 100;
                System.out.println(String.format("[기호:%d] %s: %.1f%%  (투표수: %d)", j + 1, names[j], namesPercent[j] ,namesVote[j]));

            }
        }

        int winnerIndex = 0;
        int maxVotes = namesVote[0];
        for (int i = 1; i < candidateCnt; i++) {
            if (namesVote[i] > maxVotes) {
                maxVotes = namesVote[i];
                winnerIndex = i;
            }
        }

        System.out.println("[투표결과] 당선인 : " + names[winnerIndex]);
        sc.close();
    }
}

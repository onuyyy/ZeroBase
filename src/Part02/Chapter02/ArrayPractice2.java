package Part02.Chapter02;

import java.awt.desktop.OpenURIEvent;
import java.util.Arrays;

public class ArrayPractice2 {
    public static void solution6(int[] arr) {
        /*
            중복 제거한 배열 만들기 (set 금지)
         */
        int[] result = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false;
            for (int j = 0; j < cnt; j++) {
                if (arr[i] == result[j]) {
                    dupFlag = true;
                }
            }

            if (dupFlag == false) {
                result[cnt++] = arr[i];
            }
        }
    }
    public static void solution5(int[] arr) {
        /* 
            배열 오름차순 정렬
         */
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while (visitCnt < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < minVal && visited[i] == 0) {
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            if (minIdx != -1) {
                System.out.print(minVal + " ");
                visited[minIdx] = 1;
                visitCnt++;
            }

            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
        System.out.println();
    }
    public static void solution4(int[] arr) {
        /*
            peek 값 (좌우보다 큰 값 출력)
         */

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + " ");
            } else if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
                System.out.print(arr[i] + " ");
            } else {
                if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println();
    }
    public static void solution3(int[] arr) {
        /*
            arr 순서 거꾸로 변경
         */
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
    public static int solution2(int[] arr, int target) {
        /*
            target에 해당하는 값의 인덱스 출력
            값이 여러 개인 경우 가장 큰 인덱스
         */

        int max = -1;
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                if (max < i) {
                    max = i;
                }
            }
        }

        return (target == -1) ? -1 : max;
    }
    public static void solution1(int[] arr) {
        /*
            짝수와 홀수의 평균을 출력
         */

        float sumEven = 0;
        float sumOdd = 0;
        int evenCnt = 0;
        int oddCnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sumEven += arr[i];
                evenCnt++;
            } else {
                sumOdd += arr[i];
                oddCnt++;
            }
        }

        System.out.println("홀수 평균 : " + sumOdd/oddCnt + " 짝수 평균 : " + sumEven/evenCnt);
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        int[] arr = {1,2,3,4,6,7,8,9};
        solution1(arr);

        System.out.println("Solution 2");
        System.out.println(solution2(arr, 3));
        System.out.println(solution2(arr, 0));

        System.out.println("Solution 3");
        solution3(arr);

        System.out.println("Solution 4");
        arr = new int[]{3,1,2,6,2,2,5,1,9,10,1,11};
        solution4(arr);

        System.out.println("Solution 5");
        solution5(arr);
    }
}

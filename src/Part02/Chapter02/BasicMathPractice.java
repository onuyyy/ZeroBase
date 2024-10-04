package Part02.Chapter02;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicMathPractice {
    public static boolean solution3(String s1, String s2) {
    /*
        s1, s2 문자열 중 s1을 permutation 한 문자열이,
        s2의 부분 문자열에 해당하면 true
     */
        final int ALPHABET = 26;

        if (s1. length() > s2.length()) {
            return false;
        }

        int[] cnt = new int[ALPHABET];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++; // 아스키 코드 값 빼주면 0부터 시작함
        }

        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i) - 'a']--;

            if (i - s1.length() >= 0) {
                cnt[s2.charAt(i - s1.length()) - 'a']++;
            }

            boolean isZero = true;
            for (int j = 0; j < ALPHABET; j++) {
                if (cnt[j] != 0) {
                    isZero = false;
                    break;
                }
            }
            if (isZero) {
                return true;
            }
        }

        return false;
    }

    public static void soltuion2(int[] arr) {
    /*
        양의 정수로 이루어진 배열 데이터에서 만들 수 있는 permutation 중에 (순서 O, 중복 X)
        다음과 같은 데이터를 출력하는 프로그램
        - 현재 데이터보다 이전의 큰 수를 출력 (312라면 321로 못 바꿈 312가 더 크니까)
        - 한 번의 swap으로 출력 가능한 큰 수를 출력

        입력 : 1, 9, 4, 7, 6 / 출력 : 1, 9, 4, 6, 7
     */
        if (arr == null || arr.length < 2) {
            return;
        }

        int idx = -1;
        // 우측부터 순회 > 우측보다 더 큰 값이 좌측에 나오는지 찾기
        for (int i = arr.length - 1; i >= 1 ; i--) {
            if (arr[i] < arr[i - 1]) {
                // 바꿔줄 대상 고르기
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            // 오른쪽보다 더 큰 수를 못 찾은 상황
            System.out.println(Arrays.toString(arr));
            return;
        }

        // 바꿔줄 애 기준 오른쪽 어떤 애랑 교체할지 찾기
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
    /*
        파스칼의 삼각형
        첫째 줄에는 숫자 1
        그 다음 줄은 바로 위의 왼쪽 숫자와 오른쪽 숫자를 더한다
        삼각형의 행의 수가 입력으로 주어졌을 때 삼각형을 출력하기
     */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    // 가장 외곽 쪽
                    list.add(1);
                } else {
                    // 좌측 값
                    int x = result.get(i - 1).get(j - 1);
                    // 우측 값
                    int y = result.get(i - 1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));

        System.out.println("Solution 2");
        int[] arr = {3, 2, 1};
        soltuion2(arr);
        arr = new int[]{1, 9, 4, 7, 6};
        soltuion2(arr);
        arr = new int[]{1, 1, 2, 3};
        soltuion2(arr);

        System.out.println("Solution 3");
        String s1 = "ab";
        String s2 = "adbak";
        System.out.println(solution3(s1, s2));
        s1 = "ac";
        s2 = "car";
        System.out.println(solution3(s1, s2));
        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution3(s1, s2));




    }
}

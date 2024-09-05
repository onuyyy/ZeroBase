package Part02.Chapter04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoPointersPractice2 {
    public static String solution3(String s) {

        /*
            문자열 s를 거꾸로 출력하는 프로그램 작성
            단, 각 단어와 알파벳 순서는 그대로 출력
            공백이 여러 개일 시 단어와 단어 사이 하나의 공백만 남기기

            입력 : the sky is blue
            출력 : blue is sky the

            입력 :     hello   java
            출력 : java hello
         */

        if (s == null) {
            return null;
        }

        if (s.length() < 2) {
            return s;
        }

        s = removeSpaces(s);

        char[] cArr = s.toCharArray();
        reverseString(cArr, 0, s.length() - 1);
        reverseWords(cArr, s.length());

        return new String(cArr);
    }

    public static void reverseWords(char[] cArr, int length) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < length) {
            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
                p1++;
            }

            while (p2 < p1 || p2 < length && cArr[p2] != ' ') {
                p2++;
            }

            reverseString(cArr, p1, p2 - 1);
        }
    }

    public static void reverseString(char[] cArr, int i, int j) {
        while (i < j) {
            char tmp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = tmp;
        }
    }

    public static String removeSpaces(String s) {
        int p1 = 0;
        int p2 = 0;

        char[] cArr = s.toCharArray();
        int length = s.length();

        while (p2 < length) {
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            while (p2 < length && cArr[p2] != ' ') {
                cArr[p1++] = cArr[p2++];
            }

            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            if (p2 < length) {
                cArr[p1++] = ' ';
            }
        }

        return new String(cArr).substring(0, p1);
    }
    public static int[] solution2(int[] nums1, int[] nums2) {
        /*
            두 배열의 공통 원소를 배열로 반환
            결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다

            nums1 : 1, 2, 2, 1
            nums2 : 2, 2
            출력 : 2

            nums1 : 4, 9, 3
            nums2 : 9, 4, 9, 8, 4
            출력 : 4, 9 (or 9, 4)
         */

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                // p1, p2 어떤 인덱스 사용하든 상관 없음
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
            result[idx++] = i;
        }
        return result;
    }
    public static String solution(String s) {
        /*
            a, b, c, d 로 이루어진 알파벳 문자열에서
            다음과 같은 규칙으로 문자열을 반환
            1. 양쪽의 문자를 비교한 후 같으면 삭제
            2. 연속해서 같은 문자가 등장하면 함께 삭제

            입력 : "ab"
            출력 : ab

            입력 : "aaabbaa"
            출력 : (없음)
         */

        if (s == null || s.length() == 0) {
            return null;
        }

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2 && s.charAt(p1) == s.charAt(p2)) {
            char c = s.charAt(p2);

            while (p1 <= p2 && s.charAt(p1) == c) {
                p1++;
            }

            while (p1 <= p2 && s.charAt(p2) == c) {
                p2--;
            }
        }

        return s.substring(p1, p2 + 1);
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        System.out.println(solution("ab"));
        System.out.println(solution("aaabbaa"));
        System.out.println(solution("aabcddba"));
        System.out.println();

        System.out.println("Solution 2");
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution2(nums1, nums2)));

        nums1 = new int[]{4, 9, 3};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution2(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution2(nums1, nums2)));

        System.out.println();
        System.out.println("Solution 3");
        System.out.println(solution3("the sky is blue"));
        System.out.println(solution3("    hello   java    "));
    }
}


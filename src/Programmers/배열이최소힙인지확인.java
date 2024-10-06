package Programmers;

public class 배열이최소힙인지확인 {
    static String solution(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * 2 + 2;

            if (leftIdx < arr.length) {
                if (arr[i] > arr[leftIdx]) {
                    return "NO";
                }
            }

            if (rightIdx < arr.length) {
                if (arr[i] > arr[rightIdx]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        int[] arr = {0,20,22,17};
        System.out.println(solution(arr));
    }
}

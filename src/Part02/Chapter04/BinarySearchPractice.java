package Part02.Chapter04;

import java.util.Arrays;

public class BinarySearchPractice {
    public static int binarySearch(int[] arr, int target) {
        // 반복문으로 이진 탐색 트리 구현
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] arr, int target, int left, int right) {
        // 재귀 호출로 이진 탐색 트리 구현
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch2(arr, target, left, mid - 1);
        } else {
            return binarySearch2(arr, target, mid + 1, right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index : " + binarySearch(arr, 30));
        System.out.println();

        System.out.println("Index : " + binarySearch2(arr, 30, 0, arr.length - 1));

        System.out.println("JAVA 기본 BinarySearch");
        System.out.println("Data가 있는 경우");
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 30));

        System.out.println("Data가 없는 경우");
        // 데이터는 없지만 있어야 할 인덱스에 -1
        System.out.println(Arrays.binarySearch(arr, 3)); // -3
        System.out.println(Arrays.binarySearch(arr, 11)); // -5
        System.out.println(Arrays.binarySearch(arr, 35)); // -7
    }
}

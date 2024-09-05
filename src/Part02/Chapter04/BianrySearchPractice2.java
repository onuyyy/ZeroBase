package Part02.Chapter04;

public class BianrySearchPractice2 {

    public static boolean solution3(int[][] matrix, int target) {
        /*
            2차원 행렬에서 이진 탐색
            각 행의 데이가 오름차순으로 정렬 상태인 2차원 행렬에서 데이터 찾기

            {{1, 3, 7, 8},{10, 11, 15, 20},{21, 30, 35, 60}}

            target : 3 / 출력 : true
            target : 13 / 출력 : false
         */

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / cols][mid % cols] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
    public static int solution2(int[] arr, int target) {
        /*
            원형 정렬 상태 배열에서 이진 탐색
            nums 배열에 원형 상태로 데이터가 정렬되어 있을 때
            배열을 재 정렬하지 않고 이진 탐색으로 데이터 찾기

            arr : 4, 5, 6, 7, 8, 0, 1, 2

            target : 0 / 출력 : 5
            target : 3 / 출력 : -1
         */

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            // 4, 5, 6, 7, 0, 1, 2
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 11, 5, 6, 7, 8, 9, 10
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
    public static int solution(int[] arr, int target) {
        /*
            target 값이 arr 내에 있으면 해당 인덱스 반환
            없으면해당 값이 있을 경우의 위치에 -1 곱하고 1을 뺀 값 반환

            입력 : 1, 2, 5, 10, 20, 30, 40, 50, 60
            target : 30 / 출력 : 5
            target : 3 / 출력 -3
         */
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // mid가 자료형의 범위를 넘어설 경우 > overflow
            // int 대신에 long을 쓴다
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 실패 했을 떄 return 때의 left 값
        return -left - 1;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println("Solution");
        System.out.println(solution(arr, 30));
        System.out.println(solution(arr, 3));
        System.out.println(solution(arr, 11));
        System.out.println(solution(arr, 35));

        System.out.println();
        System.out.println("Solution 2");
        arr = new int[]{4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution2(arr, 0)); // 5
        System.out.println(solution2(arr, 3)); // -1

        System.out.println();
        System.out.println("Solution 3");
        int[][] matrix = {{1, 3, 7, 8},{10, 11, 15, 20},{21, 30, 35, 60}};
        System.out.println(solution3(matrix, 3)); // true
        System.out.println(solution3(matrix, 13)); // false
        System.out.println(solution3(matrix, 35)); // true

    }
}

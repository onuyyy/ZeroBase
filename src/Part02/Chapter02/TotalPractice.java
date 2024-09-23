package Part02.Chapter02;

import java.util.Arrays;

public class TotalPractice {

    // m * n 행렬 데이터에서
    // 행렬의 원소 중에 0이 있을 경우 위치하는 행과 열 데이터를 0으로 변경해라
    public static void solution2(int[][] matrix) {
        boolean frZero = false;
        boolean fcZero = false;

        // 최외곽 테두리가 0인지 찾기
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        frZero = true;
                    }

                    if (j == 0) {
                        fcZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (frZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (fcZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] solution(int[] arr) {
        // modification으로 정렬한 배열 돌려놓기
        // 1 3 7 9 5 > 1 3 5 7 9(modification)
        int[] result = new int[arr.length];

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (result[idx] == 0) {
                    // 새로 만들 배열에 데이터가 없으니까 넣을 곳을 찾았다
                    // 탈출문임
                    break;
                }
                idx = (idx + 1) % arr.length;
            }
            // break로 탈출한 상태에서 찾은 인덱스 위치에다 값 넣어주기
            result[idx] = arr[i];
            idx = (idx + arr[i]) % arr.length;
        }

        return result;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length;
            val = arr[idx];
        }
        return arrNew;
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        int[] arr = {1, 3, 7, 9, 5};
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew));

        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
        System.out.println();

        System.out.println("Solution 2");
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution2(matrix);
        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution2(matrix);
    }
}

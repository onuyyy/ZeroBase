package Part02.Chapter02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicMath3 {
    public static void permutation2(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];

                permutation2(arr, depth + 1, n, r, visited, out);

                visited[i] = false;
            }
        }
    }
    public static void permutation(int[] arr, int depth, int n, int r) {
        // 1,2,3,4를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 X)
        // depth는 각 자리수, n은 숫자의 개수, r은 몇자리
        // 4 * 3 * 2 = 24

        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int idx) {
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }
    public static void main(String[] args) {
        System.out.println("팩토리얼");
        // 5!
        int n = 5;
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("result = " + result);
        // 2,3,4,5 2에서 6까지
        System.out.println(IntStream.range(2, 6).reduce(1, (x, y) -> (x * y)));

        System.out.println("순열");
        // 5명을 3줄로 세우는 경우의 수
        n = 5;
        int r = 3;
        result = 1;
        // 5 * 4 * 3
        for (int i = n; i >= n - r + 1; i--) {
            result *= i;
        }
        System.out.println("result = " + result);

        System.out.println("중복 순열");
        // 서로 다른 4개의 수 중 2개를 뽑는 경우의 수 (중복 허용)
        n = 4;
        r = 2;
        result = 1;

        for (int i = 0; i < r; i++) {
            result *= n;
        }
        System.out.println("result = " + result);
        System.out.println(Math.pow(n, r)); // n의 r승

        System.out.println("원 순열");
        // 원 모야으이 테이블에 3명을 앉히는 경우의 수
        n = 3;
        result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        System.out.println("result = " + result);
        System.out.println();

        System.out.println("Practice 1");
        int[] arr = {1, 2, 3, 4};
        permutation(arr, 0, 4, 3);
        System.out.println();

        System.out.println("Practice 2");
        n = 4;
        r = 3;
        arr = new int[]{1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];
        permutation2(arr, 0, n, r, visited, out);
    }
}

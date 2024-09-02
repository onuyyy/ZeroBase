package Part02.Chapter03;
class BinaryTree3 {
    int h;
    int[] arr;
    int res;

    public BinaryTree3(int h, int[] w) {
        this.h = h;
        // 노드는 7개지만 8개로 만들고 하나 덜 쓰면 되니까
        arr = new int[(int)Math.pow(2, h + 1)];
        res = 0;

        // 간선의 개수 : 노드의 개수 - 1
        // 배열 한 칸 안 쓰고, 간선의 개수는 노드의 개수 -1 이니까 2부터 시작
        for (int i = 2; i < (int)Math.pow(2, h + 1); i++) {
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h) {
        if (this.h == h) {
            res += arr[idx];
            return arr[idx];
        }
        int left = dfs(idx * 2, h + 1);
        int right = dfs(idx * 2 + 1,h + 1);

        res += arr[idx] + Math.abs(left - right);

        return arr[idx] + Math.max(left, right);
    }
}

public class TreePractice2 {
    public static void solution2(int h, int[] w) {
        /*
            각각의 예제에 가중치가 있는 포화 이진 트리가 있다
            루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고
            모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성
         */
        BinaryTree3 bt = new BinaryTree3(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }
    public static void solution(int n) {
        /*
            종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1
            종이를 접을 때는 오른쪽에서 왼쪽으로 접는다
            종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성

            입력 : 1 / 출력 : 0
            입력 : 2 / 출력 : 0, 0, 1
            입력 : 3 / 출력 : 0, 0, 1, 0, 0, 1, 1
         */

        int[] binaryTree = new int[(int)Math.pow(2, n)];

        binaryTree[0] = 0;
        for (int i = 0; i < (int)Math.pow(2, n - 1) - 1; i++) {
            binaryTree[i * 2 + 1] = 0;
            binaryTree[i * 2 + 2] = 1;
        }

        inOrder(binaryTree, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < arr.length - 1) {
            inOrder(arr, left);
        }
        System.out.print(arr[idx] + " ");

        if (right < arr.length - 1) {
            inOrder(arr, right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Solution 1");
        solution(1);
        solution(2);
        solution(3);

        System.out.println("Solution 2");
        int h = 2;  // 트리의 높이
        int[] w = {2,2,2,1,1,3};    // 가중치
        solution2(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1,2,1,3,2,4,1,1,1,1,1,1,1,1};
        solution2(h,w);
    }
}

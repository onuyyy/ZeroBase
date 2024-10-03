package Part02.Chapter02;

public class BasicMath4 {
    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {

        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i] == true) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }

    public static int getCombination(int n, int r) {
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }

        return pResult / rResult;
    }
    public static void main(String[] args) {
        System.out.println("조합");
        // 서로 다른 4명 중 주번 2명 뽑는 경우의 수
        int n = 4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        System.out.println("결과 : " + pResult/rResult);
        System.out.println();

        System.out.println("중복 조합");
        // 후보 2명, 유권자 3명일 때 무기명 투표 경우의 수
        n = 2;
        r = 3;
        System.out.println("결과 : " + getCombination(n + r - 1, r));
        System.out.println();

        System.out.println("Practice");
        int[] arr = {1, 2 ,3 ,4};
        boolean[] visited = {false, false, false, false};

        combination(arr, visited, 0 ,4 , 3);

    }
}

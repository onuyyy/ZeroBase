package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_25556_Stack {
    public static boolean solution(int n, int[] arr) {

        Stack<Integer>[] stacks = new Stack[4];

        for (int j = 0; j < 4; j++) {
            stacks[j] = new Stack<>();
        }

        for (int i = 0; i < arr.length; i++) {
            boolean pushed = false;
            for (int j = 0; j < 4; j++) {
                // stack이 비어있거나 top보다 클 때 push (오름차순이기 때문에)
                if (stacks[j].isEmpty() || stacks[j].peek() < arr[i]) {
                    stacks[j].push(arr[i]);
                    pushed = true;
                    // push하면 더 이상 다른 스택 확인하지 않고 넘어가기
                    break;
                }
            }
            // 어느 스택에도 값을 넣지 못한 경우
            if (!pushed) return false;
        }
        // 모든 값을 푸시할 수 있었다면 true
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));

    }
}

package Part02.Chapter04;

import java.util.ArrayList;
import java.util.Arrays;

public class TotalPractice2 {
    public static void solution2(int n) {
    /*
        무게를 예상했는데 그 무게보다 n만큼 더 나간다는 힌트를 얻었다.
        실제 무게의 제곱에서 예상한 무게의 제곱을 뺀 값이 n이라고 한다.
        정답이 될 수 있는 무게의 경우를 출력

        n = A^2 - E^2
    */
        int p1 = 1; // answer
        int p2 = 1; // 예상

        ArrayList result = new ArrayList();
        while (true) {
            int diff = p1 * p1 - p2 * p2;
            if (p1 - p2 == 1 && diff > n) {
                // 탈출 조건 투포인터가 더이상 비교할 게 없을 때
                break;
            }

            if (diff < n) {
                p1++;
            } else {
                p2++;
            }

            if (diff == n) {
                result.add(p1);
            }
        }

        if (result.size() != 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    public static int solution(int[] rocks, int goal, int n) {
        /*
            0부터 goal 위치 사이에 각 11,2,14,21,17 바위들이 놓여 있다.
            goal의 위치가 25라면 주어진 rock 사이의 간격은 2,9,3,3,4,4가 된다

            n개의 바위를 제거하는 경우 간격의 최소 값 중에 최대 값을 구하는 프로그램
         */
        if (rocks == null || rocks.length == 0) {
            return -1;
        }

        // 이진탐색트리 이용 (이진탐색트리는 정렬되어 있어야 한다)
        Arrays.sort(rocks);

        int left = 0;
        int right = goal;
        int result = Integer.MIN_VALUE;

        while (left <= right) {
            // mid 값을 기준으로 간격이 mid보다 작은 경우 바위를 제거해본다
            int mid = (left + right) / 2;
            int cnt = 0; // 돌을 삭제한 카운트
            int prev = 0; // 제거되지 않은 이전 돌의 위치

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    // 현재 돌과 이전 돌의 차이가 mid보다 작을 때
                    // 그 바위를 제거하고
                    cnt++;
                } else {
                    // 그렇지 않으면 prev를 현재 돌로 바꿔줌
                    prev = rocks[i];
                }

                if (cnt > n) {
                    break;
                }
            }

            if (goal - prev < mid && cnt <= n) {
                // 최종 골 위치는 rocks배열 안에 없기 때문에
                // 최종 골이랑 미드 빼본다
                cnt++;
            }

            if (cnt > n) {
                // 제거된 바위의 개수가 n보다 많을 경우
                // mid 이상의 간격을 유지할 수 있다
                right = mid - 1;
            } else {
                // 제거한 바위 개수가 n 이하일 때
                // 현재 mid 값으로 조건을 만족하고 있으니까 mid + 1 해본다
                left = mid + 1;

                if (cnt == n) {
                    result = Math.max(result, mid);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println("solution 1");
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n= 2;
        System.out.println(solution(rocks, goal, n));
        System.out.println();

        System.out.println("solution 2");
        System.out.println(15);
    }
}

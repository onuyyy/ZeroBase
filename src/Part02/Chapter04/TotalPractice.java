package Part02.Chapter04;

import java.util.ArrayList;
import java.util.Arrays;

public class TotalPractice {

    public static int solution3(int n, int[] items) {
    /*
        n구 짜리 멀티탭 하나와 k개의 전기 제품이 있다
        1 - K 제품의 사용 순서가
        {2, 3, 2, 3, 1, 2, 7} 제품 순으로 사용한다고 했을 떄
        전기 제품 사용을 위해 멀티탭에 교체하는 수가 최소가 되는 값을 구해라
     */

        if (items == null || items.length == 0) {
            return -1;
        }

        // 전기 용품이 현재 연결되어 사용 중인지 체크
        boolean[] used = new boolean[items.length + 1];

        int idx = 0;
        int cnt = 0;

        // 초기 상태 업데이트 : n구가 다 찰 때까지
        while (cnt < n) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            // 몇번 째 인덱스까지 꽂혀있는지 계산
            // 동일한 제품이면 cnt만 늘림
            idx++;
        }

        int result = 0;
        while (idx < items.length) {
            if (!used[items[idx]]) {
                // 현재 제품이 꽂혀있지 않은 경우
                // 꽂혀 있는 n구 중에 하나를 빼야 한다
                ArrayList<Integer> list = new ArrayList<>();
                // 나중에 사용하게 될 전기제품 담아보기
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) {
                        list.add(items[i]);
                    }
                }

                if (list.size() == n) {
                    // n구에 들어있는 애들만큼 리스트에 있으면
                    // 그 중에서 가장 나중에 사용하게 될 애를 먼저 뺀다
                    used[list.get(n - 1)] = false;
                } else {
                    // list에 사이즈가 작은 상황이면
                    // 꽂혀있는 n구가 둘 중에 하나는 안 쓰거나, 둘 다 안 쓰거나 일 때
                    for (int i = 1; i <= items.length; i++) {
                        if (used[i] && !list.contains(i)) {
                            // 나중에 사용 안 할 제품이니까 빼준다
                            used[i] = false;
                            break;
                        }
                    }
                }

                // 현재 사용할 제품의 위치를 true로 바꾼다
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }

        return result;

    }

    public static int solution2(int n, int[] plates, int types, int coupon) {
    /*
        처음 선택한 접시 위치로부터 연속해서 n개의 접시를 골라서
        식사를 하면 할인을 해주는 이벤트
        추가로 쿠폰이 제공되는데 쿠폰에 적혀있는 번호의 초밥을 즉석에서 만들어 준다
        참가하는 손님 입장에서 가장 많은 종류의 초밥을 먹을 수 있는 최대 값
     */
        // 투포인터를 이용 (원형 자료구조를 이용)
        // 쿠폰 번호가 먹은 것 중에 없으면 하나 더 늘려서 출력

        if (plates == null || plates.length == 0) {
            return -1;
        }

        // 몇 번 접시를 얼마나 골랐는지 카운팅할 배열
        int[] selected = new int[types + 1];

        int cnt = 0;
        int max = 0; // 종류의 개수 업데이트

        for (int i = 0; i < n; i++) {
            // selected 배열의 초기 상태 업데이트
            if (selected[plates[i]] == 0) {
                // 아직 고른 적 없을 때
                cnt++;
            }

            selected[plates[i]]++;
        }
        // 현재 종류의 개수 업데이트
        max = cnt;

        for (int i = 1; i < plates.length; i++) {
            // max 값 업데이트
            if (max <= cnt) {
                if (selected[coupon] == 0) {
                    // 쿠폰에 해당하는 접시를 안 먹은 경우
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            // 포인터를 옮기면서 카운팅 바꾸기
            int p1 = i - 1;
            int p2 = (i + n - 1) % plates.length;

            selected[plates[p1]]--;
            if (selected[plates[p1]] == 0) {
                cnt--;
            }

            if (selected[plates[p2]] == 0) {
                cnt++;
            }
            selected[plates[p2]]++;
        }

        return max;
    }

    public static int solution(int n, int[] times) {
    /*
        n명의 환자와 k명의 의사가 있는데, 의사마다 진료하는데 소요되는 시간이 다르다
        k명의 의사가 진료하는데 걸리는 시간은 times 배열
        ex) times = [2,3] , 의사 두 명에 각각 진료시간은 2분 3분

        - 의사는 한 번에 한 명의 환자만 진료 받을 수 있고
        대기하고 있는 환자는 순서대로 진료가 끝난 의사에게 진료를 받는다
        모든 환자가 진료를 받는데 걸리는 최소한의 시간 구하기
     */
        // 이진 탐색으로 풀어보기
        // 0분부터 진료 시간이 더 늦은 의사에게 모두 받는 경우를 계산하여
        // max 값으로 잡아서 중앙 값을 뽑아 탐색을 시작한다
        // 중앙 값을 기준으로 의사1과 의사2가 진료할 수 있는 최대를 뽑아 더 크면
        // 오버한 것이기 때문에 다시 왼쪽에서 중앙 값을 뽑아 만든다

        // 의사의 진료시간을 오름차순으로 보장하기 위해 정렬
        Arrays.sort(times);

        int left = 0;
        int right = times[times.length - 1] * n;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            // 이 시간 내에서 몇 명의 환자를 진료 가능한지
            // 의사 수만큼 반복문 돌리며 cnt 누적 값 업데이트
            for (int i = 0; i < times.length; i++) {
                // cnt가 진료 할 수 있는 환자의 수
                cnt += mid / times[i];
            }

            if (cnt < n) {
                // 대기하는 환자 수만큼 못한 상황 > 시간 늘리기
                left = mid + 1;
            } else {
                // 시간이 많이 남았을 떄
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("solution 1");
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n ,times)); // 28
        System.out.println();

        System.out.println("solution 2");
        n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30; // 총 초밥 종류의 개수
        int coupon = 30;
        System.out.println(solution2(n, plates, types, coupon));
        System.out.println();

        System.out.println("solution 3");
        n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution3(n, items));
    }
}

package Part02.Chapter03;

import java.util.*;

public class PriorityQueuePractice2 {
    public static String solution6(String s) {
        /*
            문자열 s가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록
            재배치 한다. 재배치가 가능한 경우 재정렬한 문자열 반환, 아니면 null

            입력 : "aabb"
            출력 : "abab"

            입력 : "aaca"
            출력 : null
         */

        // 문자들의 개수를 센 다음에 사이사이 넣는다
        HashMap<String, Integer> map = new HashMap<>();
        for (String st : s.split("")) {
            map.put(st, map.getOrDefault(st,0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (x,y) -> y.getValue() - x.getValue());
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            pq.offer(item);
        }

        StringBuffer sb = new StringBuffer();
        Map.Entry<String, Integer> prev = null;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> cur = pq.poll();

            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }

            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);

            prev = cur;
            if (pq.isEmpty() && prev.getValue() > 0) {
                return null;
            }
        }

        return sb.toString();
    }
    public static void solution4(int[] nums, int k) {
        /*
            nums 배열에 주어진 정수들 중에서 가장 많이 발생한 숫자들 순으로 k번째까지 출력
            빈도가 같은 경우엔 값이 작은 숫자가 먼저 출력

            입력 : 1,1,1,2,2,3 / 2
            출력 : 1,2

            입력 : 3,1,5,5,3,3,1,2,2,1,3 / 3
            출력 : 3,1,2,
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        // 빈도 수 계산하기
        for (int num : nums) {
            // 해당 값이 있으면 키에 해당하는 값을 가져온다
            // 아니면 default 값을 설정gkdu + 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Map.Entry는 Map 인터페이스의 애부 인터페이스로 키와 값을 하나의 객체로 묶어
        // 다루기 위함이다 getKey, getValue 메서드 제공
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((x, y) -> y.getValue() == x.getValue() ?
                        x.getKey() - y.getKey() : y.getValue() - x.getValue());

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            pq.add(item);
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            System.out.print(cur.getKey() + " ");
        }
        System.out.println();
    }

    class Num implements Comparable<Num> {
        int key;
        int freq;
        Num (int key, int freq) {
            this.key = key;
            this.freq = freq;
        }

        @Override
        public int compareTo(Num o) {
            if (this.freq == o.freq) {
                return this.key - o.key;
            } else {
                return o.freq - this.freq;
            }
        }
    }

    public static void solution5(int[] nums, int k) {
        // 빈도 수 세기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Num> pq = new PriorityQueue();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            pq.add(new PriorityQueuePractice2().new Num(item.getKey(), item.getValue()));
        }

        for (int i = 0; i < k; i++) {
            Num cur = pq.poll();
            System.out.print(cur.key + " ");
        }
        System.out.println();
    }
    public static void solution3(int[] stones) {
        /*
             돌의 무게 데이터로 이루어진 정수형 stones 배열
             해당 배열로부터 가장 무게가 많이 나가는 돌 두 개를 꺼낸다
             무게가 같다면 소멸, 무게가 다르면 남은 무게만큼의 돌을 다시 추가
             이 과정을 반복하며 가장 마지막의 돌의 무게를 출력

             입력 : 2,7,4,1,8,1
             출력 : 1

             입력 : 5,3,5,3,4
             출력 : 2
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);

        for (int s : stones) {
            pq.offer(s);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int diff = Math.abs(s1 - s2);

            if (diff != 0) {
                pq.offer(diff);
            }
        }

        System.out.println(pq.poll());
    }
    public static int solution1(int[] nums, int k) {
        /*
            nums 배열에 주어진 정수들 중에서 k번째로 큰 수를 반환
            입력 : 3,1,2,7,6,4 / 2
            출력 : 6
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 낮은 숫자부터 정렬되니까
        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int solution2(int[] nums, int k) {

        // 기본 sort 방법
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {

        System.out.println("Solution 1, 2");
        int[] nums = {3,1,2,7,6,4};
        System.out.println(solution1(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println();

        nums = new int[]{1,3,7,4,2,8,9};
        System.out.println(solution1(nums, 7));
        System.out.println(solution2(nums, 7));

        System.out.println();
        System.out.println("Solution 3");
        int[] stones = {2,7,4,1,8,1};
        solution3(stones);

        stones = new int[]{5,3,5,3,4};
        solution3(stones);

        System.out.println();
        System.out.println("Solution 4, 5");
        nums = new int[]{1,1,1,2,2,3};
        solution4(nums, 2);
        solution5(nums, 2);

        nums = new int[]{3,1,4,4,3,3,1,2,2,1,3};
        solution4(nums, 3);

        System.out.println();
        System.out.println("Solution 4, 5");
        System.out.println(solution6("aabb"));
        System.out.println(solution6("aaaaabccd"));
        System.out.println(solution6("aaca"));
    }
}

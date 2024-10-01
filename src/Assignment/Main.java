package Assignment;

import java.util.*;


public class Main {
    public static int solution12(int[] useageArr, int fee) {
        int answer = 0;

        for (Integer i : useageArr) {
            answer =+ i*fee;
        }

        return answer;
    }
    public static boolean solution(String p, String s) {
        boolean answer = true;

        StringBuilder sb = new StringBuilder();
        Hashtable<Integer, String> ht = new Hashtable<>();

        int i = 0;
        for (String str : p.split("")) {
            ht.put(i++, str);
        }

        for (int j = 0; j < p.length(); j++) {

        }

        return answer;
    }
    public static int solution11(int[] arr) {

        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < arr.length - 1; i++) {
            list.add(arr[i]);
        }

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        return sum / list.size();
    }

    public static int[] solution10(int[] arr1, int[] arr2) {

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int b : arr2) {
            if (map.containsKey(b)) {
                list.add(b);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int solution9(String s) {

        HashMap map = new HashMap<>();

        for (String str : s.split(" ")) {
            map.put(str, 1);
        }

        return map.size();
    }

    public int solution(int[] A) {
        int answer = A[0];  // 초기 값으로 첫 번째 요소를 설정

        for (int idx = 1; idx < A.length; idx++) {
            int a = answer;  // 현재 값
            int b = A[idx];  // 다음 요소

            // 유클리드 알고리즘을 사용하여 GCD 계산
            while (b != 0) {
                int temp = b;
                b = a % b;  // a를 b로 나눈 나머지
                a = temp;   // b의 값을 a에 대입
            }
            answer = a;  // 새로운 GCD로 업데이트
        }

        return answer;  // 최종 GCD 반환
    }
    public static String solution8(int n, String s, int t) {
        String answer = "";
        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n + s.length(); i++) {
            if (i < n) {
                q.add(".");
            } else {
                q.add(String.valueOf(s.charAt(i - n)));
            }
        }

        while (t > 0) {
            q.add(q.poll());
            t--;
        }

        for (int i = 0; i < n; i++) {
            sb.append(q.poll());
        }

        return sb.toString();
    }

    public static int solution7(int[] arr) {
        int answer = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (answer > Math.abs(arr[i])) {
               answer = arr[i];
            }
        }

        return answer;
    }

    public static int solution6(int[] orders, int n) {
        int cnt = 0;
        int cur = 1; // 1부터 시작할 숫자
        int idx = 0; // 배열 내의 인덱스

        while (cnt < n) {
            if (idx < orders.length && orders[idx] == cur) {
                // 배열에 숫자가 있으면 다음 배열을 가리키기
                idx++;
            } else {
                // 배열에 없으면 cnt 증가
                cnt++;
            }

            if (cnt < n) {
                // 숫자 다음으로 넘어감
                cur++;
            }
        }

        return cur;
    }
    public static String[] solution5(String s) {
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();

        for (String str : s.split("")) {
            queue.add(str);
        }

        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (tmp.equals(".") || tmp.equals(",") || tmp.equals("!") ||
            tmp.equals("?") || tmp.equals(" ")) {
                if (sb.length() > 0) {
                    result.add(sb.reverse().toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(tmp);
            }
        }

        return result.toArray(new String[0]);
    }

    public static int solution4(String S) {
        int answer = 0;

        int num = Integer.parseInt(S, 2);
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                answer += 1;
            } else {
                num = num - 1;
                answer += 1;
            }
        }

        return answer;
    }
    public static int solution3(String s) {
        int answer = 0;
        int[] cnt = new int[10];

        for (String i : s.split("")) {
            cnt[Integer.parseInt(i)] += 1;
        }

        int maxCnt = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                answer = i;
            } else if (cnt[i] == maxCnt) {
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }
    public static int solution2(int[] A) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int tmp = -1;

        for (int i = 0; i < A.length - 1; i++) {
            if (min > A[i]) {
                min = A[i];
                tmp = i;
            }
        }

        for (int i = tmp + 1; i < A.length; i++) {
            if (A[i] > max) max = A[i];
        }
        if (tmp != -1 && max > min) {
            return max - min;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{100000, 98000, 95000, 98000, 92000};
        System.out.println(solution2(A));

        System.out.println(solution3("55223"));
        System.out.println(solution4("1101"));

        System.out.println(Arrays.toString(solution5("Hello, World?!")));

        int[] order = {2, 4, 5, 7};
        int n = 3;
        System.out.println(solution6(order, n));

        System.out.println(solution8(5,"snowball",15));

        System.out.println("solution 9");
        System.out.println(solution9("Hello world Nice world"));

        System.out.println("solution 10");
        int[] arr1 = {1, 7, 8, 4};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println(solution10(arr1, arr2));

        System.out.println("solution 11");
        System.out.println(solution11(arr1));

        arr1 = new int[]{1, 3, 5};
        System.out.println(solution12(arr1,5));
    }
}

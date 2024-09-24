package Part02.Chapter02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTablePractice3 {
    /*
        HashTable HashMap 차이
        공통 : 둘 다 Map 인터페이스를 구현한 것
        차이 : Key에 Null 값 사용 여부
                HashTable 불가 / HashMap 가능
              Thread-safe
                HashTable O (멀티 스레드 환경에서 우수)
                HashMap X (싱글 스레드 환경에서 우수)
                참고사항 -> SyncronizedMap, ConcurrentHashMap > 스레드 safe하게 사용 가능

        cpu에 프로세서라는 게 있는데,
        작업을 처리하는 단위인 thread가 있다
        1일 수도 있고 여러 개일 수도 있는데
        thread1에서도 일 하고 있을 거고 thread2에서도 다른 일을 하고 있을 거다.

        Multi-thread 라고 하는 것이, 프로세서가 일을 할 수 있는 시간 안에서
        어떤 시간에는 thread1을 돌렸다가 어떤 시간에는 thread2를 돌렸다가
        번갈아 가면서 일을 처리한다 (시간이 동일하진 않다)
        굉장히 빠르기 때문에 우리가 볼 때는 동시에 진행되는 거라고 느낀다

        동시에 진행하는 거는, 프로세서가 여러 개 있는 상황에서 멀티 프로세싱을 말한다(병렬 처리)

        Multi-thread 일 때 생기는 문제점은,
        메모리에 int a라는 변수가 있다고 치면
        th1이 a = 10; 설정하고 th2가 a = 5; 설정을 한다.
        th2쪽에서 기대하는 결과는 5여야 하는데
        multi-thread 에서 문제점이 무어냐면 int a 를 공유자원이라고 하는데,
        th1 접근 > a < th2 접근 (동시 접근)

        위의 내용에서 말했듯이 스케줄링이 돌면서 th1, th2을 돌아가면서 일을 시키는데
        이 돌아가면서 일을 하던 와중에 th1이 a값 바꾼 후 th2이 a를 쓸 때
        int a가 th1나 th2가 기대하는 값과 다른 값이 나올 수 있다. (thread-unsafe)

        이때 동기화를 할 수 있는 방법은
        thread가 a라는 변수를 사용할 때 잠깐 lock을 걸고 사용 후 unlock을 해주면 동기화가 가능하다.

    */


    public static void solution3() {

        // HastTable HashMap 사용법
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0));

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0));

        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;
        System.out.println(map1.get(0));
        System.out.println(map2.get(0));

        // HashTable은 null 이용한 키 값 불가
        //ht.put(null, -999);
        //System.out.println(ht.get(null));

        // HashMap은 null 키 값 이용 가능
        hm.put(null, -999);
        System.out.println(hm.get(null));
    }
    public static int[] solution2(int[] nums, int target) {
        /*
            nums에서 임의의 두 수를 더해 target을 구할 수 있는지 확인하여 인덱스 반환
            nums : 7, 11, 5, 3
            target : 10
            출력 : 0, 3
         */

        int[] result = new int[2];
         Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                // index 구하기
                result[0] = ht.get(nums[i]);
                result[1] = i;
                return result;
            }

            // 값의 키로 target 에서 현대 nums의 차이 값을 넣는다
            ht.put(target - nums[i], i);
        }

        return null;
    }
    public static void solution(int[] arr1, int[] arr2) {
        /*
            배열 1 이용하여 해시 테이블 초기화 한 후
            배열 2 에 데이터가 해시 테이블에 있는지 확인 하는 코드

            배열1 : 1, 3, 5, 7, 9
            배열2 : 1, 2, 3, 4, 5
            출력 : True, False, True, False, True
         */
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < arr1.length; i++) {
            ht.put(arr1[i], arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (ht.containsKey(arr2[i])) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5};
        solution(arr1, arr2);
        System.out.println();

        System.out.println("Solution 2");
        int[] nums = {7, 11, 5, 3};
        System.out.println(Arrays.toString(solution2(nums, 10)));
        nums = new int[]{8, 3, -2};
        System.out.println(Arrays.toString(solution2(nums, 6)));
        nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(solution2(nums, 12)));
        System.out.println();

        System.out.println("Solution 3");
        solution3();
    }
}

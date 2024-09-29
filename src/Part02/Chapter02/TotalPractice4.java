package Part02.Chapter02;

import com.sun.source.tree.ArrayAccessTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.stream.Stream;

public class TotalPractice4 {
    public static ArrayList<Integer> solution2(String[] gems) {
        /*
            주어진 gems 배열에 보석들이 진열되어 있다고 할 때,
            모든 보석들을 하나씩 구매할 수 있는 특정 구간을 출력하는 프로그래밍.
            - 모든 종류의 보석을 최소 하나 이상씩 포함해야 한다
            - 인덱스는 1번부터 시작한다

            해시테이블에 각 보석들의 정보를 넣고 left right를 옮겨가면서
            제일 적은 인덱스가 있는 것을 return
         */

        // 후보 구간들을 집어 올 변수
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        // 중복된 애들 빼서 넣기 위해 hashSet 이용
        Stream.of(gems).forEach(x -> set.add(x));
        // 보석 종류의 개수 n
        int n = set.size();

        if (n == 1) {
            // [1,1]이라는 리스트를 만들어서 새로운 ArrayList를 만든 후 reuslt에 넣음
            result.add(new ArrayList<>(Arrays.asList(1, 1)));
            return result.get(0);
        }

        Hashtable<String, Integer> ht = new Hashtable<>();
        boolean isCandidate = false;

        int left = 0;
        int right = 0;
        // 첫번 째 보석 먼저 넣기
        ht.put(gems[0], 1);

        while (true) {
            if (isCandidate == false) {
                // 현재 구간으로는 만족하지 못하니까 right+1
                right += 1;
                if (right >= gems.length) {
                    // right가 length보다 길면 보석이 더는 없으니까 break
                    break;
                }
                // right의 보석이 현재 해시테이블에 존재하는지 여부
                if (ht.containsKey(gems[right]) == false) {
                    // 없으면 넣어줌
                    ht.put(gems[right], 1);
                } else {
                    // 이미 있으니까 다시 가져와서 +1
                    ht.put(gems[right], ht.get(gems[right]) + 1);
                }

                if (ht.size() == n) {
                    // 현재 테이블에 사이즈가 모든 보석의 종류가 있으면
                    isCandidate = true;
                    // 후보로 넣어준다
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
                }
                // 위 if 부분으로 보석을 다 살 수 있는지 체크하고
                // candidate를 true로 바꿔주며 구간을 후보에 넣어준다

            } else {
                // 현재 구간으로 사는 게 가능하다면
                // left 쪽에서 보석을 하나씩 빼보면서 여전히 살 수 있는지를 확인
                left += 1;
                // 해당 위치에 보석을 가져와서 -1 빼본다
                int cnt = ht.get(gems[left - 1]) -1;

                // cnt가 0이 되어버리면 보석을 못 사는 거니까 remove
                if (cnt == 0) {
                    ht.remove(gems[left - 1]);
                    // false로 바꾸면 다시 if문으로 올라가서 남은 진열대에
                    // 보석이 있으면 만족하는 구간을 찾게 만든다
                    isCandidate = false;
                } else {
                    // 보석을 뺐는데 cnt가 0이 안 됐으면 여전히 구매 가능
                    // 카운트는 다시 업데이트
                    ht.put(gems[left - 1], cnt);
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
                }
            }
        }

        // 가장 짧은 구간 구하기
        int minIdx = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> cur = result.get(i);
            left = cur.get(0);
            right = cur.get(1);

            if (right - left < minNum) {
                minNum = right - left;
                minIdx = i;
            }
        }

        return result.get(minIdx);
    }
    public static String solution(String[] participant, String[] completion) {
    /*
        참가자 배열과 완주한 사람의 배열이 주어졌을 때,
        완주하지 못한 사람 출력
        - 완주하지 못한 사람은 1명 뿐이고, 동명이인 있을 수 있다.
     */
        String result = "";
        Hashtable<String, Integer> ht = new Hashtable<>();

        for (String item : participant) {
            if (ht.containsKey(item)) {
                ht.put(item, ht.get(item) + 1);
            } else {
                ht.put(item, 1);
            }
        }

        for (String item : completion) {
            // 키 값의 containkey 검사를 안 한 이유는,
            // 완주자엔 이미 키 값이 다 존재하기 때문에 해당 데이터를 바로 꺼내서 명수를 -1 뺀다
            ht.put(item, ht.get(item) - 1);
        }

        for (String item : participant) {
            if (ht.get(item) > 0) {
                result = item;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println("solution 1");
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "mislav", "ana"};
        System.out.println(solution(participant, completion));
        System.out.println();

        System.out.println("solution 2");
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution2(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution2(gems));
    }
}

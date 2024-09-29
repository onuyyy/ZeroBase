package Part02.Chapter02;

import org.intellij.lang.annotations.JdkConstants;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

class Doc {
    int no;
    int priority;

    public Doc(int no, int priority) {
        this.no = no;
        this.priority = priority;
    }
}

class Song {
    int no;
    int play;

    public Song(int no, int play) {
        this.no = no;
        this.play = play;
    }
}
public class TotalPractice3 {
    public static void solution3(String[] genres, int[] plays) {
    /*
        1. 장르의 플레이 합을 먼저 구해서 먼저 수록하고
        2. 장르 내에서 많이 재생된 노래를 수록한다.
        3. 장르 내에서 재생 횟수가 같 은 노래 중에선 고유 번호가 낮은 노래 먼저 수록
        4. 장르별 두 개씩 모아서 출력
     */
        Hashtable<String, ArrayList<Song>> ht = new Hashtable<>();

        for (int i = 0; i < genres.length; i++) {
            if (ht.containsKey(genres[i])) {
                ArrayList<Song> cur = ht.get(genres[i]);

                // play 횟수를 비교하여 오름차순으로 넣기 위함
                int idx = -1;
                for (int j = 0; j < cur.size(); j++) {
                    // 현재 넣으려는 곡의 횟수가 이미 존재하는 노래의 횟수보다
                    // 큰지 비교
                    if (plays[i] > cur.get(j).play ||
                        plays[i] == cur.get(j).play && i < cur.get(j).no) {
                        idx = j;
                        break;
                    }
                }

                if (idx == -1) {
                    // 이미 수록된 곡들보다 재생횟수가 작다면
                    // list에 가장 뒷 부분에 추가
                    cur.add(new Song(i, plays[i]));
                } else {
                    cur.add(idx, new Song(i, plays[i]));
                }

                ht.put(genres[i], cur);
            } else {
                // 해당 키가 없는 경우 바로 해시테이블에 넣어준다
                Song s = new Song(i, plays[i]);
                ht.put(genres[i], new ArrayList<>(Arrays.asList(s)));
            }
        }

        // 장르별 재생횟수 합하기
        Hashtable<String, Integer> htPlay = new Hashtable<>();
        for (String i : ht.keySet()) {
            // 위에서 만든 테이블에 있는 key를 가지고 반복문을 돌린다
            int sum = 0;
            ArrayList<Song> cur = ht.get(i);
            for (int j = 0; j < cur.size(); j++) {
                sum += cur.get(j).play;
            }
            htPlay.put(i, sum);
        }

        // 재생 횟수 순으로 정렬하기
        ArrayList<Map.Entry<String, Integer>> htplaySort = new ArrayList<>(htPlay.entrySet());
        // htPlay에 있는 키 값들이 htplaySort로 받는다
        htplaySort.sort((x1, x2) -> x2.getValue() - x1.getValue());
        // 큰 순으로 데이터 정렬

        for (Map.Entry<String, Integer> item : htplaySort) {
            ArrayList<Song> songs = ht.get(item.getKey());

            for (int i = 0; i < songs.size(); i++) {
                System.out.print(songs.get(i).no + " ");

                if (i == 1) {
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void solution2(int[] nums) {
    /*
        1 ~ n 까지 수가 오름차순으로 stack에 들어있다.
        pop과 push 연산을 하면서 주어진 수열을 만들어낼 수 있는지 출력해라
     */
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > idx) {
                // 배열에서 하나를 집어 와서 idx 보다 큰지 확인하여
                // 크다면 stack에 다시 쌓아둠
                for (int j = idx + 1; j < num + 1; j++) {
                    stack.add(j);
                    result.add("+");
                }
                idx = num;


            } else if (stack.peek() != num) {
                // 수열을 만들 수 있는지 체크
                // 수열을 만들 수 없는 구조
                System.out.println("No");
                return;
            }

            stack.pop();
            result.add("-");
        }

        for (String s : result) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void solution(int docs, int target, int[] priority) {
        /*
            문서의 개수 docs, 출력 대상 번호(인덱스), 문서들의 우선순위가
            차례대로 주어졌을 때 출력할 문서의 출력 순서 알아내기
            단, 현재 문서보다 우선순위가 높은 문서가 있을 시 이 문서를
            인쇄하지 않고 queue에 가장 뒤에 재배치 한다.
         */
        Queue<Doc> queue = new LinkedList<>();

        for (int i = 0; i < docs; i++) {
            queue.add(new Doc(i, priority[i]));
        }

        // 몇번 째로 출력되는지 세어볼 변수
        int cnt = 1;
        while (true) {
            Doc cur = queue.poll();

            // filter의 조건을 x.priority > cur.priority보다 큰 것을 기준으로
            // 배열로 만든다 > 있으면 highP에 값이 담겨져 나올 것이다
            Doc[] highP = queue.stream().filter(x -> x.priority > cur.priority).
                    toArray(Doc[]::new);

            if (highP.length > 0) {
                // 우선순위가 높은 게 있으면 다시 큐에다 넣는다
                queue.add(cur);
            } else {
                // 찾아야 될 문서가 target이면 현재의 카운트를 출력해주고 break
                if (cur.no == target) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("solution 1");
        int docs = 1;   // 문서의 개수
        int target = 0; // 출력 문서 번호 (인덱스 0부터 시작)
        int[] priority = {5}; // 출력할 문서의 우선순위
        solution(docs, target, priority); // 출력 1

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
        System.out.println();

        System.out.println("solution 2");
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1};
        solution2(nums);

        nums = new int[]{1, 2, 5, 3, 4};
        solution2(nums);
        System.out.println();

        System.out.println("solution 3");
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution3(genres, plays);
    }
}

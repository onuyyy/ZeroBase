package Part02.Chapter02;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

public class TotalPractice2 {
    public static Integer solution2(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {

        // 뱀의 위치가 1,1 에서 출발
        int[][] board = new int[n + 1][n + 1];

        // 사과 위치 정보 board에 업데이트
        for (ArrayList item : apples) {
            board[(int)item.get(0)][(int)item.get(1)] = 1;
        }

        // 뱀 위치
        Queue<ArrayList> snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1, 1)));

        // 뱀이 어느 쪽으로 이동해야 할지에 대한 값 관리
        ArrayList<ArrayList> direction = new ArrayList<>();
        direction.add(new ArrayList(Arrays.asList(0, 1))); // 오른쪽
        direction.add(new ArrayList(Arrays.asList(1, 0))); // 왼쪽
        direction.add(new ArrayList(Arrays.asList(0, -1)));
        direction.add(new ArrayList(Arrays.asList(-1, 0)));

        int dIdx = 0;
        int score = 0;
        int x = 1;
        int y = 1;

        while (true) {
            score += 1;
            x += (int)direction.get(dIdx).get(0); // direction의 0번째니까 오른쪽
            y += (int)direction.get(dIdx).get(1);

            if (1 <= x && x <= n && 1 <= y && y <= n) {
                // 벽과 부딪혔는지
                ArrayList cur = new ArrayList(Arrays.asList(x, y));
                if (snake.contains(cur)) {
                    // 부딪혔다 게임 종료
                    return score;
                }
                snake.add(cur);

                if (board[x][y] == 0) {
                    snake.poll();
                } else {
                    board[x][y] = 0;
                }
            } else {
                return score;
            }

            // 이동 방향 바꾸는 부분
            if (moves.size() > 0 && score == (int)moves.peek().get(0)) {
                if ((char)moves.peek().get(1) == 'D') {
                    // 우측 90도로 방향 바꿈
                    dIdx = (dIdx + 1) % 4;
                    moves.poll();
                } else if ((char)moves.peek().get(1) == 'L') {
                    dIdx = (dIdx - 1) % 4;
                    moves.poll();
                }
            }
        }
    }

    public static void solution(String str) {
    /*
        괄호 짝 검사하여 이상이 없는지 판별하는 프로그램
        (), {}, []
     */
        Stack<String> stack = new Stack<String>();
        boolean flag = true;
        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        for (String s : str.split("")) {
            if (map.containsKey(s)) {
                stack.push(s);
            } else if (map.containsValue(s)) {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    String cur = stack.pop();
                    if (!s.equals(map.get(cur))) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag && stack.isEmpty()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static void main(String[] args) {

        System.out.println("Practice 1");
        solution("[yyyy]-[mm]-[dd]");
        solution("System.out.println(arr[0][1]");
        solution("Support [Java or Python(3.x)]");
        solution("([[{}])");
        System.out.println();

        System.out.println("Practice 2");
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList<>();
        apples.add(new ArrayList(Arrays.asList(3, 4)));
        apples.add(new ArrayList(Arrays.asList(2, 5)));
        apples.add(new ArrayList(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList<>();
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(7, 'D')));
        System.out.println(solution2(n, k, l, apples, moves));
    }
}

package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1021_Deque {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < m; i++) {
            int x = nums[i];
            int size = list.size();
            int idx = list.indexOf(x);

            if (idx == 0) {
                list.pollFirst();
                continue;
            }

            if (list.indexOf(x) <= size / 2) {
                for (int j = 0; j < idx; j++) {
                    int tmp = list.pollFirst();
                    list.addLast(tmp);
                    cnt++;
                }
            } else {
                for (int j = 0; j < size - idx; j++) {
                    int tmp = list.pollLast();
                    list.addFirst(tmp);
                    cnt++;
                }
            }
            list.pollFirst();
        }

        System.out.println(cnt);
    }
}

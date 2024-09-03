package Part02.Chapter03;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.stream.IntStream;

class MinHeap2 {
    ArrayList<Integer> heap;

    MinHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }
    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur));
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        int target = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if (right < heap.size()) {
                targetIdx = heap.get(left) < heap.get(right) ? left : right;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);

                cur = targetIdx;
            }
        }
        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

class MaxHeap2 {
    ArrayList<Num> heap;

    public MaxHeap2() {
        this.heap = new ArrayList<>();
        // 더미 데이터 넣어서 인덱스 1부터 시작하도록
        this.heap.add(new Num(0));
    }

    public void insert(int data) {
        heap.add(new Num(data));

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2).val < heap.get(cur).val) {
            Num parentVal = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur));
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Num delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        Num target = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int left = 2 * cur;
            int right = 2 * cur + 1;
            int targetIdx = -1;

            if (right < heap.size()) {
                targetIdx = heap.get(left).val < heap.get(right).val ? right : left;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if (heap.get(cur).val > heap.get(targetIdx).val) {
                break;
            } else {
                Num parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }
}

class Num {
    int val;
    boolean isMinus;

    public Num(int val) {
        this.isMinus = val < 0 ? true : false;
        this.val = Math.abs(val);
    }
}
public class HeapPractice2 {

    public static void solution3(int[] nums, int deleteCnt) {
        /*
            정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대 값이 큰 값부터 출력
            입력 : 3, 0, -2, -5, 9, 6, -11, 20, -30
            삭제 횟수 : 1
            출력 : 20, -11, 9, 6, -5, 3, -2, 0
         */
        MaxHeap2 m2 = new MaxHeap2();
        IntStream.of(nums).forEach(x -> m2.insert(x));

        int cnt = 0;
        while (m2.heap.size() != 1) {
            Num cur = m2.delete();

            if (cnt++ < deleteCnt) {
                continue;
            }

            int oriVal = cur.isMinus ? cur.val * -1 : cur.val;
            System.out.print(oriVal + " ");
        }
        System.out.println();
    }
    public static void solution2(MinHeap2 m2) {
        /*
            최소 힙, 최대 힙을 이용하여 데이터를 오름차순 내림차순으로 출력
         */
        MaxHeap maxHeap = new MaxHeap();
        System.out.print("오름차순 : ");
        while (m2.heap.size() != 1) {
            int data = m2.delete();
            System.out.print(data + " ");
            maxHeap.insert(data);
        }
        System.out.println();

        System.out.print("내림차순 : ");
        while (maxHeap.heap.size() != 1) {
            System.out.print(maxHeap.delete() + " ");
        }
        System.out.println();
    }
    public static void solution(MinHeap2 m, int from, int to) {
        /*
            Heap의 from 숫자 > to 숫자로 바꾸기
            중복이 있다면 모두
         */
        for (int i = 0; i < m.heap.size(); i++) {
            if (m.heap.get(i) == from) {
                m.heap.set(i, to);

                // 변경된 heap 재구성 함수
                moveUp(m, i);
                moveDown(m, i);
            }
        }
    }

    public static void moveUp(MinHeap2 m ,int idx) {
        // idx > 현재 변경된 위치에 대한 idx
        int cur = idx;

        while (cur > 1 && m.heap.get(cur / 2) > m.heap.get(cur)) {
            int parentVal = m.heap.get(cur / 2);
            m.heap.set(cur / 2, m.heap.get(cur));
            m.heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public static void moveDown(MinHeap2 m, int idx) {
        int cur = idx;

        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if (right < m.heap.size()) {
                targetIdx = m.heap.get(left) < m.heap.get(right) ? left : right;
            } else if (left < m.heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if (m.heap.get(cur) < m.heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = m.heap.get(cur);
                m.heap.set(cur, m.heap.get(targetIdx));
                m.heap.set(targetIdx, parentVal);

                cur = targetIdx;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Solution");
        MinHeap2 m = new MinHeap2();
        m.insert(30);
        m.insert(40);
        m.insert(10);
        m.insert(50);
        m.insert(60);
        m.insert(70);
        m.insert(20);
        m.insert(30);
        System.out.println("데이터 변경 전");
        m.printTree();

        System.out.println();
        System.out.println("데이터 변경 후");
        solution(m, 30, 100);
        m.printTree();

        System.out.println();
        solution(m, 60, 1);
        m.printTree();

        System.out.println();
        System.out.println("Soluiton 2");
        MinHeap2 m2 = new MinHeap2();
        m2.insert(30);
        m2.insert(40);
        m2.insert(10);
        m2.insert(50);
        m2.insert(60);
        m2.insert(70);
        m2.insert(20);
        m2.insert(30);
        solution2(m2);

        System.out.println();
        System.out.println("Soluiton 3");
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution3(nums, deleteCnt);
    }
}



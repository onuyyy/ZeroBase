package Part02.Chapter03;

import java.util.ArrayList;
import java.util.Arrays;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        // 더미 데이터 넣어서 인덱스 1부터 시작하도록
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
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
            int left = 2 * cur;
            int right = 2 * cur + 1;
            int targetIdx = -1;

            if (right < heap.size()) {
                targetIdx = heap.get(left) < heap.get(right) ? right : left;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if (heap.get(cur) > heap.get(targetIdx)) {
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

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        // 더미 데이터 넣어서 인덱스 1부터 시작하도록
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        // 부모 키 값과 비교하여 자리 이동
        // 방금 넣은 데이터의 인덱스 위치
        int cur = heap.size() - 1;
        // cur / 2 = 부모 인덱스 값이 지금 들어 온 데이터 값보다 크다면
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            // 부모 인덱스에 방금 들어온 데이터 넘기기
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            // 한 번 더 부모로 올라가서 체크하기
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
                // 비교 대상 없음
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
public class HeapPractice {
    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        System.out.println("Min Heap");
        System.out.println("Data Insert");
        m.insert(30);
        m.insert(40);
        m.insert(10);
        m.printTree();
        m.insert(50);
        m.insert(60);
        m.insert(70);
        m.printTree();
        m.insert(20);
        m.printTree();
        m.insert(30);
        m.printTree();

        System.out.println();
        System.out.println("Data Delete");
        System.out.println(m.delete());
        m.printTree();
        System.out.println(m.delete());
        m.printTree();
        System.out.println(m.delete());
        m.printTree();

        System.out.println();
        MaxHeap m2 = new MaxHeap();
        System.out.println("Max Heap");
        System.out.println("Data insert");
        m2.insert(30);
        m2.insert(40);
        m2.insert(10);
        m2.printTree();
        m2.insert(50);
        m2.insert(60);
        m2.insert(70);
        m2.printTree();
        m2.insert(20);
        m2.printTree();
        m2.insert(30);

        System.out.println();
        System.out.println("Data Delete");
        System.out.println(m2.delete());
        m2.printTree();
        System.out.println(m2.delete());
        m2.printTree();
        System.out.println(m2.delete());
        m2.printTree();
    }
}

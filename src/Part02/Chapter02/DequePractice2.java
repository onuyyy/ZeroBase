package Part02.Chapter02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

class MyDeque3 {

    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque3(int size) {
        // 원형 데트로 만들 거임
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void increaseSize() {
        System.out.println("Call increaseSize..");

        int[] arrTmp = this.arr.clone();
        this.arr = new int[this.arr.length * 2];

        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % arrTmp.length;

        int idx = 1;
        for (int i = start; i != end ; i = (i + 1) % arrTmp.length) {
            this.arr[idx++] = arrTmp[i];
        }

        this.front = 0;
        this.rear = idx - 1;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            increaseSize();
        }

        this.arr[this.front] = data;
        // 원형 유지를 위해 길이를 더한다
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if (this.isFull()) {
            increaseSize();
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public void addMiddle(int data) {
        if (this.isFull()) {
            increaseSize();
        }

        // 데크에 원소 몇 개있는지 확인
        int elements = this.rear - this.front;
        if (elements < 0) {
            elements = this.arr.length + elements;
        }

        // 중간 지점 찾기
        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        // 데이터 넣기
        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;

        for (int i = start; i != end; i = (i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }

        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;
    }
    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        // 원형 큐는 프론트 쪽에 공간을 비워두니까 그 다음 부분을 가리킴
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1);
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
public class DequePractice2 {

    public static boolean checkPalindrome(String str) {

        Deque<String> deque = new ArrayDeque<>();
        boolean result = false;

        for (String s : str.split("")) {
            deque.addLast(s);
        }

        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                result = true;
                break;
            }
            if (deque.pollFirst().equals(deque.pollLast())) {
                result = true;
            } else {
                break;
            }
        }

        return result;
    }
    public static void reorderData(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        IntStream.of(arr).forEach(x -> deque.addLast(x));
        while (!deque.isEmpty()) {
            result.add(deque.removeFirst());

            if (!deque.isEmpty()) {
                result.add(deque.removeLast());
            }
        }

        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + " -> ");
        }
        System.out.println(result.get(result.size() - 1));
    }
    public static void main(String[] args) {

        System.out.println("Practice 1");
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        reorderData(arr);
        System.out.println();

        System.out.println("Practice 2");
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abcba"));
        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("madam"));
        System.out.println();

        System.out.println("Practice 3 & 4");
        MyDeque3 m = new MyDeque3(5);
        m.addLast(1);
        m.addLast(2);
        m.addLast(3);
        m.addLast(4);
        m.addLast(5);
        m.printDeque();
        m.addLast(6);
        m.addLast(7);
        m.addLast(8);
        m.addLast(9);
        m.addLast(10);
        m.printDeque();

        m.removeLast();
        m.removeLast();
        m.addMiddle(100);
        m.addMiddle(200);
        m.addMiddle(300);
        m.addMiddle(400);
        m.printDeque();

    }
}


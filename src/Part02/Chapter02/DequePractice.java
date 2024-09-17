package Part02.Chapter02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class MyDeque2 {

    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque2(int size) {
        // 원형 데트로 만들 거임
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        this.arr[this.front] = data;
        // 원형 유지를 위해 길이를 더한다
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
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

class MyDeque {

    ArrayList<Integer> list;
    MyDeque() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        }
        return false;
    }

    public void addFirst(int data) {
        this.list.add(0, data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = this.list.get(0);
        this.list.remove(0);

        return data;
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        return data;
    }

    public void printDeque() {
        System.out.println(this.list);
    }
}
public class DequePractice {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        Deque<Integer> deque = new ArrayDeque<Integer>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        // null return
        System.out.println(deque.pollLast());
        // 예외 발생
       //System.out.println(deque.removeLast());
        System.out.println();

        System.out.println("Practice 2");
        MyDeque md = new MyDeque();
        md.addFirst(1);
        md.addFirst(2);
        md.addFirst(3);
        md.printDeque();

        md.addLast(10);
        md.addLast(20);
        md.addLast(30);
        md.printDeque();

        System.out.println(md.removeFirst());
        md.printDeque();
        System.out.println(md.removeLast());
        md.printDeque();

        System.out.println(md.removeFirst());
        System.out.println(md.removeFirst());
        System.out.println(md.removeFirst());
        System.out.println(md.removeFirst());
        md.printDeque();
        System.out.println();

        System.out.println("Practice 3");
        MyDeque2 m2 = new MyDeque2(5);
        m2.addFirst(1);
        m2.addFirst(2);
        m2.addFirst(3);
        m2.printDeque();

        m2.addLast(10);
        m2.addLast(20);
        m2.addLast(30);
        m2.printDeque();

        System.out.println(m2.removeFirst());
        m2.printDeque();

        System.out.println(m2.removeLast());
        m2.printDeque();

        System.out.println(m2.removeLast());
        System.out.println(m2.removeLast());
        System.out.println(m2.removeLast());
        System.out.println(m2.removeLast());
    }
}


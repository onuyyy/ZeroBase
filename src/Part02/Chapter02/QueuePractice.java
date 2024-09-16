package Part02.Chapter02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class MyQueue2 {

    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size) {
        this.arr = new int[size + 1];
    }

    public boolean isEmtpy() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue() {
        if (this.isEmtpy()) {
            System.out.println("Queue is Empty");
            return null;
        }

        this.front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue() {
        // start와 end에 +1을 더하는 이유는 원형 큐에서 front와 rear가
        // 각각 실제 데이터가 들어있는 위치가 아니라
        // "마지막으로 값을 뺀" 위치와 "마지막으로 값을 넣은" 위치를 가리키기 때문
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end ; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
class MyQueue1 {
    ArrayList<Integer> list;

    MyQueue1() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        int data = this.list.get(0);
        this.list.remove(0);

        return data;
    }

    public Integer peek() {
        if (this.list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        int data = this.list.get(0);

        return data;
    }

    public void printQueue() {
        System.out.println(this.list);
    }
}
public class QueuePractice {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        Queue q = new LinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);

        System.out.println(q.poll());
        System.out.println(q);

        System.out.println(q.contains(3));
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.clear();
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println();

        System.out.println("ArrayList 이용한 Queue");
        MyQueue1 q1 = new MyQueue1();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        q1.push(4);
        q1.push(5);

        q1.printQueue();

        System.out.println(q1.peek());
        q1.printQueue();

        System.out.println(q1.pop());
        q1.printQueue();

        System.out.println(q1.pop());
        q1.printQueue();

        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        q1.printQueue();
        System.out.println();

        System.out.println("배열 이용한 원형 Queue");
        MyQueue2 q2 = new MyQueue2(5);
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);
        q2.enqueue(6);
        q2.printQueue();

        System.out.println(q2.dequeue());
        q2.printQueue();

        System.out.println(q2.dequeue());
        q2.printQueue();

        q2.enqueue(6);
        q2.enqueue(7);
        q2.printQueue();

        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        q2.printQueue();
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        q2.dequeue();
    }
}

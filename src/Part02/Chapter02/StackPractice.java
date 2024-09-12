package Part02.Chapter02;

import java.util.ArrayList;


class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        int data = this.arr[this.top];
        top -= 1;

        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
class MyStack {
    ArrayList<Integer> list;

    MyStack() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Full");
            return null;
        }
        int data = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Full");
            return null;
        }
        int data = this.list.get(this.list.size() - 1);

        return data;
    }

    public void printStack() {
        System.out.println(this.list);
    }

}
public class StackPractice {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        MyStack s = new MyStack();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printStack();

        System.out.println(s.peek());
        s.printStack();

        System.out.println(s.pop());
        System.out.println(s.pop());
        s.printStack();

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.printStack();
        System.out.println();

        System.out.println("Practice 2");
        MyStack2 m2 = new MyStack2(5);
        System.out.println(m2.isEmpty());
        m2.push(1);
        m2.push(2);
        m2.push(3);
        m2.push(4);
        m2.push(5);
        m2.push(6);
        m2.printStack();

        System.out.println(m2.peek());
        m2.printStack();

        System.out.println(m2.pop());
        System.out.println(m2.pop());
        m2.printStack();

        System.out.println(m2.pop());
        System.out.println(m2.pop());
        System.out.println(m2.pop());
        m2.printStack();

    }
}

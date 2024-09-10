package Part02.Chapter02;

import java.util.Objects;

class LinkedList2 extends LinkedList {
    LinkedList2(Node node) {
        this.head = node;
    }

    // 데이터 추가 시 beforeData가 null이면 가장 뒤에 추가
    // beforeData에 값이 있는 경우 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;

            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new Node(data, this.head);
                    } else {
                        pre.next = new Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void deleteData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
}

class Node {
    int data;
    // 자기 자신의 클래스를 가리킬 next
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList(Node node) {
        this.head = node;
    }

    LinkedList() {
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void deleteData() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
            // 삭제할 대상을 cur로 잡아두고, 그 전의 Node의 next를 null 만들어야
            // 하기 때문에 prev 에 cur 담는다
        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
public class LinkedListPractice {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        LinkedList l = new LinkedList(new Node(1, null));
        l.addData(2);
        l.addData(3);
        l.addData(4);
        l.addData(5);
        l.printList();

        l.findData(3);
        l.findData(100);
        l.printList();

        l.deleteData();
        l.deleteData();
        l.deleteData();
        l.printList();

        l.deleteData();
        l.deleteData();
        l.deleteData();
        System.out.println();

        System.out.println("Practice 2");
        LinkedList2 l2 = new LinkedList2(new Node(1, null));
        l2.printList();

        l2.addData(2);
        l2.addData(3);
        l2.addData(4);
        l2.addData(5);
        l2.printList();

        l2.addData(100, 1);
        l2.addData(200, 2);
        l2.addData(300, 3);
        l2.addData(400, 4);
        l2.addData(500, 5);
        l2.printList();

        l2.deleteData(300);
        l2.deleteData(100);
        l2.deleteData(500);
        l2.deleteData(200);
        l2.deleteData(400);
        l2.printList();

        l2.deleteData(3);
        l2.deleteData(1);
        l2.deleteData(5);
        l2.deleteData(2);
        l2.deleteData(4);
        l2.printList();
    }
}


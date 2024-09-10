package Part02.Chapter02;

class CircularLinkedList {
    // 양방향이면서 연결 리스트

    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi newNodeBi = new NodeBi(data, null, null);
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        } else if (beforeData == null) {
            // 가장 끝 데이터 추가
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
            this.tail.next = newNodeBi;
            this.head.prev = newNodeBi;
            this.tail = newNodeBi;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;

            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
                        this.tail.next = newNodeBi;
                        this.head.prev = newNodeBi;
                        this.head = newNodeBi;
                    } else {
                        // 중간에 노드가 추가되는 경우
                        NodeBi newNodeBi = new NodeBi(data, cur, pre);
                        pre.next = newNodeBi;
                        cur.prev = newNodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur!= this.head);
        }
    }

    public void deleteData(int data) {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = cur.next;
                } else if (cur == this.tail) {
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.head;
        while (cur.next != this.head) {
            // cur != null 로 돌리면 원형 리스트라서 무한 루프에 돈다
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        // 가장 끝 노드는 출력이 안 돼서 따로 출력
        System.out.println(cur.data);
    }
}

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList {
    NodeBi head;
    NodeBi tail;

    DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) {
            this.tail.next = new NodeBi(data, null, this.tail);
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;

            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new NodeBi(data, this.head, null);
                        // 기존 head의 prev를 바뀐 head로 변경
                        this.head.next.prev = this.head;
                    } else {
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
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

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head){
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void printFromTail() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}

public class LinkedListPractice2 {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        DoublyLinkedList d = new DoublyLinkedList(new NodeBi(1, null, null));
        d.printList();

        d.addData(2, null);
        d.addData(3, null);
        d.addData(4, null);
        d.addData(5, null);
        d.printList();
        d.printFromTail();

        d.addData(100, 1);
        d.addData(200, 2);
        d.addData(300, 3);
        d.addData(400, 4);
        d.addData(500, 5);
        d.printList();
        d.printFromTail();

        d.deleteData(300);
        d.deleteData(100);
        d.deleteData(500);
        d.deleteData(200);
        d.deleteData(400);
        d.printList();
        d.printFromTail();

        d.deleteData(3);
        d.deleteData(1);
        d.deleteData(5);
        d.deleteData(2);
        d.deleteData(4);
        d.printList();
        d.printFromTail();
        System.out.println();

        System.out.println("Practice 2");
        CircularLinkedList c = new CircularLinkedList(new NodeBi(1, null, null));
        c.addData(2, null);
        c.addData(3, null);
        c.addData(4, null);
        c.addData(5, null);
        c.printList();

        c.addData(100, 1);
        c.addData(200, 2);
        c.addData(300, 3);
        c.addData(400, 4);
        c.addData(500, 5);
        c.printList();

        c.deleteData(300);
        c.deleteData(100);
        c.deleteData(500);
        c.deleteData(200);
        c.deleteData(400);
        c.printList();

        c.deleteData(3);
        c.deleteData(1);
        c.deleteData(5);
        c.deleteData(2);
        c.deleteData(4);
        c.printList();
    }
}


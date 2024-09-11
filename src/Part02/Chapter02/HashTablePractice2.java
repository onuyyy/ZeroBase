package Part02.Chapter02;

import java.util.*;
class HashNode {
    int key;
    int data;
    HashNode next;

    HashNode() {}
    HashNode(int key, int data, HashNode next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}
class LinkedListH {
    HashNode head;

    LinkedListH(HashNode node) {
        this.head = node;
    }

    LinkedListH() {
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int key, int data) {
        if (this.head == null) {
            this.head = new HashNode(key, data, null);
        } else {
            HashNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new HashNode(key, data, null);
        }
    }

    public void deleteData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        // 삭제할 대상을 cur로 잡아두고, 그 전의 Node의 next를 null 만들어야
        // 하기 때문에 prev 에 cur 담는다
        HashNode cur = this.head;
        HashNode prev = cur;

        while (cur != null) {
            if (cur.key == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
        }
    }

    public Integer findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return null;
        }

        HashNode cur = this.head;
        while (cur != null) {
            if (cur.key == data) {
                System.out.println("Data exist");
                return cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
        return null;
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        HashNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class MyHashTable5 {
    LinkedListH[] table;

    MyHashTable5(int size) {
        this.table = new LinkedListH[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedListH(null);
        }
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        this.table[idx].addData(key, data);
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeData(int key) {
        int idx = this.getHash(key);

        this.table[idx].deleteData(key);
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i + " : ");
            this.table[i].printList();
        }
    }
}

class MyHashTable4 extends MyHashTable {

    int c;

    // 개방 주소법 > 이중 해싱
    MyHashTable4(int size) {
        super(size);
        this.c = this.getHashC(size);
    }

    public int getHashC(int size) {
        int c = 0;
        
        if (size <= 2) {
            return size;
        }

        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                c = i;
                break;
            }
        }
        return c;
    }
    
    public int getHash2(int key) {
        // c 값은 일반적으로 해쉬테이블의 크기보다 조금 작은 소수이다
        // 소수 : 1과 자기 자신으로만 나눠지는 수
        int hash = 1 + key % this.c;

        return hash;
    }
    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            // 이중 해싱 : 얼만큼 움직일까?
            int newIdx = idx;
            int cnt = 1;
            while (true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}

class MyHashTable3 extends MyHashTable {

    // 개방 주소법 -> 제곱 탐사법

    MyHashTable3(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is Full");
            return;
        } else if (this.table[idx] == null) {
            table[idx] = data;
        } else {
            // 충돌 상황
            int newIdx = idx;
            // 충돌 몇 번인지 세는 변수
            int cnt = 0;
            while (true) {
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                // 충돌이 났을 때마다 제곱 수 구하기 위해 cnt++
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}

public class HashTablePractice2 {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        MyHashTable3 m = new MyHashTable3(11);
        m.setValue(1, 10);
        m.setValue(2, 20);
        m.setValue(4, 40);
        m.printHashTable();

        m.setValue(1, 100);
        m.printHashTable();

        m.setValue(1, 200);
        m.setValue(1, 300);
        m.setValue(1, 400);
        m.printHashTable();
        System.out.println();

        System.out.println("Practice 2");
        MyHashTable4 m2 = new MyHashTable4(11);
        m2.setValue(1, 10);
        m2.setValue(2, 20);
        m2.setValue(3, 30);
        m2.printHashTable();

        m2.setValue(1, 100);
        m2.setValue(1, 200);
        m2.setValue(1, 300);
        m2.printHashTable();
        System.out.println();

        System.out.println("Practice 3");
        MyHashTable5 m3 = new MyHashTable5(11);
        m3.setValue(1, 10);
        m3.setValue(2, 20);
        m3.setValue(3, 30);
        m3.printHashTable();
        m3.setValue(12, 11);
        m3.setValue(23, 12);
        m3.setValue(34, 13);

        m3.setValue(13, 21);
        m3.setValue(24, 22);
        m3.setValue(35, 23);

        m3.setValue(5, 1);
        m3.setValue(16, 2);
        m3.setValue(27, 3);
        m3.printHashTable();

        System.out.println("Key 값으로 해당 데이터 가져오기");
        System.out.println(m3.getValue(1));
        System.out.println(m3.getValue(12));

        System.out.println("데이터 삭제");
        m3.removeData(1);
        m3.removeData(5);
        m3.removeData(16);
        m3.printHashTable();
    }
}

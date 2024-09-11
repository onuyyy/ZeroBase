package Part02.Chapter02;

import java.util.Hashtable;
import java.util.Map;

class MyHashTable2 extends MyHashTable {
    MyHashTable2(int size) {
        super(size);
    }

    // 선형탐사법
    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            // 해당 위치의 어떤 데이터가 들어가 있을 때
            // 충돌 지점
            int newIdx = idx;
            while (true) {
                newIdx = (newIdx + 1) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt++;
    }
}

class MyHashTable {
    Integer[] table;
    int elemCnt;

    MyHashTable() {}
    MyHashTable(int size) {
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        // 해시 값(index) 구하기
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elemCnt++;
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key) {
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + " : " + this.table[i]);;
        }
    }
}
public class HashTablePractice {

    // 해시 함수
    public static int getHash(int key) {
        return key % 5;
    }
    public static void main(String[] args) {
        // 기본 해시 테이블 사용 방법
        Hashtable<String, Integer> ht = new Hashtable<>();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);

        // 충돌 만들어 보기
        ht.put("key3", 50); // 값 50으로 바뀜

        // hashtable은 map 인터페이스를 통하여 만든 거기 때문에
        // key 값 대응하는 entry들을 뽑아주는데 타입을 맞추기 위해
        for (Map.Entry<String, Integer> item : ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }


        // 해시 충돌 케이스 (해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable<>();
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("충돌 전");
        for (Map.Entry<Integer, Integer> i : ht2.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
        }

        ht2.put(getHash(6), 60);
        System.out.println("충돌 후");
        for (Map.Entry<Integer, Integer> i : ht2.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
        }

        System.out.println();
        System.out.println("Practice 1");
        MyHashTable m = new MyHashTable(7);
        m.setValue(1, 10);
        m.setValue(2, 20);
        m.setValue(3, 30);
        m.setValue(4, 40);
        m.setValue(5, 50);
        m.printHashTable();
        m.setValue(8, 60); // 해시 충돌 발생
        m.printHashTable();
        System.out.println();

        System.out.println();
        System.out.println("Practice 2");
        MyHashTable2 m2 = new MyHashTable2(5);
        m2.setValue(1, 10);
        m2.setValue(3, 30);
        m2.printHashTable();

        m2.setValue(1, 100);
        m2.printHashTable();

        m2.setValue(1, 20);
        m2.setValue(1, 30);
        m2.setValue(1, 40);
        m2.printHashTable();
    }
}

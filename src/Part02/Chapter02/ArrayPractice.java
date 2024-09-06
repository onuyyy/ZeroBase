package Part02.Chapter02;

import java.util.Arrays;

class MyArray {
    int[] arr;

    MyArray(int size) {
        this.arr = new int[size];
    }

    public void insertData(int index, int data) {
        if (index < 0 || index > this.arr.length) {
            System.out.println("index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }

    public void removeData(int data) {
        int[] arrDup = this.arr.clone();
        int targetIdx = -1;

        for (int i = 0; i < this.arr.length; i++) {
            if (data == this.arr[i]) {
                targetIdx = i;
                break;
            }
        }

        if (targetIdx == -1) {
            System.out.println("Data not Found");
            return;
        } else {
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIdx; i++) {
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIdx; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }
}
public class ArrayPractice {
    public static void main(String[] args) {

        int size = 5;
        MyArray m = new MyArray(size);

        for (int i = 0; i < size; i++) {
            m.arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(m.arr));

        m.arr[0] = 10;
        System.out.println(Arrays.toString(m.arr));

        m.insertData(2, 20);
        System.out.println(Arrays.toString(m.arr));

        m.insertData(6, 60);
        System.out.println(Arrays.toString(m.arr));

        m.insertData(-1, 0);

        m.removeData(4);
        System.out.println(Arrays.toString(m.arr));

        m.removeData(5);
        System.out.println(Arrays.toString(m.arr));

        m.removeData(99);
    }
}

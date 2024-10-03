package Part02.Chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class MySet {
    ArrayList<Integer> list;

    MySet() {
        this.list = new ArrayList<Integer>();
    }
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item : arr) {
            this.list.add(item);
        }
    }

    public String toString() {
        return "list" + list;
    }
    // 원소 추가 (중복 x)
    public void add(int x) {
        for (int i : this.list) {
            if (i == x) {
                return;
            }
        }
        this.list.add(x);
    }

    // 교집합
    public MySet retainAll(MySet b) {
        // 교집합된 집합을 새로 반환하는 함수
        MySet result = new MySet();

        for (int iA : this.list) {
            for (int iB : b.list) {
                if (iA == iB) {
                    // 같은 데이터들만 새로 만들어둔 result에 넣는다
                    result.add(iA);
                }
            }
        }
        return result;
    }

    // 합집합
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int iA : this.list) {
            result.add(iA);
        }

        for (int iB : b.list) {
            result.add(iB);
        }
        return result;
    }

    // 차집합
    public MySet removeAll(MySet b) {
        MySet result = new MySet();

        for (int iA : this.list) {
            boolean containFlag = false;

            for (int iB : b.list) {
                if (iA == iB) {
                    // 같은 값을 찾았으면
                    containFlag = true;
                    break;
                }
            }
            if (!containFlag) {
                result.add(iA);
            }
        }
        return result;
    }
}

public class BasicMath {
    public static void main(String[] args) {

        // 자바에서 집합 사용
        System.out.println("HashSet");
        HashSet set1 = new HashSet();
        // HashSet은 중복 값 허용 x
        // 삭제시 인덱스가 아닌 값을 삭제
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2));

        System.out.println("집합 연산");

        // 교집합
        HashSet a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet b = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
        // a에 공통 원소만 남도록 한다
        // a.retainAll(b);
        System.out.println("교집합 a (retainAll) = " + a); // 2, 4

        // 합집합
        //a.addAll(b);
        System.out.println("합집합 a (addAll) = " + a);
        
        // 차집합
        a.removeAll(b);
        System.out.println("차집합 a (removeAll) = " + a);
        System.out.println();

        System.out.println("Practice MySet");
        MySet m = new MySet();

        m.add(1);
        m.add(1);
        m.add(1);
        System.out.println(m.list);
        m.add(2);
        m.add(3);
        System.out.println(m.list);

        m = new MySet(new int[]{1,2,3,4,5});
        MySet n = new MySet(new int[]{2,4,6,8,10});
        System.out.println("m = " + m);
        System.out.println("n = " + n);

        MySet result = m.retainAll(n);
        System.out.println("교집합 : " + result.list);

        result = m.addAll(n);
        System.out.println("합집합 : " + result.list);

        result = m.removeAll(n);
        System.out.println("차집합 : " + result.list);
    }
}

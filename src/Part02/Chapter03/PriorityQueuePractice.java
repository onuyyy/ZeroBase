package Part02.Chapter03;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        // 어떤 기준을 통하여 비교할지 구현한다
        // return 1 > 변경 안 함
        // return -1 > 변경 함

        // compareTo는 반드시 정수값을 반환해야 한다
        // return 값에 따라 객체의 정렬 순서가 정해진다
        // 음수 : 현재 객체가 정렬 시 앞쪽에 위치
        // 0 : 현재 객체와 비교 대상 객체가 같다
        // 양수 : 현재 객체가 정렬 시 뒤쪽에 위치

        // 새롭게 추가하는 데이터가 더 작을 때 변경 (작은 값이 위로 올라감 : 오름차순)
        //return this.age >= o.age ? 1 : -1;

        // 내림차순일 경우 (큰 값이 위로 올라감)
        return this.age >= o.age? -1 : 1;
    }
}
public class PriorityQueuePractice {
    public static void solution2(String[] name, int[] age) {
        // 오름차순으로 구성하기
        PriorityQueue<Person2> pq = new PriorityQueue<>(
                (Person2 p1, Person2 p2) -> p1.name.compareTo(p2.name));

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person2(name[i], age[i]));
        }

        while (!pq.isEmpty()) {
            Person2 p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
    public static void solution(String[] name, int[] age) {
    /*
        자바 기본 우선순위 큐 응용하여
        나이 순으로 오름차순 또는 내림차순 출력
     */
        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }

        System.out.println("실제 출력 순서");
        while (!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
    public static void enqueue(LinkedList<Integer> list, int data) {
        // 값이 작으면 연결리스트에서 앞 쪽에 추가를 한다
        // list.size > 가장 끝 인덱스를 반다 온다
        int idx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > data) {
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {

        System.out.println("연결리스트 방식의 우선순위 큐");
        LinkedList<Integer> list = new LinkedList<>();
        // 작은 값일수록 우선순위가 높다는 가정
        enqueue(list,5);
        enqueue(list,7);
        enqueue(list,3);
        enqueue(list,1);
        enqueue(list,9);
        System.out.println(list);

        System.out.println(dequeue(list));
        System.out.println(dequeue(list));
        System.out.println(list);
        System.out.println();

        System.out.println("JAVA 기본 우선순위 큐");
        // 우선 순위 : 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(pq);

        // 순서를 바꾸고 싶다면?
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(pq2);

        System.out.println();

        System.out.println("Solution 1");
        String[] name = {"A","B","C","D","E"};
        int[] age = {30,20,45,62,35};
        solution(name, age);

        System.out.println();

        // interface 상속 없이 구현하는 방법
        // 객체를 만들어줄 때 비교 조건을 넘겨준다 (람다식으로 넘기는 방법)
        PriorityQueue<Person2> pq3 = new PriorityQueue<>(
                (Person2 p1, Person2 p2) -> p1.age >= p2.age ? -1 : 1);

        for (int i = 0; i < name.length; i++) {
            pq3.offer(new Person2(name[i], age[i]));
        }

        while (!pq3.isEmpty()) {
            Person2 p =pq3.poll();
            System.out.println(p.name + " " + p.age);
        }

        System.out.println();

        System.out.println("Solution 2");
        solution2(name, age);
    }
}

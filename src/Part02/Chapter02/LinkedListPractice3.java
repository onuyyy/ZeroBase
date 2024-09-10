package Part02.Chapter02;

class LinkPrac3 extends LinkedList {
    public boolean findData2(int data) {

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        // System.out.println("Data not found");
        return false;
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
public class LinkedListPractice3 {
    public static boolean checkPalindrome(LinkedList list) {

        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while (cur != null) {
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = left;

            while (right.next != prevRight) {
                right = right.next;
            }
        }

        return true;
    }

    public static LinkPrac3 removeDup(LinkPrac3 listbefore) {

        /*
            단방향 연결 리스트에서 중복 데이터를 찾아 삭제
            입력 : 1 3 3 1 4 2 4 2
            출력 : 1 3 4 2
         */
        LinkPrac3 listAfter = new LinkPrac3();

        Node cur = listbefore.head;
        while (cur != null) {
            if (listAfter.findData2(cur.data) == false) {
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }
    public static void main(String[] args) {

        System.out.println("Practice 1");
        LinkPrac3 l = new LinkPrac3();
        l.addData(1);
        l.addData(3);
        l.addData(3);
        l.addData(1);
        l.addData(4);
        l.addData(2);
        l.addData(4);
        l.addData(2);
        l.printList();

        l = removeDup(l);
        l.printList();
        System.out.println();

        System.out.println("Practice 2");
        LinkedList l2 = new LinkedList();
        l2.addData(1);
        l2.addData(3);
        l2.addData(5);
        l2.addData(3);
        l2.addData(1);
        System.out.println(checkPalindrome(l2));
        System.out.println();

        LinkedList l3 = new LinkedList();
        l3.addData(3);
        l3.addData(5);
        l3.addData(5);
        l3.addData(3);
        System.out.println(checkPalindrome(l3));
        System.out.println();

        LinkedList l4 = new LinkedList();
        l4.addData(1);
        l4.addData(3);
        l4.addData(5);
        l4.addData(3);
        System.out.println(checkPalindrome(l4));
        System.out.println();
    }
}

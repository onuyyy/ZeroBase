package Part02.Chapter03;
import java.util.*;

class Node2 {
    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
class BinaryTree2 {
    Node2 head;

    BinaryTree2(char[] arr) {
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
          nodes[i] = new Node2(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }
    public Node2 searchNode(char data) {
        Queue<Node2> queue = new LinkedList<>();

        queue.add(this.head);
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            if (cur.data == data) {
                return cur;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data) {
        Node2 node = this.searchNode(data);

        Queue<Node2> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                size++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }
}
class Node {
    char data;
    Node left;
    Node right;

    public Node (char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    Node head;

    BinaryTree() {}
    BinaryTree(char[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node node) {
        if(node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

}
public class TreePractice1 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }
        BinaryTree bt = new BinaryTree(arr);

        System.out.println("Preorder");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("Inorder");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("Postorder");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("Levelorder");
        bt.levelOrder(bt.head);
        System.out.println();



        System.out.println("Practice 2 ");
        BinaryTree2 bt2 = new BinaryTree2(arr);
        System.out.println("Root : " + bt2.head.data);

        System.out.println("B's Child Node");
        Node2 B = bt2.searchNode('B');
        if (B.left != null) {
            System.out.println("B -> left Child : " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B -> right Child : " + B.right.data);
        }

        System.out.println("F's Parent Node");
        Node2 F = bt2.searchNode('F');
        System.out.println("F -> parent : " + F.parent.data);

        System.out.println("Leaf Node");
        for (int i = 0; i < arr.length; i++) {
            Node2 cur = bt2.searchNode((char)('A' + i));

            if (cur.left == null && cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();

        System.out.println("E's Depth");
        Node2 E = bt2.searchNode('E');
        Node2 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E depth : " + cnt);

        System.out.println("Level 2 Node");
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt2.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if(cnt == 2) {
                System.out.print(target.data + " ");
            }
        }
        System.out.println();

        System.out.println("Height");
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt2.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Height : " + maxCnt);

        System.out.println("B's Size");
        int size = bt2.checkSize('B');
        System.out.println("B size : " + size);
    }
}



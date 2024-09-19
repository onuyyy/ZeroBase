package Part02.Chapter03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class MyGraphList2 extends MyGraphList {
    public MyGraphList2(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            NodeG cur = this.adjList[curId];
            while (cur != null) {
                if (visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }

                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            NodeG cur = this.adjList[curId];
            while (cur != null) {
                if (visited[cur.id] == false) {
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}
class MyGraphMatrix2 extends MyGraphMatrix {
    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0; i--) {
                if (this.adjMat[curId][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0; i--) {
                if (this.adjMat[curId][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

class NodeG {
    int id;
    NodeG next;
    public NodeG(int id, NodeG next) {
        this.id = id;
        this.next = next;
    }
}
class MyGraphList {
    char[] vertices;
    NodeG[] adjList;
    int elemCnt;

    public MyGraphList() {}
    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new NodeG[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjList[x] = new NodeG(y, this.adjList[x]);
        this.adjList[y] = new NodeG(x, this.adjList[y]);
    }

    public void addDirectedEdge(int x, int y) {
        this.adjList[x] = new NodeG(y, this.adjList[x]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " : ");

            NodeG cur = this.adjList[i];
            while (cur != null) {
                System.out.print(this.vertices[cur.id]+ " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
class MyGraphMatrix {
    char[] vertices;
    int[][] adjMat;
    // 정점의 개수 체크
    int elemCnt;

    MyGraphMatrix() {}
    MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        // 무방향 그래프
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    public void addDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char i : this.vertices) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class GraphPractice {
    public static void main(String[] args) {

        System.out.println("인접 행렬을 이용한 그래프");
        MyGraphMatrix m = new MyGraphMatrix(4);
        m.addVertex('A');
        m.addVertex('B');
        m.addVertex('C');
        m.addVertex('D');

        m.addEdge(0, 1);
        m.addEdge(0, 2);
        m.addEdge(1, 2);
        m.addEdge(1, 3);
        m.addEdge(2, 3);
        m.printAdjacentMatrix();
        System.out.println();

        System.out.println("인접 리스트를 이용한 그래프");
        MyGraphList m2 = new MyGraphList(4);
        m2.addVertex('A');
        m2.addVertex('B');
        m2.addVertex('C');
        m2.addVertex('D');

        m2.addEdge(0, 1);
        m2.addEdge(0, 2);
        m2.addEdge(1, 2);
        m2.addEdge(1, 3);
        m2.addEdge(2, 3);
        m2.printAdjacentList();
        System.out.println();

        System.out.println("인접 행렬에서 dfs, bfs 탐색");
        MyGraphMatrix2 m3 = new MyGraphMatrix2(7);
        m3.addVertex('A');
        m3.addVertex('B');
        m3.addVertex('C');
        m3.addVertex('D');
        m3.addVertex('E');
        m3.addVertex('F');
        m3.addVertex('G');

        m3.addEdge(0, 1);
        m3.addEdge(0, 2);
        m3.addEdge(0, 3);
        m3.addEdge(1, 4);
        m3.addEdge(2, 5);
        m3.addEdge(3, 4);
        m3.addEdge(3, 5);
        m3.addEdge(4, 6);
        m3.addEdge(5, 6);
        m3.printAdjacentMatrix();
        System.out.println();

        m3.dfs(0);
        m3.bfs(0);
        System.out.println();

        System.out.println("인접 리스트에서 dfs, bfs 탐색");
        MyGraphList2 m4 = new MyGraphList2(7);
        m4.addVertex('A');
        m4.addVertex('B');
        m4.addVertex('C');
        m4.addVertex('D');
        m4.addVertex('E');
        m4.addVertex('F');
        m4.addVertex('G');

        m4.addEdge(0, 1);
        m4.addEdge(0, 2);
        m4.addEdge(0, 3);
        m4.addEdge(1, 4);
        m4.addEdge(2, 5);
        m4.addEdge(3, 4);
        m4.addEdge(3, 5);
        m4.addEdge(4, 6);
        m4.addEdge(5, 6);

        m4.dfs(0);
        m4.bfs(0);
    }
}


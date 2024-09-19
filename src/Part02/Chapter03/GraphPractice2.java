package Part02.Chapter03;

import java.util.ArrayList;
import java.util.Stack;

class MyGraphList3 {
    int[] vertices;
    NodeG[] adjList;
    int elemCnt;

    public MyGraphList3() {}
    public MyGraphList3(int size) {
        this.vertices = new int[size];
        this.adjList = new NodeG[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(int data) {
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
public class GraphPractice2 {

    public static void solution4(int[][] graph) {
        /*
            인접하지 않은 노드들끼리 그래프 분리가 가능한지 체크
            인접한 것들끼리 flag를 반대되게 만들어서 각 노드 돌면서 체크
         */

        int[] flags = new int[graph.length];

        if (checkSplit(graph, flags, 1, 0) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean checkSplit(int[][] graph, int[] flags, int flag, int node) {

        if (flags[node] != 0) {
            // 이미 방문해서 1 또는 -1로 체크가 되어있는 상태
            return flags[node] == flag;
        }

        flags[node] = flag;
        for (int adjacentNode : graph[node]) {
            if (!checkSplit(graph, flags, -flag, adjacentNode)) {
                return false;
            }
        }
        return true;
    }

    public static void solution3(int n, int[][] edges, int source, int dest) {
        /*
            그래프에서 시작 노드에서 끝 노드로 가는 길이 있는지 확인하는 프로그램

            노드 개수 = 3
            간선 정보 = {{0, 1}, {1, 2}, {2, 0}}
            출발 노드 = 0
            종착 노드 = 2
            출력 : true
         */
        MyGraphList3 g = new MyGraphList3(n);

        for (int i = 0; i < n; i++) {
            g.addVertex(i);
        }

        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        ArrayList<Integer> visitedItem = new ArrayList<>();
        dfs(g, 0, visitedItem);

        if (visitedItem.contains(source)&& visitedItem.contains(dest)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void dfs(MyGraphList3 graph, int id, ArrayList<Integer>visitiedItem) {
        boolean[] visited = new boolean[graph.vertices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();

            visitiedItem.add(curId);

            NodeG cur = graph.adjList[curId];
            while (cur != null) {
                if (visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }

    public static int solution(int[][] e) {
        // center node를 찾아라 > 모든 노드와 연결되어 있는 노드
        // 간선정보가 가장 많거나, 간성 정보는 노드수 - 1 이기때문에 이를 이용

        // 엣지 정보는 노드 수 - 1 만 있기 때문에 + 1 해서 만듦
        MyGraphMatrix g = new MyGraphMatrix(e.length + 1);

        for (int i = 0; i < e.length; i++) {
            // 인덱스 편하게 0부터 하려고 - 1
            g.addEdge(e[i][0] - 1, e[i][1] - 1);
        }

        int[] edgeCnt = new int[e.length + 1];
        for (int i = 0; i < g.adjMat.length; i++) {
            // 각 노드의 1이된 부분을 체크하면서 카운팅
            for (int j = 0; j < g.adjMat[i].length; j++) {
                if (g.adjMat[i][j] == 1) {
                    edgeCnt[i] += 1;
                }
            }
        }

        int maxCnt = -1;
        int maxIdx = -1;
        for (int i = 0; i < edgeCnt.length; i++) {
            if (maxCnt < edgeCnt[i]) {
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }

        return maxIdx + 1;
    }

    public static int solution2(int[][] e) {
        // 제약사항
        // 간선의 총 개수 : 노드의 개수 - 1
        // 모든 노드는 연결되어 있다
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }
    public static void main(String[] args) {

        System.out.println("Solution 1");
        int[][] edges= {{1, 2},{2, 3},{4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));

        edges = new int[][]{{1, 2},{5, 1},{1, 3},{1, 4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        System.out.println("Solution 3");
        int n = 3;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int dest = 2;
        solution3(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        source = 0;
        dest = 5;
        solution3(n, edges, source, dest);
        System.out.println();

        System.out.println("Solition 4");
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0,2}};
        solution4(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution4(graph);
    }
}


package Part02.Chapter04;

public class bellmanFordPractice {
    static class Edge {
        // 간선 정보 관리하기 위한 클래스
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellmanFordPractice(int v, int e, int[][] data, int start) {
        Edge[] edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        // 1번 노드부터 시작하기 위한 편의
        int[] dist = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean isMinusCycle = false;
        // 음수 사이클 체크를 위해 1번 더 돌린다 (v + 1)
        for (int i = 0; i < v + 1; i++) {
            // 간선에 대해 모두 체크해줘야 함
            for (int j = 0; j < e; j++) {
                Edge cur = edge[j];

                if (dist[cur.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    // 음수 사이클 발생 여부 체크
                    // 고정 된 값이어야 하는데 v + 1 했을 때 위 if문 타고 들어와서
                    // i == v가 된 거다
                    if (i == v) {
                        isMinusCycle = true;
                    }
                }
            }
        }

        System.out.println("음수 사이틀 발생 : " + isMinusCycle);
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
                       // 1 -> 2 : 가중치가 8
        int[][] data = {{1, 2, 8},{1, 3, 6},{1, 5, 5},{2, 3, -5},{2, 4, 1},
                {2, 6, 4},{3, 4, 4},{4, 7, 3},{5, 6, 5},{6, 2, 0}, {6, 7, -7}};
                       // 정점 7, 간선 수 11, 간선 정보, 시작 정점 1
        bellmanFordPractice(7, 11, data, 1);

        data = new int[][]{{1, 2, 8},{1, 3, 6},{1, 5, 5},{2, 3, -5},{2, 4, 1},
                {2, 6, 4},{3, 4, 4},{4, 7, 3},{5, 6, 5},{6, 2, -5}, {6, 7, -7}};
        bellmanFordPractice(7, 11, data, 1);
    }
}

package Part02.Chapter04;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraPractice2 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void dijkstra(int v, int[][] data, int start) {
        // 다익스트라 기본 구현
        ArrayList<ArrayList<DijkstraPractice.Node>> graph = new ArrayList<>();
        // 인덱스 1부터 쓰기 위해
        for (int i = 0; i < v + 1; i++) {
            // 객체 생성
            graph.add(new ArrayList<>());
        }

        // 간선정보 만큼 돌기
        for (int i = 0; i < data.length; i++) {
            // 시작 위치에 대한 노드에 대해서 더해주기
            graph.get(data[i][0]).add(new DijkstraPractice.Node(data[i][1], data[i][2]));
            // {1, 2, 3} 이면 위에서 ArrayList 객체 만든 걸 get 해와서
            // add하여 2, 3이라는 정보를 넣는다
        }

        // 최단 거리 기록할 메모리
        int[] dist = new int[v + 1];
        // 초기화를 해준다 (max 값으로 초기화를 해준다) > 최단 경로로 계속 업데이트할 것임
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 자기 자신의 거리 값은 0이니까
        dist[start] = 0;

        // 우선순위 큐 형태로 만들기
        // 최서 간선에 대한 정보를 매번 탐색할 필요 없음
        // 이미 minWeight로 정렬되어 있으니까
        PriorityQueue<DijkstraPractice.Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new DijkstraPractice.Node(start, 0));

        while (!pq.isEmpty()) {
            DijkstraPractice.Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                DijkstraPractice.Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new DijkstraPractice.Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 출력하기
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // MAX VALUE로 남아 있는 것들은 해당 경로 없는 것
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();


    }
    public static void main(String[] args) {
        System.out.println("Practice 1");
        // 1->2 로 3이 필요하다는 뜻
        int[][] data = {{1, 2, 2},{1, 3, 3},{2, 3, 4},{2, 4, 5},{3, 4, 6},{5, 1, 1}};
        dijkstra(5, data, 1);
        System.out.println();

    }
}

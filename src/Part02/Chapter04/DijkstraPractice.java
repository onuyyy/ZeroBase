package Part02.Chapter04;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraPractice {
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
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 인덱스 1부터 쓰기 위해
        for (int i = 0; i < v + 1; i++) {
            // 객체 생성
            graph.add(new ArrayList<>());
        }

        // 간선정보 만큼 돌기
        for (int i = 0; i < data.length; i++) {
            // 시작 위치에 대한 노드에 대해서 더해주기
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
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

        // 방문한 값으로 더이상 진행하지 않기 위한 방문 배열 만들기
        boolean[] visited = new boolean[v + 1];

        // 모든 노드를 탐색하면서 거리 정보를 업데이트
        for (int i = 0; i < v; i++) {
            // 가장 낮은 간선 정보를 찾기 위한 임시 변수
            int minDist = Integer.MAX_VALUE;
            // 현재 노드에 대한 정보
            int curIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    // 최소 정보를 갖고 있는 노드로 업데이트
                    minDist = dist[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true;

            // 선택된 노드의 인접 노드에 대한 거리를 갱신
            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node adjNode = graph.get(curIdx).get(j);
                if (dist[adjNode.to] > dist[curIdx] + adjNode.weight) {
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
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

package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_24174_MinHeap {
    public static int cnt = 0;
    public static int k = 0;
    public static boolean checkFlag = false;
    public static void heap_sort(int[] arr) {
        int n = arr.length;
        // 배열을 최소 힙으로 변환
        build_min_heap(arr, n);
        for (int i = n - 1; i >= 1; i--) {
            // 루트와 마지막 원소 교환
            swap(arr, 0, i);
            // 마지막 원소 제외하고 힙 정렬
            heapify(arr, 0, i - 1);
        }
    }

    public static void build_min_heap(int[] arr, int n) {
        // 마지막 부모 노드부터 루트 노드까지 역순으로 heapify
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n - 1);
        }
    }

    public static void heapify(int[] arr, int k, int n) {
        int left = k * 2 + 1;
        int right = k * 2 + 2;
        int smaller = 0;
        if (right <= n) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (arr[smaller] < arr[k]) {
            swap(arr, k, smaller);
            heapify(arr, smaller, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        cnt++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        if (cnt == k) {
            checkFlag = true;
            StringBuilder sb = new StringBuilder();
            for (int l = 0; l < arr.length; l++) {
                sb.append(arr[l] + " ");
            }
            System.out.println(sb.toString());
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        try {
            heap_sort(arr);
        } catch (RuntimeException e) {

        }

        if (!checkFlag) System.out.println(-1);

        br.close();
    }
}

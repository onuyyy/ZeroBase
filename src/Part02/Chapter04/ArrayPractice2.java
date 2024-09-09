package Part02.Chapter04;

import java.util.Arrays;

public class ArrayPractice2 {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }

            while (arr[i] <= pivot && i < j) {
                i++;
            }

            swap(arr, i, j);
        }

        swap(arr, left, i);

        return i;
    }

    public static void heapSort(int[] arr) {
        // 자식 노드가 있는 것들만 구함
        // 3,5,2,7,1,4,6 중 > 3,5,2만 자식노드가 있기 때문에
        // 6 / 2 - 1 = 2 // 2 index까지
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }

        // 7 6 4 5 1 3 2 로 max heap으로 정렬을 된 상태
        // 7을 제일 끝 자리로 보내고 6 4 5 1 3 2
        // 다시 heapify를 호출하는 형식으로 계속 뒤로 보낸다
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }

    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        int leftIdx = parentIdx * 2 + 1;
        int rightIdx = parentIdx * 2 + 2;
        int maxIdx = parentIdx;

        if (leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        if (rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        if (parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        // tmp 배열 쪽 인덱스로 사용하기 위함 idx
        int idx = p;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) {
                tmp[idx++] = arr[p++];
            } else {
                // 우측만 남았을 때
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp,0,arr.length - 1);
        System.out.println("합병 정렬 : " + Arrays.toString(arr));
        System.out.println();

        arr = new int[]{3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬 : " + Arrays.toString(arr));
        System.out.println();

        arr = new int[]{6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬 : " + Arrays.toString(arr));
    }
}

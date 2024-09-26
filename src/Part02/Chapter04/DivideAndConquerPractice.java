package Part02.Chapter04;

public class DivideAndConquerPractice {

    public static int solution1(int[] nums) {
        /*
            연속된 부분 배열의 합 중 가장 큰 값 출력 (부분 구간의 합을 의미함)
            조건을 붙이면 너무 많아서 다 쪼개서 다 구해본다
            이럴 때 쓰는 것이 분할 정복

            nums : -5, 0, -3, 4, -1, 3, 1, -5, 8
            출력 : 10

            nums : 5 ,4 ,0, 7, 8
            출력 : 24
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return divide(nums, 0, nums.length -1);
    }

    public static int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        // 오버플로우 방지
        int mid = left + (right - left) / 2;
        
        // 좌우측 최대 값 구하기
        int maxLeft = divide(nums, left, mid);
        int maxRight = divide(nums, mid + 1, right);

        int maxArr = getMaxSubArray(nums, left, mid, right);
        
        return Math.max(maxLeft, Math.max(maxRight, maxArr));
    }

    public static int getMaxSubArray(int[] nums, int left, int mid, int right) {
        int sumLeft = 0;
        int maxLeft = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft, sumLeft);
        }

        int sumRight = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sumRight += nums[i];
            maxRight = Math.max(maxRight, sumRight);
        }
        return maxLeft + maxRight;
    }

    public static int getMax(int[] arr, int left, int right) {
        int m = (left + right) / 2;

        // 탈출 조건 재귀함수
        if(left == right) {
            return arr[left];
        }

        left = getMax(arr, left, m);
        right = getMax(arr, m + 1, right);

        return (left > right) ? left : right;
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 10, 50, 25, 30, 1, 15};
        System.out.println(getMax(arr, 0, arr.length - 1));
        System.out.println();

        System.out.println("Solution 1");
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution1(nums));
        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(solution1(nums));
        System.out.println();

        System.out.println("Solution 2");
    }
}

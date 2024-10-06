package Programmers;

public class 배열에서중복된숫자찾기 {
    static int solution3(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] == nums[j]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,5,6,3,2,6,6};
        System.out.println(solution3(arr));
    }
}

public class demo {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        twoSum(nums, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int a, b, temp;
        int[] aaa = {1, 2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target && i != j) {
                    aaa[0] = i;
                    aaa[1] = j;
                    System.out.println(aaa[0] + ";" + aaa[1]);
                    return aaa;
                }
            }
        }
        return aaa;
    }
}

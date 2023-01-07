package array;

import java.util.HashMap;

/**
 *给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class ArrayTest003 {

    private HashMap<Integer, Integer> tempHash = new HashMap<>();

    public int[] solution(int[] nums,int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            if (null != tempHash.get(target - nums[i])) {
                result[0] = i;
                result[1] = tempHash.get(target - nums[i]);
                break;
            } else {
                tempHash.put(nums[i], i);
            }

        }
        return result;

    }


    public static void main(String[] args) {

        int[] nums=new int[]{2,7,11,15};
        int target = 18;

        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }

        int[] solution = new ArrayTest003().solution(nums, target);

        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }



    }
}

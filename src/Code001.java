/**
 * 乐扣001
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Code001 {

    public static void main(String[] args) {

        int nums[] = {2,5,5,11};
        int target = 10;
        int result[] = twoSum(nums, target);
        System.out.println(result[0]+"     "+result[1]);

    }


    public static  int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 1; i1 < nums.length; i1++) {
                if (target == (nums[i] + nums[i1])&&i!=i1) {
                    result[0] = i;
                    result[1] = i1;
                    return result;
                }
            }
        }

        return result;

    }
}
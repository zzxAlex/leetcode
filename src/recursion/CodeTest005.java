package recursion;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * https://www.bilibili.com/video/BV1eg411w7gn?p=9&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class CodeTest005 {

    private void  solution(int[] nums){
        // 一次遍历移动数据，二次遍历重置为0
        if (nums==null) {
            return;
        }
        int j=0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;

        }

    }

    private void solution2(int[] nums){

    }


    public static void main(String[] args) {

        int[] nums=new int[]{1,0,2,0,3,444,53,0,0};

        new CodeTest005().solution(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }
}

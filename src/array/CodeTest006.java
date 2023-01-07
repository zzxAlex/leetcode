package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1eg411w7gn?p=10&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 *
 * 给你一个含 n 个整数的数组 nums ，数据可重复，数组中有一个最大值max。请你找出所有在 [1, max] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 */
public class CodeTest006 {

    private List<Integer>  solution(int[] nums){

        HashSet<Integer> temp = new HashSet<Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
                temp.add(nums[i]);
        }
        int setSize= temp.size();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 1; i <=max; i++) {
            temp.add(i);
            if (temp.size()!=setSize) {
                ret.add(i);
                setSize++;
            }
        }

        return ret;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};

        List<Integer> solution = new CodeTest006().solution(nums);

        System.out.println(solution.toString());

    }
}

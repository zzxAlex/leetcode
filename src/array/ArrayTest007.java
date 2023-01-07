package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1eg411w7gn?p=10&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 */
public class ArrayTest007 {

    private List<Integer> solution(int[] nums) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        int max = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i], i);
        }

        for (int i = 1; i <= max; i++) {
            if (temp.get(i) == null) {
                ret.add(i);
            }

        }
        return ret;

    }

    private List<Integer> solution1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};

        List<Integer> solution = new ArrayTest007().solution(nums);

        System.out.println(solution.toString());

    }
}

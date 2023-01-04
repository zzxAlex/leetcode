package old; /**
 * code004算法补充 二分查找法的实现
 */

/**
 * 二分查找算法基本框架
 *
 * int binarySearch(int[] nums, int target) {
 *     int left = 0, right = ...;
 *
 *     while(...) {
 *         int mid = (right + left) / 2;
 *         if (nums[mid] == target) {
 *             ...
 *         } else if (nums[mid] < target) {
 *             left = ...
 *         } else if (nums[mid] > target) {
 *             right = ...
 *         }
 *     }
 *     return ...;
 * }
 */


public class Code004_001 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;//在[l...h]的范围里查找target
        while (l <= r ) {//当l==h时，区间[l...h]依然有效
            int mid = l + (r  - l) / 2;//(l+r)/2== l + (r  - l) / 2
            if (target > nums[mid]) {
                l = mid + 1;//target在区间[mid+1...r]中
            }
            if (target < nums[mid]) {
                r  = mid - 1;//target在区间[l...mid+1]中
            }
            if (target == nums[mid]) {//相等返回下标
                return mid;
            }
        }
        //没有查找到返回-1。
        return -l;
    }

    public static void main(String[] args) {
        int[] num={1,2,4,6,8,9};


        System.out.println(new Code004_001().searchInsert(num,8));
    }
}

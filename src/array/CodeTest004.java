package array;

/**
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * https://www.bilibili.com/video/BV1eg411w7gn?p=8&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 * <p>
 * 双指针交换
 */
public class CodeTest004 {

    public void solution(int[] nums1, int[] nums2, int m, int n) {

        int[] temp = new int[m + n];
        int k = m + n;

        for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
            if (nums1Index >= m) {
                temp[index] = nums2[nums2Index];
                nums2Index++;
            } else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index];
                nums1Index++;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[index] = nums1[nums1Index];
                nums1Index++;
            } else {
                temp[index] = nums2[nums2Index];
                nums2Index++;
            }
        }

        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }

    }

    /**
     * 倒序节省空间
     * @param nums1
     * @param nums2
     * @param m
     * @param n
     */
    public void solution2(int[] nums1, int[] nums2, int m, int n) {

        int k = m + n;

        for (int index = k-1, nums1Index = m-1, nums2Index = n-1; index >= 0; index--) {
            if (nums1Index  <0) {
                nums1[index] = nums2[nums2Index];
                nums2Index--;
            } else if (nums2Index <0 ) {
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index];
                nums1Index--;
            } else {
                nums1[index] = nums2[nums2Index];
                nums2Index--;
            }
        }

    }


    public static void main(String[] args) {
        int[] ms = new int[]{1, 2, 3, 0, 0, 0};
        int[] ns = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

//        new CodeTest004().solution(ms, ns, m, n);
        new CodeTest004().solution2(ms, ns, m, n);

        for (int i = 0; i < ms.length; i++) {
            System.out.println(ms[i]);
        }


    }
}

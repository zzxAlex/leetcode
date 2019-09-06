/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 *
 *
 * 思路，标记当前字符所在位置，重复时数值更新，不重复时，字符增加
 */



public class Code003 {



    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;//
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);

    }

    public static void main(String[] args) {
        String s = "pwwkkeew";

        System.out.println("最短字符串长度为： "+new Code003().lengthOfLongestSubstring(s));
    }

}

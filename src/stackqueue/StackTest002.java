package stackqueue;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * https://www.bilibili.com/video/BV1eg411w7gn?p=22&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class StackTest002 {

    private String solution(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
             if (Character.isDigit(chars[i])) {
                countStack.push(Integer.valueOf(chars[i]));
            } else if (chars[i] == '[') {
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int multi = 0;
        int c = 2;
        multi=multi*10+c-'0';
        System.out.println(multi);
    }
}

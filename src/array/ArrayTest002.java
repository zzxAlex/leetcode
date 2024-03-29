package array;

import java.util.HashMap;

/**
 * 斐波那契数列
 *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * https://www.bilibili.com/video/BV1eg411w7gn?p=6&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class ArrayTest002 {
    private HashMap<Integer, Integer> tempMap = new HashMap<>();
    public int solution1(int n){
        if (n==0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre1 = 0;
        int pre2 = 1;
        int result = 0;

        for (int i = 2; i <=n ; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;

        }
        return result;
    }

    public int solution2(int n){
        if (n==0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (null != tempMap.get(n)) {
            return tempMap.get(n);
        } else {
            int result = solution2(n - 1) + solution2(n - 2);
            tempMap.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {

        System.out.println(new ArrayTest002().solution1(5));
        System.out.println(new ArrayTest002().solution2(5));
    }
}

package array;

import java.util.HashMap;

/**
 * 爬楼梯
 * <p>
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * https://www.bilibili.com/video/BV1eg411w7gn?p=5&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 * <p>
 * 多次求解，单次递归，中间值保存
 */
public class CodeTest001 {
    private HashMap<Integer, Integer> tempMap = new HashMap<>();

    public int solution1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (null != tempMap.get(n)) {
            return tempMap.get(n);
        } else {
            int result = solution1(n - 1) + solution1(n - 2);
            tempMap.put(n, result);
            return result;
        }
    }

    public int solution2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre1 = 1;
        int pre2 = 2;
        int result = 0;
        for (int i = 3; i <=n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    public static void main(String[] args) {


        System.out.println(new CodeTest001().solution1(20));

        System.out.println(new CodeTest001().solution2(20));


    }
}

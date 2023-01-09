package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 快速排序代码实现
 */
public class QuickTest {


    public static void sort(int[] a) {
        if (a.length > 0) {
            sort(a, 0, a.length - 1);
        }

    }


    public static void sort(int[] a, int low, int height) {
        int l = low;
        int r = height;

        if (l > r) {    //放在k之前，防止下标越界
            return;
        }
        int k = a[l];

        while (l < r) {
            while (l < r && a[r] > k) {//找出小的数
                r--;
            }
            while (l < r && a[l] <= k) {  //找出大的数
                l++;
            }
            if (l < r) {   //交换
                int swap = a[l];
                a[l] = a[r];
                a[r] = swap;
            }

        }
        //交换K
        k = a[l];
        a[l] = a[low];
        a[low] = k;

        //对左边进行排序,递归算法
        sort(a, low, l - 1);
        //对右边进行排序
        sort(a, l + 1, height);
    }


    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 7, 4};
        int[] arr1 = new int[11];
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

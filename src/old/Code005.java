package old;

/**
 * 给定一个正整数，返回对应二进制数的1的个数
 */

public class Code005 {


    public static String NumberOf1(int n) {

        String s="";
        while(n>0){
            s=n%2+s;
            n=n/2;
        }
        return s;

    }

    static int count1num(int n) {
        int count;
        for (count = 0; n > 0; count++) {    //每次将最后右端的1转换成0，循环统计1的个数
            n =n& (n - 1);    //位运算
        }
        return count;
    }


    public static void main(String[] args) {

        int n = 10;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(Code005.NumberOf1(n));
        System.out.println(Code005.count1num(5));


    }

}

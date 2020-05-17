package Week_04;
/*
题目：实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
示例 1:
输入: 4
输出: 2
示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
*/
import java.util.LinkedList;

public class mySqrt069 {
    public static void main (String[] args) {

    }
}

//思路：二分法，用“排除法”在有限的区间里，一次排除一半的区间元素，最后只剩下一个数，这个数就是题目要求的向下取整的平方根整数
//>>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
//4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
//>>>：无符号右移。无论是正数还是负数，高位通通补0。
//对于正数而言，>>和>>>没区别。
//对于负数而言，-2 >>> 1，结果是2147483647（Integer.MAX_VALUE），-1 >>> 1，结果是2147483647（Integer.MAX_VALUE）。

class Solution {
    public int mySqrt(int x) {
        //定义左右边界，再二分查找
        long left = 0;
        long right = Integer.MAX_VALUE;
        long mid;
        while(left < right){
            mid = (left + right + 1)>>>1;
            long square = mid * mid;
            if(square > x) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)left ;
    }
}
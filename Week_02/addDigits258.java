package Week_02;

import java.util.ArrayList;
import java.util.List;

/*
题目：写给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
示例:
输入: 38
输出: 2 
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
进阶:
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

*/
public class addDigits258 {
    private static void main(String args[]) {

    }
}
//对原数做一个 f 操作，也就是各个位上的数相加，然后不停的做 f 操作，最终的结果对 9 取余和原数 x 对 9 取余是相等的。
//不考虑 0这种特殊情况，不停的做 f 操作，最终得到的数就是 1 - 9，对 9取余的结果是 1 - 8 和 0。结果是 0 的话对应数根就是 9，其他情况的数根就是取余结果。
//https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/
// 时间复杂度：
// 空间复杂度：
class solution1 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}

//递归操作
class solution2 {
    public int addDigits(int num) {
        
        if(num % 10 == num ){
            return num;
        }
        int i = 0;
        while(num != 0 ){
            i += num%10;
            num /= 10;
        }
        return addDigits(i); 
    }
}
package Week_08;
/*
题目：给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
示例 1:
输入: 1
输出: true
解释: 20 = 1
示例 2:
输入: 16
输出: true
解释: 24 = 16
示例 3:
输入: 218
输出: false
*/

public class isPowerOfTwo231 {
    public static void main (String[] args) {

    }
}

//恒有 n & (n - 1) == 0，这是因为：
//nn 二进制最高位为 11，其余所有位为 00；
//n - 1n−1 二进制最高位为 00，其余所有位为 11；
//一定满足 n > 0。
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 &&(n&(n-1)) ==0;
    }
}
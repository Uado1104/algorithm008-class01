package Week_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

java.util.HashMap;
/*
有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
示例 1:
输入: k = 5
输出: 9

*/

public class getKthMagicNumber1709 {
    private static void main(String args[]) {
        String s = { 1, 2, 3, 4 };
        String t = { 2, 3, 4 };
        solution1 a = new intersect(s, t);
        return a;
    }
}
//动态规划
class solution1 {
    public int getKthMagicNumber(int k) {
        int p3 = 0,p5 = 0,p7 = 0;
        int[] dp = new int[k];
        dp[0] =1;
        for (int i = 1;i<k;i++){
            dp[i] = Math.min(dp[p3]*3, Math.min(dp[p5]*5, dp[p7]*7));
            if (dp[i]==dp[p3]*3)p3++;
            if (dp[i]==dp[p5]*5)p5++;
            if (dp[i]==dp[p7]*7)p7++;
        }
        return dp[k-1];
    }
}
//思路：动态规划
//1.定义三个指针p3,p5,p7，p3指向的数字永远乘3，p5指向的数字永远乘5，p7指向的数字永远乘7
//2.初始化所有指针都指向第一个丑数，即1
//3.我们从dp[p3]*3,dp[p5]*5,dp[p7]*7选取最小的一个数字，作为新的丑数。这边新的丑数就是3*dp[p3]=3*1=3，然后p3++
//4.此时p5和p7指向第1个丑数，p3指向第2个丑数。然后重复上一步
//5.这里基于的一个事实是，丑数数列是递增的，当p5指针在当前位置时，后面的数乘以5必然比前面的数乘以5大，所以下一个丑数必然是先考虑前面的数乘以5。
class solution2 {
    public int getKthMagicNumber(int k) {
        int p3= 0,p5= 0,p7 =0;
        int[] dp = new int[k];
        for(int i = 0;i<k;i++){
            dp[i] = Math.min(dp[p3]*3, Math.min(dp[p5]*5, dp[p7]*7));
            if(dp[i] == dp[p3]*3)p3++;
            if(dp[i] == dp[p5]*5)p5++;
            if(dp[i] == dp[p7]*7)p7++;
        }
        return dp[k-1];
    }
}
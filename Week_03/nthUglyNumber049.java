package Week_03;
/*
题目：我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  
1 是丑数。
n 不超过1690。
*/
public class nthUglyNumber049 {
    public static void main (String[] args) {
    }
}

//思路：n递增，三指针不断比较*2，*3，*5中最小的那个，最小的指针加一。

class Solution2020050801 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        int p2 = 0,p3= 0,p5 = 0;
        for (int i = 0;i<n;i++){
            res[i] = Math.min (res[p2]* 2,Math.min (res[p3] * 3,res[p5] * 5));
            if(res[i] == res[p2]* 2)p2++;
            else if(res[i] == res[p3]* 3)p3++;
            else if(res[i] == res[p5]* 5)p5++;
        }
        return res[n-1];
    }
}
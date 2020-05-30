package Week_06;
/*
题目：
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
求所能获得硬币的最大数量。
说明:
你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:
输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

public class maxCoins312{
    public static void main (String[] args) {

    }
}

//时间复杂度 : 由于是标准的二分查找，时间复杂度为O(\log(m n))
//空间复杂度 : O(1)。
//二分查找
class Solution20200526 {
    public int coinChange(int[] coins, int amount) {
        if(amount <1 )return 0;
        return coinChanges (coins,amount,new int[(amount)]);
    }
    private int coinChanges(int[] coins,int rem,int[] count{
        //递归终止条件
        if (rem < 0)return -1;
        if(rem == 0)return 0;
        if(count[rem-1]!= 0)return count[rem-1];
        int min = Integer.MAX_VALUE;
        //当前逻辑层
        for(int coin:coins){
            //下探到下一层
            int res = coinChanges (coins,rem - coin,count);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE)? -1:min;
        return coins[rem - 1];
    }
}
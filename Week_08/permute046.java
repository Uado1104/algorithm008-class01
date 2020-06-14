package Week_08;
/*
题目：给定一个没有重复
数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

import java.util.*;

public class permute046 {
    public static void main (String[] args) {

    }
}

//
class Solution20200609 {
    public List<List<Integer>> permute(int[] nums) {
        //特例
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<> (factorial (len));
        if(len == 0){
            return res;
        }
        int used = 0;
        Deque<Integer> path = new ArrayDeque<> ();
        dfs(nums,len,0,path,used,res);
        return res;
    }
    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private void dfs(int[] nums,int len,int depth,Deque<Integer> path,int used,List<List<Integer>> res){
        if(depth == len){
            res.add (new ArrayList<> (path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (((used >> i) & 1) == 0) {
                path.addLast(nums[i]);
                used ^= (1 << i);

                dfs(nums, len, depth + 1, path, used, res);
                used ^= (1 << i);
                path.removeLast();
            }
        }

    }
}
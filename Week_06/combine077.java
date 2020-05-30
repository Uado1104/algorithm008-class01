package Week_06;
/*
题目：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class combine077{
    public static void main (String[] args) {

    }
}

//时间复杂度：O(k*N!/(N-k)!/k!)
class Solution {
    //结果
    private List<List<Integer>> result = new ArrayList<> ();
    public List<List<Integer>> combine(int n, int k) {
        //判例
        if(n<= 0 || k <= 0 || n < k){
            return result;
        }
        //调用回溯
        find_combination(n,k,1,new Stack<> ());
        //返回结果
        return result;
    }
    private void find_combination(int n , int k ,int Index, Stack<Integer> p){
        //回溯边界
        if (p.size () == k ){
            result.add(new ArrayList<> (p));
        }
        //当前层处理
        for(int i = Index;i<n-(k-p.size ())+1;i++){
            p.push (i);
            //下探到下一层
            find_combination (n,k,i+1,p);
            //处理遗留数据
            p.pop ();
        }
    }
}
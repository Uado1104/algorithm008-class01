package Week_06;
/*
题目：给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

import java.util.*;

public class permuteUnique047{
    public static void main (String[] args) {

    }
}

//解决一个回溯问题，实际上就是一个决策树的遍历过程。一般来说，我们需要解决三个问题：
//路径：也就是已经做出的选择。
//选择列表：也就是你当前可以做的选择。
//结束条件：也就是到达决策树底层，无法再做选择的条件。
//在递归之前做选择，在递归之后撤销选择。
//由于本题需要返回所有不重复的全排列，有限制条件，所以需要进行剪枝。这里第一步先要给数组进行排序。
//首先，先要给nums进行排序，这样的做目的是方便剪枝
//其次，我们已经选择过的不需要再放进去了
//接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
class solution2020052301{
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        //首先给数组排序
        Arrays.sort(nums);
        findUnique(nums,new boolean[nums.length],new LinkedList<Integer>());
        return result;
    }
    public void findUnique(int[] nums, boolean[] visited,LinkedList<Integer> trace){
        //结束条件
        if(trace.size() == nums.length){
            result.add(new LinkedList(trace));
            return ;
        }
        //选择列表
        for(int i = 0; i<nums.length; i++){
            //其次，我们已经选择过的不需要再放进去了
            if(visited[i]) continue;
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]) break;
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums,visited,trace);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }
}


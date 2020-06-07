package Week_07;
/*
题目：定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal094{
    public static void main (String[] args) {

    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        mid(root,res);
        return res;
    }
    public void mid(TreeNode root,List<Integer> res){
        if(root != null){
            if(root != null){
                mid(root.left,res);
            }
            res.add(root.val);
            if(root != null){
                mid(root.right,res);
            }
        }
    }
}
class TreeNode {
   int val;
 TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
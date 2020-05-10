package Week_03;
/*
题目：
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
public class climbStairs070 {
    public static void main (String[] args) {

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
//
//思路：
//
class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归终止条件
        if(preorder.length == 0){
            return null;
        }
        for(int i = 0;i < preorder.length ;i++){
            //当前层处理
            if(preorder[0] == inorder[i]){
                int[] pre_left = Arrays.copyOfRange (preorder,1,1+i);
                int[] pre_right = Arrays.copyOfRange (preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange (inorder,0,i);
                int[] in_right = Arrays.copyOfRange (inorder,i+1,inorder.length);
                //下探到下一层
                root.left = buildTree (pre_left,pre_right);
                root.right = buildTree (in_left,in_right);
                //旧状态数据处理
            }
        }
        return root;
    }
}
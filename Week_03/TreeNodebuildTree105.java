package Week_03;
/*
题目：根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
*/

import java.util.Arrays;

public class TreeNodebuildTree105 {
    public static void main (String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//斐波那契函数
//思路：F(n) = F(n-1) + F(n-2)
//
class Solution2020051001 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归终止条件
        if(preorder.length == 0 || inorder.length == 0)return null;
        TreeNode root = new TreeNode (preorder[0]);
        //处理当前层
        for(int i = 0;i<preorder.length;i++){
            if(preorder[0] == inorder[i]){
                int[] pre_left = Arrays.copyOfRange (preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange (preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange (inorder,0,i);
                int[] in_right = Arrays.copyOfRange (inorder,i+1,inorder.length);
                //下探到下一层
                root.left = buildTree (pre_left,in_left);
                root.right = buildTree (pre_right,in_right);
                //处理旧状态数据
                break;
            }
        }
    return root;
    }
}
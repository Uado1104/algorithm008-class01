package Week_03;
/*
题目：序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
示例: 
你可以将以下二叉树：
    1
   / \
  2   3
     / \
    4   5
序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。

*/

import java.util.Arrays;
import java.util.LinkedList;

/*
广度优先搜索（BFS）
我们按照高度的顺序从上到下逐级扫描树。更高级别的节点将先于较低级别的节点访问。
深度优先搜索（DFS)
在这个策略中，我们采用深度作为优先顺序，这样我们就可以从一个根开始，一直延伸到某个叶，然后回到根，到达另一个分支。
根据根节点、左节点和右节点之间的相对顺序，可以进一步将DFS策略区分为 preorder、inorder 和 postorder 。
DFS 策略更适合，因为相邻节点之间的链接自然地按顺序编码，这对后面的反序列化任务非常有帮助。

 */
public class serialize297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return getSerialize(root,"");

    }
    public String getSerialize(TreeNode root, String str){
        if(root == null){
            str = str + "null,";
        }
        else{
            str = str + root.val+",";
            str =  getSerialize(root.left,str);
            str =  getSerialize(root.right,str);
        }
        return str;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] strArr = data.split(",");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(strArr));
        return getDeserialize(list);
    }
    public TreeNode getDeserialize(LinkedList<String> list){
        if(list.size() == 0){
            return null;
        }
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = getDeserialize(list);
        root.right = getDeserialize(list);
        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//序列化
class solution3 {
    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
};

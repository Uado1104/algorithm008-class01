# 第五课笔记-哈希表、映射和集合
## 学习方法-切题四件套 ##
1.clarification:<br>
2.possible solution-->optional(time&space)<br>
3.code;<br>
4.test cases<br>

## Hash Table ##
### 定义
哈希表，散列表，根据关键码值而直接进行访问的数据结构。<br>
通过把关键码值映射到表中一个位置（index）来访问记录，以加快查找的速度，映射函数叫做散列函数，存放记录的数组叫哈希表。<br>
### 哈希碰撞
对于不同的要存储的数据，经过哈希函数之后会得到一个相同的值，即相同的键存储不同的值。

### 复杂度
查询的时间复杂度：O(1)

### 使用方法
Google API 接口，搜索Hashtable java 或 hashtable python<br>
[Hashtable Python][https://www.tutorialspoint.com/python_data_structure/python_hash_table.htm]
[Hashtable Java][https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html]

| 数据结构                   | 时间复杂度    |          |          |          |          |          |          |          | 空间复杂度      |
| ----------------------| -------- | -------- | -------- | -------- | -------- | -------- | -------- | -------- | ---------- |
|                        | 平均       |          |          |          | 最差       |          |          |          |            |
|                        | 访问       | 查询       | 插入       | 删除       | 访问       | 查询       | 插入       | 删除       |            |
| 数组Array                | O(1) | O(n)     | O(n)     | O(n)     | O(1)     | O(n)     | O(n)     | O(n)     | O(n)       |
| 栈Stack                 | O(n)     | O(n)     | O(1)     | O(1)     | O(n)     | O(n)     | O(1)     | O(1)     | O(n)       |
| 队列Queue                | O(n)     | O(n)     | O(1)     | O(1)     | O(n)     | O(n)     | O(1)     | O(1)     | O(n)       |
| 单链表Singly-Linked List  | O(n)     | O(n)     | O(1)     | O(1)     | O(n)     | O(n)     | O(1)     | O(1)     | O(n)       |
| 双向链表Doubly-Linked List | O(n)     | O(n)     | O(1)     | O(1)     | O(n)     | O(n)     | O(1)     | O(1)     | O(n)       |
| 跳表Skip List            | O(log n) | O(log n) | O(log n) | O(log n) | O(n)     | O(n)     | O(n)     | O(n)     | O(n log n) |
| 哈希表Hash Table          | N/A      | O(1)     | O(1)     | O(1)     | N/A      | O(n)     | O(n)     | O(n)     | O(n)       |
| 二叉树Binary Search Tree  | O(log n) | O(log n) | O(log n) | O(log n) | O(n)     | O(n)     | O(n)     | O(n)     | O(n)       |
| 笛卡尔树Cartesian   Tree   | N/A      | O(log n) | O(log n) | O(log n) | N/A      | O(n)     | O(n)     | O(n)     | O(n)       |
| B树B-Tree               | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(n)       |
| 红黑树Red-Black Tree      | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(n)       |
| 伸展树Splay Tree          | N/A      | O(log n) | O(log n) | O(log n) | N/A      | O(log n) | O(log n) | O(log n) | O(n)       |
| AVL树AVL Tree           | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(n)       |
| KD树KD Tree             | O(log n) | O(log n) | O(log n) | O(log n) | O(n)     | O(n)     | O(n)     | O(n)     | O(n)       |

### 工程代码
#### Map	、Set
Map: key-value对，key不重复<br>
Set：不重复元素的集合

## 树、二叉树、二叉搜索树
### 定义
树——特殊化的图；链表——特殊化的树；根节点（root），左子树，右子树，父节点，子节点
### 示例代码
`
//Java
public class TreeNode{
	public int val;
	public TreeNode left, right;
	public TreeNode(int val){
	this.val = val;
	this.left = null ;
	this.right = null;
	}
}
`
`
//Python
class TreeNode:
	def __init__(self,val):
		self.val = val
		self.left , self.right = None, None
`

### 树的遍历
* 前序（Pre-order）:根-左-右<br>
`
def preorder(self,root):
	if root:
		self.traverse_path.append(root.val)
		self.preorder(root.left)
		self.preorder(root.right)
`
* 中序（In-order）:左-根-右<br>
`
def preorder(self,root):
	if root:
		self.preorder(root.left)
		self.traverse_path.append(root.val)
		self.preorder(root.right)
`
* 后序（Pre-order）:左-右-根<br>
`
def preorder(self,root):
	if root:
		self.preorder(root.left)
		self.preorder(root.right)
		self.traverse_path.append(root.val)
`

### 二叉搜索树
#### 定义
也称二叉排序树、有序二叉树：<br>1.左子树上所有节点的值均小于它的根节点的值；<br>2.右子树上所有节点的值均大于它的根节点的值；<br>3.以此类推：左右子树也分别为二叉查找树。中序遍历为升序遍历。

## 堆和二叉堆、图
### 堆
#### 定义
Heap：可以迅速找到一堆数中的最大或者最小值的数据结构。<br>
根节点最大的堆为大顶堆，根节点最小的堆为小顶堆，常见的为二叉堆和斐波那契堆。<br>
常见操作（API）：<br>
find-max:O(1);delete-max:O(log N);insert(create):O(log N) or O(1)
### 二叉堆
通过完全二叉树实现，存在以下性质：1）一颗完全树；2）树中任意节点的值总是>=其子节点的值；<br>
### 二叉堆实现细节
1.二叉堆一般都通过“数组”来实现<br>
2.假设“第一个元素”在数组中的索引为零的话，父与子的节点关系如下：<br>
 索引为i的左孩子的索引是（2 * i + 1）；<br>
 索引为i的右孩子的索引是（2 * i + 1）；<br>
 索引为i的父节点的索引为floor((i-1)/2)<br>
3.Delete Max：1.将堆尾元素替换到顶部（即对顶被替代删除掉）；2.依次从根部向下调整整个堆的结构（一直到堆尾即可）。


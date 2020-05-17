# 学习笔记
## 深度优先和广度优先的搜索的实现和特性
### 深度优先的代码模版
```
visited = set{}
def dfs(node,visited)
	#terminator
	if node in visited:
		return
	visited.add(node)
	#process current node here
	...
	#go to next level
	for next_node in node.children:
		if next_node not in visited:
			dfs(next_node,visited)
		
``` 
#### 手动维护一个栈
```
def DFS(self,tree):
	if tree.root is none:
		return[]
	visited,stack = [],[tree.root]
	while stack:
		node = stack.pop()
		visited.add(node)
		process(node)
		nodes = generate_related_nodes(node)
		stack.push(node)
	#other process
	
```
```
class TreeNode:
	def __init__(self,val):
		self.val = val
		self.left, self.right = None,None
```
### 广度优先的代码模板
```
def BFS(graph,start,end):
	queue = []
	queue.append ([start])
	visited.add(start)
	
	while(queue):
		node = queue.pop()
		visited.add(node)
		process(node)
		nodes = generate_related_nodes(node)
		queue.push(nodes)
		
```

## 贪心算法
### 定义
贪心算法是一种在每一步选择中都采用子啊当前状态下最好的或最优的选择，从而希望导致结果是最优或最好的结果。<br>
#### 特点
贪心算法在于对每个子问题的解决方案都做出选择，不能回退。<br>
动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，可以回退。
高效性；接近最优解；辅助算法；直接解决结果不是很精确的题目。

## 二分查找
### 前提
1.目标函数单调性。<br>
2.存在上下界。(bounded)<br>
3.能够通过索引访问。（index accessible）<br>
### 代码模版
```
//左右界限
left,right = 0,len(array) -1
while left < right:
	mid = (left + right)/2
	if(array[mid] == target):
	//假设数据递增
		#find the target!!
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid - 1

```
### 实战
先写模板，然后根据实际填写，微调。
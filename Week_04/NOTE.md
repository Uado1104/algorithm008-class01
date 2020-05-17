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

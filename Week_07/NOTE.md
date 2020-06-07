# 学习笔记-Trie树到基本实现和特性
## 字典树到数据结构
### 定义
字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），被搜索引擎系统用于文本词频统计。
### 优点
查询效率高，最大限度的减少无谓的字符串比较，查询效率比哈希表高。
## 字典树到核心思想
用空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
## 字典树到基本性质
1.节点本身不存完整单词。<br>
2.从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。<br>
3.每个节点的所有子节点路径代表的字符都不相同。<br>

## 并查集
### 定义
并查集(Disjoint-Set)是一种可以动态维护若干个不重叠的集合，并支持合并与查询两种操作的一种数据结构。
### 具体实现
建立一个数组fa[ ]或pre[ ]表示一个并查集，fa[i]表示i的父节点。
#### 初始化
每一个点都是一个集合，因此自己的父节点就是自己fa[i]=i
#### 查询
每一个节点不断寻找自己的父节点，若此时自己的父节点就是自己，那么该点为集合的根结点，返回该点。
#### 修改
合并两个集合只需要合并两个集合的根结点，即fa[RootA]=RootB，其中RootA,RootB是两个元素的根结点。
#### 路径压缩
在查询过程中只关心根结点是什么，并不关心这棵树的形态(有一些题除外)。因此我们可以在查询操作的时候将访问过的每个点都指向树根，这样的方法叫做路径压缩，单次操作复杂度为𝑂(𝑙𝑜𝑔𝑁)

## DFS模板
```
visited = set() 


def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 


	visited.add(node) 


	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
## BFS模板
```
# Python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

##双向BFS模板
```

void BFS_bothsides()//双向BFS 
{
    if(s1.state==s2.state)//起点终点相同时要特判
    {
           //do something
           found=true;
           return;
    }
    bool found=false;
    memset(visited,0,sizeof(visited));  // 判重数组
    while(!Q1.empty())  Q1.pop();   // 正向队列
    while(!Q2.empty())  Q2.pop();  // 反向队列
    //======正向扩展的状态标记为1，反向扩展标记为2
    visited[s1.state]=1;   // 初始状态标记为1
    visited[s2.state]=2;   // 结束状态标记为2
    Q1.push(s1);  // 初始状态入正向队列
    Q2.push(s2);  // 结束状态入反向队列
    while(!Q1.empty() || !Q2.empty())
    {
           if(!Q1.empty())
                  BFS_expand(Q1,true);  // 在正向队列中搜索
           if(found)  // 搜索结束 
                  return ;
          if(!Q2.empty())
                  BFS_expand(Q2,false);  // 在反向队列中搜索
           if(found) // 搜索结束
                  return ;
    }
}
void BFS_expand(queue<Status> &Q,bool flag)
{  
 	s=Q.front();  // 从队列中得到头结点s
 	Q.pop()
 	for( 每个s 的子节点 t )
	{
        t.state=Gethash(t.temp);  // 获取子节点的状态
        if(flag)   // 在正向队列中判断
        {
           	if(visited[t.state]!=1)// 没在正向队列出现过
            {
                if(visited[t.state]==2)  // 该状态在反向队列中出现过
              	{
                    各种操作；
                    found=true；
                    return;
                }
                visited[t.state]=1;   // 标记为在在正向队列中
                Q.push(t);  // 入队
           	}
        }
        else    // 在正向队列中判断
        {
            if (visited[t.state]!=2) // 没在反向队列出现过
         	{
                if(visited[t.state]==1)  // 该状态在正向向队列中出现过
                {
                    各种操作；
                    found=true；
                    return;
                }
                visited[t.state]=2;  // 标记为在反向队列中
                Q.push(t);  // 入队
            }
        }
    }

```
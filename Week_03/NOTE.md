#递归的实现、特性以及思维要点
## 本质
运用循环体调用自己本身，循环嵌套
## 特点
向下进入到另一层中，递归层，向上又回到另一层；<br>
用参数来进行不同层的传递变量。<br>
每一层的环境都是一份拷贝，发生和携带发生变化；<br>
## 递归Recursion
计算：n!；<br>
```
def Factorial(n):
	if n<= 1:
		n = 1
	return n * Factorial(n-1)
```
### 递归的代码模版
```
def (level,param1,param2 )：
# recursion terminator
	if level > max_level:
		process_result
		return
	# process logic in current level
	process(level,data,……)
	#drill down
	self.cursion(level+1,p1)
	#reverse the current level status if needed
	 
```
```
public void recur(int level, int param1, int param2){
	if (level > max_level){
		process result;
		return;
	}
	process(level,p1,p2);
	recur(level:level + 1,new param);
}
```
1.递归终结条件；<br>
2.处理当前层的逻辑；<br>
3.下探到下一层；<br>
4.清理当前层；<br>

### 思维要点
1.不要人肉进行递归；<br>
2.找最近重复子问题——找到最近最简的方法，将其拆分为可重复解决的子问题<br>
3.数学归纳法思维<br>
# 分治和回溯
## 分治(Divide & Conquer)
### 本质
1.找重复性；2.分解问题；3.组合每个子问题的结果
### 分治的代码模版
```
def divide_conquer(problem,param1,param2):
	#recursion terminator
	if problem is none:
		print result
		return
	#prepare data
	data = prepare_data(problem)
	subproblems = split_problems(problem,data)
	#conquer subproblems
	subresult1 = self.divide_conquer(subproblems[0] , p1 , p2)
	subresult2 = self.divide_conquer(subproblems[1] , p1 , p2)
	subresult3 = self.divide_conquer(subproblems[2] , p1 , p2) 
	 #process and generate the final result
	 result  = process_result(subresult1,subresult2,subresult3,……)

```

## 回溯
### 定义
回溯法（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

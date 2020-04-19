#学习笔记-数组、链表和跳表<br> 
##数组-Array<br> 
###底层实现<br> 
内存管理器-Memory Controller<br> 
创建数组-在计算机中开辟连续的地址-通过内存管理器访问相应的内存地址。<br> 
###访问复杂度<br> 
访问任意元素，时间复杂度为O(1)<br> 
###操作<br> 
####增加、删除元素<br> 
时间复杂度为O(n)<br> 
java源代码<br> 
http://developer.classpath.org/doc/java/util/ArrayList-source.html<br> 

##链表-Link List<br> 
###结构<br> 
Value（成员变量，用class定义）+ <br> 
Next指针，单链表，指向下一个元素；双向链表，先前指针prev，previos；<br> 
Head，Tail（可指向空，也可指向head，循环链表）<br> 
如何实现Node——<br> 
https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/<br> 
####时间复杂度<br> 
增加、删除、prepend、Append的时间复杂度为O(1)；<br> 
访问的时间复杂度为O(n)<br> 
<br> 
##跳表-Skip List
跳表，对标的是平衡树（AVL Tree）和二分查找，是一种插入/删除/搜索都是O(log n)的数据结构。<br> 
原理简单，容易实现，方便扩展，效率更高<br> 
<br> 
###思维方式<br> 
1.一维的数据结构的加速方式通常是升维（二维）<br> 
2.空间换时间<br> 
####例子<br> 
提高链表先行查找的效率——添加多级索引<br> 
第k级索引节点的个数是n/(2^k)，h=log2(n)-1<br> 

###工程中应用<br> 
####Linked List<br> 
LRU Cache<br> 
https://www.jianshu.com/p/c204a418fed1<br> 
https://leetcode-cn.com/problems/lru-cache/<br> 

####Redis-Skip List<br> 

https://www.zhihu.com/question/20202931<br> 
https://www.jianshu.com/p/54d37710b2a6<br> 
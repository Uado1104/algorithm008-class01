#学习笔记-数组、链表和跳表
##数组-Array
###底层实现
内存管理器-Memory Controller
创建数组-在计算机中开辟连续的地址-通过内存管理器访问相应的内存地址。
###访问复杂度
访问任意元素，时间复杂度为O(1)
###操作
####增加、删除元素
时间复杂度为O(n)
java源代码
http://developer.classpath.org/doc/java/util/ArrayList-source.html

##链表-Link List
###结构
Value（成员变量，用class定义）+ 
Next指针，单链表，指向下一个元素；双向链表，先前指针prev，previos；
Head，Tail（可指向空，也可指向head，循环链表）
如何实现Node——
https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
####时间复杂度
增加、删除、prepend、Append的时间复杂度为O(1)；
访问的时间复杂度为O(n)

##跳表-Skip List
跳表，对标的是平衡树（AVL Tree）和二分查找，是一种插入/删除/搜索都是O(log n)的数据结构。
原理简单，容易实现，方便扩展，效率更高

###思维方式
1.一维的数据结构的加速方式通常是升维（二维）
2.空间换时间
####例子
提高链表先行查找的效率——添加多级索引
第k级索引节点的个数是n/(2^k)，h=log2(n)-1

###工程中应用
####Linked List
LRU Cache
https://www.jianshu.com/p/c204a418fed1
https://leetcode-cn.com/problems/lru-cache/

####Redis-Skip List

https://www.zhihu.com/question/20202931
https://www.jianshu.com/p/54d37710b2a6
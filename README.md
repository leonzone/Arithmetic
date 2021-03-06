# Arithmetic And Data Structure

项目的目的是整理常用```数据结构``` 和 ```算法```，以作为一个快速工具类使用。


- 数组
    - [支持动态扩容的数组](/src/structure/array/DEArray.java)
    - [大小固定的有序数组，支持动态增删改操作](/src/structure/array/DArray.java)
    - [两个有序数组合并为一个有序数组](/src/arithmetic/array/MergeTwoArray.java)
    
- 链表
    - [单向链表](/src/structure/linkedlist/SinglyLinkedList.java)
    - [循环链表](/src/structure/linkedlist/CycleSinglyLinkedList.java)
    - [双向链表](/src/structure/linkedlist/DoubleLinkedList.java)
    - [反转链表](/src/arithmetic/linkedlist/LinkedList.java) 
    - [检测环](/src/arithmetic/linkedlist/LinkedList.java)
    - [合并两个有序链表](/src/arithmetic/linkedlist/LinkedList.java) 
    - [删除链表的倒数第 n 个节点](/src/arithmetic/linkedlist/LinkedList.java)
    - [链表的中间结点](/src/arithmetic/linkedlist/LinkedList.java)
    
- 栈
    - [顺序栈](/src/structure/stack/ArrayStack.java)
    - [链式栈](/src/structure/stack/LinkedListStack.java)
    - [浏览器前进、后退](/src/arithmetic/stack/SimpleBrowser.java)
    
- 队列
    - [顺序队列](/src/structure/queue/ArrayQueue.java)
    - [链式队列](/src/structure/queue/LinkedlistQueue.java)
    - [循环队列](/src/structure/queue/CircularQueue.java)
    
- 递归
    - [斐波拉契数列求值](/src/arithmetic/recursion/Fibonacci.java)
    - [求阶乘 n!](/src/arithmetic/recursion/Factorial.java)
    - [一组数据集合的全排列](/src/arithmetic/recursion/FullyArranged.java)

- 排序     
    - [并归排序](/src/arithmetic/sort/Sorts.java)
    - [快速排序](/src/arithmetic/sort/Sorts.java)
    - [插入排序](/src/arithmetic/sort/Sorts.java)
    - [冒泡排序](/src/arithmetic/sort/Sorts.java)
    - [选择排序](/src/arithmetic/sort/Sorts.java)
    - [一组数据的第 K 大元素](/src/arithmetic/sort/TopK.java)  

- 二分查找
    - [一个有序数组的二分查找算法](/src/arithmetic/search/BSearch.java)
    - [模糊二分查找算法](/src/arithmetic/search/BSearch.java)   
    
- 跳表
    - 实现一个跳表    
     
- 散列表
    - [实现一个基于链表法解决冲突问题的散列表](/src/structure/hash/HashBaseLikedList.java)
    - [实现一个LRU缓存淘汰算法](/src/structure/hash/LRUBaseLikedList.java)
    
- 字符串
    - [实现一个字符集，只包含a～z这26个英文字母的Trie树](/src/structure/tree/Trie.java)
    - [实现朴素的字符串匹配算法](/src/arithmetic/strings/BruteForce.java)     
    
    
- 二叉树
    - [实现一个二叉查找树，并且支持插入、删除、查找操作](/src/structure/tree/BinarySearchTree.java)
    - 实现查找二叉查找树中某个节点的后继、前驱节点
    - [实现二叉树前、中、后序以及按层遍历](/src/structure/tree/BinarySearchTree.java)
    
- 堆
    - 实现一个[小顶堆](/src/structure/heap/SmallHeap.java)、[大顶堆](/src/structure/heap/BigHeap.java)、[优先级队列](/src/structure/heap/PriorityQueueBaseHeap.java)
    - [实现堆排序](/src/arithmetic/heap/HeapSort.java)  
    - [利用优先级队列合并 K 个有序数组](/src/arithmetic/heap/CombinMultiSortArray.java) 
    - [求一组动态数据集合的最大 Top K](/src/arithmetic/heap/TopK.java) 
    
- 图     
    - [实现有向图、无向图、有权图、无权图的邻接矩阵和邻接表表示方法](/src/structure/graph)
    - 实现图的[深度优先搜索](/src/arithmetic/graph/BFS.java)、[广度优先搜索](/src/arithmetic/graph/BFS.java)
    - 实现[ Dijkstra 算法](/src/arithmetic/graph/dijkstra/Dijkstra.java)、A* 算法
    - 实现拓扑排序的[Kahn 算法](/src/arithmetic/graph/sorting/Topo.java)、[DFS 算法](/src/arithmetic/graph/sorting/Topo.java)

- 回溯
    - [利用回溯算法求解八皇后问题](/src/arithmetic/backtracking/Cal8queen.java)
    - [利用回溯算法求解0-1背包问题](/src/arithmetic/backtracking/Backpack.java)
    
- 分治
    - 利用分治算法求-组数据的逆序对个数
    
- 动态规划
    - [0-1背包问题](/src/arithmetic/dp/Knapsack.java)
    - [最小路径](/src/arithmetic/dp/MiniDist.java)
    - 编程实现莱文斯坦最短编辑距离
    - 编程实现查找两个字符串的最长公共子序列
    - 编程实现一个数据序列的最长递增子序列

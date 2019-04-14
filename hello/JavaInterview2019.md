
> JavaInterview2019.md
>
> 来自QQ群(329019348), update at 2018-04-17


### JAVA基础

> 方腾飞、葛一鸣、及那边经典的书要好好阅读一下。

#### 5.

> 讲讲类的实例化顺序

参考 [StaticInitOrderTest.java](./src/main/java/com/wxg/daily/study/StaticInitOrderTest.java),
还有另外两个类，使用IDEA打开此文档，使用快捷键`Ctrl + N`查看.


#### 6.

> Map

[`Map`](http://tool.oschina.net/uploads/apidocs/jdk-zh/java/util/Map.html),
`HashMap`, `LinkedHashMap`

<https://blog.csdn.net/sinat_37906153/article/details/83004831>, 此博文讲解了
- 取模(`%`) , 按位与(`&`) : 当 `b = 2^n` 时，`a % b = a & (b - 1)` , 也是因此，HashMap 才将初始长度设置为 `16`，且扩容只能是以 `2` 的倍数`（2^n）`扩容。
- 解决冲突 : HashMap 就是使用链地址法来解决冲突的（jdk8中采用平衡树来替代链表存储冲突的元素）

#### 7.

> JAVA8的`ConcurrentHashMap`为什么放弃分段锁

<https://baijiahao.baidu.com/s?id=1614041068770611219&wfr=spider&for=pc>
- 这篇文章说的比较简单，只在开头'红黑树'代替'链表'说的比较好: 大量相同的hashcode时，链表太长，查找效率依然很低，使用红黑树就好很多。

<https://www.cnblogs.com/yangming1996/p/8031199.html>
- 这篇博文介绍的比较详细

#### 8.

> 有没有有顺序的Map实现，它们是如何保证有序的。


#### 11.

> IO模型有哪些？谈谈reactor模型

#### 12.

> 反射

<https://www.cnblogs.com/luoxn28/p/5686794.html>,
<https://www.cnblogs.com/ysocean/p/6516248.html>











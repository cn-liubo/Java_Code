#### [633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

难度中等164收藏分享切换为英文接收动态反馈

给定一个非负整数 `c` ，你要判断是否存在两个整数 `a` 和 `b`，使得 `a2 + b2 = c` 。

 

**示例 1：**

```
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
```

**示例 2：**

```
输入：c = 3
输出：false
```

**示例 3：**

```
输入：c = 4
输出：true
```

**示例 4：**

```
输入：c = 2
输出：true
```

**示例 5：**

```
输入：c = 1
输出：true
```

 

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0) return false;
        int i = 0;
        int j = (int)Math.sqrt(c);
        while(i <= j) {
            int s = i * i + j * j;
            if(s == c) return true;
            else if(s < c) i++;
            else j--;
        }
        return false;
    }
}
```


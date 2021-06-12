```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            int right = n & ((~n) + 1);
            count++;
            n ^= right;
        }
        return count;
    }
}
```


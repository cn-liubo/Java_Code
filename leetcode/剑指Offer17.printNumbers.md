```java
class Solution {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] arr = new int[end];
        for(int i = 0; i < end; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
```


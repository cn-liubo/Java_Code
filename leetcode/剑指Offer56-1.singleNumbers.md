```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int t = 0;
        for(int num : nums) {
            t ^= num;
        }

        //获取最低为的1
        // int m = 1;
        // while((t & m) == 0) {
        //     m <<= 1;
        // }
        int m = t & (~t + 1);

        int a = 0, b = 0;
        for(int num : nums) {
            if((num & m) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
```


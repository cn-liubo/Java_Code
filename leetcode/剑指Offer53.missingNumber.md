```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum != nums[i]) {
                return sum;
            }
            sum++;
        }
        return sum;
    }
}
```


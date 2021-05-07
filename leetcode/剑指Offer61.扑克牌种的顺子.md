解法1：

```java
class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++;
            else if(nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}
```

解法2：

```java

```


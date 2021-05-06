```java
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for(int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
```


```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = 1;
        Set<String> set = new HashSet<>();
        int i = 0;
        while(i + length <= str.length()) {
            set.add(str.substring(i, i + length));
            i++;
            if(set.size() == (int)Math.pow(4, length)) {
                set.clear();
                length++;
                i = 0;
            }
        }
        System.out.println(length);
    }
}
```


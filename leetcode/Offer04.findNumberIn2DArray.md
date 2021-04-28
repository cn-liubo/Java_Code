解法1：暴力

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < colums; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

解法2：线性查找

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;//1
        int colums = matrix[0].length;//1
        int row = 0;
        int colum = colums - 1;
        while(row < rows && colum >= 0) {
            int num = matrix[row][colum];
            if(num == target) {
                return true;
            } else if (num > target) {
                colum--;
            } else {//num < target
                row++;
            }
        }
        return false;
    }
}
```


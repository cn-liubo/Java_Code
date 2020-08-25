package teststring;

public class Exercise {

    //设计一个方法 将字符串反转  ok-->ko
    // 是否需要参数 String     是否需要返回值 String
    public String reverse(String str){
//        //将str变化成数组
//        char[] value = str.toCharArray();
//        //数组头尾互换
//        for(int i = 0; i < value.length/2; i++){
//            char temp = value[i];
//            value[i] = value[value.length-1-i];
//            value[value.length-1-i] = temp;
//        }
//        //数组组合成字符串  返回
//        return new String(value);

        //StringBuffer   StringBuilder
        //return new String(new StringBuilder(str).reverse());
        return new StringBuilder(str).reverse().toString();
    }


    //设计一个方法 将给定字符串的正序和反序进行连接  ok-->okko
    // 是否需要参数 String     是否需要返回值 String
    public String reverseAndConcat(String str){
//        //将str反转
//        String value = this.reverse(str);
//        //str之后拼接反转的字符串
//        String result = str.concat(value);
//        //将最终的结果返回
//        return result;
        return str.concat(this.reverse(str));
    }


    //设计一个方法 判断给定字符串是否是回文
    // 是否需要参数 String     是否需要返回值 boolean
    public boolean isPalindrome(String str){
//        //将传递进来的str先反转
//        String value = this.reverse(str);
//        //用str与反转过来的字符串比较
//        //如果完全一致，证明是回文
//        if(value.equals(value)){
//            return true;
//        }else{
//            return false;
//        }
        if(this.reverse(str).equals(str)){
            return true;
        }
        return false;
    }


    //设计一个方法 将给定的字符串右位移  (helloworld,2)-->ldhellowor
    // 是否需要参数 String,int     是否需要返回值 String
    public String moveToRight(String str, int count){
        if(count > str.length()){
            count %= str.length();
        }
        //截取
        //前半部分
        String begin = str.substring(0, str.length() - count);//拼接时放在后面
        //后半部分
        String end = str.substring(str.length() - count);//拼接时放在前面
        //拼接之后返回
        return end.concat(begin);
    }


    //设计一个方法 寻找若干字符串中最长的那个  ab,abc,abcd-->abcd
    // 是否需要参数 String[](String...)     是否需要返回值 String
    public String findMaxLengthString(String...strs){
        String result = strs[0];//第一个字符串存起来
        int maxLength = strs[0].length();//第一个字符串的长度
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() > maxLength){
                maxLength = strs[i].length();
                result = strs[i];
            }
        }
        return result;
    }


    //设计一个方法 统计给定字母在字符串中出现的次数  "this is a test of java","a"-->3
    // 是否需要参数 String,char     是否需要返回值 int
    public int letterExistCount(String str,char letter){
//        int count = 0;//记录找到的个数
//        for(int i = 0; i < str.length(); i++){
//            if(str.charAt(i) == letter){
//                count++;
//            }
//        }
//        return count;
        return str.length() - str.replace(String.valueOf(letter),"").length();
    }


    //设计一个方法 将给定字符串每一个首字母大写  "this is a test of java"-->"This Is A Test Of Java"
    // 是否需要参数 String     是否需要返回值 String
    public  String firstLetterToUpperCase(String str){
        String result = "";//拼接最终的字符串
        //将完整的字符串按照空格拆分为单词
        String[] value = str.split(" ");
        //循环处理每一个单词 截取首字母变为大写 截取其余字母 整体拼接
        //每一次的单词拼接成一个完整的字符串 返回
        for(int i = 0; i < value.length; i++){
            String word = value[i];//获取每一个单词
            String firstLetter = word.substring(0,1).toUpperCase();//将首字母截取出来 变为大写
            String otherLetter = word.substring(1);//其余的字母
            result = result.concat(firstLetter.concat(otherLetter)+" ");//注意String的不可变特性
        }
        return result.trim();//去掉最后多余的空格
    }


    //设计一个方法 获取给定字符串中的全部数字  "za1o1zbp24tcq"-->1124
    // 是否需要参数 String     是否需要返回值 int
    public int findNumber(String str){
        String result = "";
        //循环找寻字符串中的每一个字符
        //判断当前找到的字符是否是数字  '0'-'9'  49-57
        for(int i = 0; i < str.length(); i++){
            int code = str.codePointAt(i);//每一个字符对应的code码
            if(code >= 48 && code <= 57){
                result += (char)code;
            }
        }
        //将找到的数字返回
        return Integer.parseInt(result);//int value = new Integer(result);
    }
}

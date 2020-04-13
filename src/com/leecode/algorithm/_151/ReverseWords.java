package com.leecode.algorithm._151;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 *
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 *
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 *
 *
 * 说明：
 *
 *
 * 	无空格字符构成一个单词。
 * 	输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 	如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {


    /**
     * 使用java的Api编写
     */
    public String reverseWords(String s) {
        s = s.replaceAll(" +", " ").trim();
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length-1; i > -1; i--) {
            if(i == 0){
                sb.append(ss[i]);
            }else {
                sb.append(ss[i]).append(' ');
            }
        }
        return sb.toString();
    }

    /**
     * 自己编写的代码(除了第一行的去空格)
     * @return
     */
//    public String reverseWords(String s) {
//        if("".equals(s.trim())){
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        char[] cs = s.toCharArray();
//        int end=-1;
//        for (int i = cs.length-1; i >-1;) {
//            if(cs[i] == ' '){
//                if(end != -1){
//                    end++;
//                    for (int j = i+1; j < end; j++) {
//                        sb.append(cs[j]);
//                    }
//                    sb.append(' ');
//                    end=-1;
//                }
//                while(i>-1 && cs[i] == ' '){i--;}
//            }
//            if(i!=-1 && cs[i] != ' '){
//                end=i;
//            }
//            while(i>-1 && cs[i] != ' '){i--;};
//        }
//        if(end != -1){
//            end++;
//            for (int j = 0; j < end; j++) {
//                sb.append(cs[j]);
//            }
//        }else {
//            sb.deleteCharAt(sb.length()-1);
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        String s = "  hello world!  ";
        System.out.println(r.reverseWords(s));
    }
}

package com.leecode.algorithm._010;

import java.util.regex.Pattern;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 *
 * 	s 可能为空，且只包含从 a-z 的小写字母。
 * 	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 *
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 *
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
//        System.out.println(new IsMatch().isMatch(s, p));

        System.out.println(Pattern.matches(p, s));
    }

    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }

        char[] ps = p.toCharArray();
        char[] ss = s.toCharArray();
        boolean nextXin;
        int is = 0;

        for (int ip=0; ip < ps.length; ip++) {
            if(nextXin(ip, ps)){
                // 如果出现.*的匹配字符
                // 需要将s的某个字符串跟p.*后一个字符相匹配才会停下

                final char pc = ps[ip];
                if('.' == pc){
                    if(ip+2 == ps.length){
                        return true;
                    }
                    char pc2 = ps[ip+2];
                    for(;ss.length > is && ss[is] != pc2;is++);
                }else{
                    // 如果p后面存在的字符校验跟*前的一样,则抵消一部分
                    if(ps.length > ip+2){
                        char pc2 = ps[ip+2];
                        if(pc2 == ss[is] && ps[ip] == ss[is]){
                            int[] addNums = checkEnd(ss, ps, ip, is);
                            ip += addNums[0];
                            is += addNums[1];
                        }
                    }
                    for(;ss.length > is && ss[is] == pc; is++);
                }

                if(ss.length <= is){
                    // 如果s的字符串已经校验没有了,但是p的字符串判断还存在,直接返回结果
                    return sOverCheckP(ps, ip);
                }
                ip++;
            }else if('.' == ps[ip]){
                is++;
            }else{
                if(ss.length <= is || ss[is++] != ps[ip]){
                    return false;
                }
            }
        }
        return is==ss.length;
    }

    /**
     * 当s的字符串已经校验完了,但是p的还存在
     * 需要判断p后面的校验字符
     * @return
     */
    public boolean sOverCheckP(char[] ps, int ip){
        if(ip+2 == ps.length){
            return true;
        }
        while (ps.length > ip) {
            if(nextXin(ip, ps)){
                ip++;
            }else{
                return false;
            }
            ip++;
        }
        return true;
    }


    /**
     * 判断下一个字符是否为*
     * 如果为*则返回true
     * @param i
     * @param ps
     * @return
     */
    public boolean nextXin(int i, char[] ps){
        if(i+1 < ps.length){
            return ps[i+1] == '*';
        }
        return false;
    }

    /**
     * 如果出现 p = x*xx, s = xx 的情况
     * 使用该方法,将 p的x*后面的 x先与 s的x匹配
     * 返回后面会存在多少个相同数,上面例子就返回 2
     * 返回索引 p放置第一位,s放置第二位返回
     */
    public int[] checkEnd(char[] ss, char[] ps, int ip, int is){
        int[] i = new int[2];
        // 由于一开始 为 x*,所以先将ip的位置向后移动两位
        ip+=2;
        boolean isDian = false;
        while(ps.length > ip && ss.length > is && (ps[ip] == ss[is] || (isDian = ps[ip] == '.'))){
            if(nextXin(ip, ps)){
                ip+=2;
                if (!isDian || ps[ip] == ss[is]){
                    i[0] += 2;
                }
            }else {
                i[0]+=1;
                i[1]+=1;
                ip++;
                is++;
            }
            isDian = false;
        }
        return i;
    }
}

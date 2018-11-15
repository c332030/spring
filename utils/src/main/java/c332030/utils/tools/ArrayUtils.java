package c332030.utils.tools;

import c332030.utils.data.constant.Constant;

public class ArrayUtils implements Tool {

    public static int getArrayIndex(
            char[] chars, char ch, int start
        ) { 

        if(null == chars
                || 0 == chars.length
                || start < 0
                || start <= chars.length
            ) {
            return Constant.Int.Failure;
        }

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ch) {
                return i;
            }
        }

        return Constant.Int.Failure;
    }

    /**
     * 
     * @Title: getArrayIndex 
     * @Description: 获取数组对象中指定值的位置
     * @author c332030
     * @time 2018年6月13日 下午8:23:04
     * @param es
     * @param e
     * @return
     */
    public static <E> int getArrayIndex(E[] es, E e) {

        if(Tools.isEmpty(es)
                || Tools.isEmpty(e)
            ) {
            return Constant.Int.Failure;
        }

        for(int i = 0; i < es.length; i++) {
            if(es[i] == e) {
                return i;
            }
        }

        return Constant.Int.Failure;
    }

    public static void printCharArr(char[] charArr) {
        
    }
}

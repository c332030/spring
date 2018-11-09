package c332030.utils.tools;

import c332030.utils.data.constant.Constant;
import c332030.utils.data.model.interfaces.C;

import java.util.Collection;
import java.util.Map;

public class Tools implements Tool {

    private Tools(){}

    /*
     * 
     * @Title: isEmpty 
     * @Description: 判断是否为空！
     * @author c332030
     * @time 2018年6月13日 下午2:58:04
     * @param obj
     * @return
     */
    /*
    @Deprecated
    public static boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        }

        if (obj instanceof Integer) {

            return ((Integer) obj) < 0;
        } else if (obj instanceof String) {

            return ((String) obj).isEmpty();
        } else if (obj instanceof Collection<?>) {

            return ((Collection<?>) obj).isEmpty(); // List、Set
        } else if (obj instanceof Map<?, ?>) {

            return ((Map<?, ?>) obj).isEmpty();
        }

        else if(obj instanceof C) {

            return ((C) obj).isEmpty();
        }

        return false;
    }
*/

    public static boolean isEmpty(Object obj) {
        return null == obj;
    }

    public static boolean isEmpty(Integer inte) {
        return inte == null || inte < 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static <E extends Collection> boolean isEmpty(E e) {
        return e == null || e.isEmpty();
    }

    public static <E extends Map> boolean isEmpty(E e) {
        return e == null || e.isEmpty();
    }

    public static <E extends C> boolean isEmpty(E e) {
        return e == null || e.isEmpty();
    }

    /**
     *
     * @Title: isEmpty
     * @Description: 判断是否为空！
     * @author c332030
     * @time 2018年6月13日 下午2:58:04
     * @param es
     * @return
     */
    public static <E> boolean isEmpty(E[] es) {
        return isEmpty(es, true);
    }

    /**
     * 
     * @Title: isEmpty 
     * @Description: 判断是否为空！
     * @author c332030
     * @time 2018年6月13日 下午2:58:04
     * @param es
     * @param onlyCheckNotEmpty
     * @return
     */
    public static <E> boolean isEmpty(E[] es, boolean onlyCheckNotEmpty) {
        
        if(null == es
                || 0 == es.length
                ) {
            return true;
        }

        if(onlyCheckNotEmpty) {
            return false;
        }

        int i = 0;
        while(i < es.length) {
            if(isEmpty(es[i++])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 
     * @Title: dealNull 
     * @Description: 处理空值，e1 为空时返回 e2
     * @author c332030
     * @time 2018年6月13日 下午3:29:28
     * @param e1
     * @param e2
     * @return
     */
    public static <E> E dealNull(E e1, E e2) {
        
        if(null == e1) {
            return e2;
        }

        return e1;
    }

    /**
     * 
     * @Title: dealNull 
     * @Description: 处理对象，返回 Str
     * @author c332030
     * @time 2018年8月16日 下午4:00:44
     * @param obj
     * @return
     */
    public static String dealNull(Object obj) {
        return dealNull(obj, Constant.string.EMPTY_STR).toString().trim();
    }
}

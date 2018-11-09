package c332030.utils.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class DataUtils implements Tool {

    private static final int maxSize = 1 << 30;
    
    private static final String UTF8 = "UTF-8";

    /** 
     * 获取16进制随机数 
     * 
     * @return    randomHex    32 个 16 进制随机数
     * @throws
     */ 
    public static String getRandomHex() {
        String randomHex = null;

        try {

            StringBuffer result = new StringBuffer();
            for(int i = 0; i < 32; i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }

            randomHex = result.toString().toUpperCase();
        } catch (Exception e) {

            e.printStackTrace();
        }
        
    //    System.out.println("\n\nUtils：获取到的随机数：" + randomHex);
        
        return randomHex;
    }

    /**
    * MD5加密算法
    * 
    * @author    c332030
    * @param    str   需要转化为MD5码的字符串
    * @return    返回一个 32 位 16 进制的字符串

    * 思路过程：
    *    1、str.getBytes()：将字符串转化为字节数组。字符串中每个字符转换为对应的ASCII值作为字节数组中的一个元素
    *    2、将字节数组通过固定算法转换为16个元素的有符号哈希值字节数组
    *    3、将哈希字节数组的每个元素通过0xff与运算转换为两位无符号16进制的字符串
    *    4、将不足两位的无符号16进制的字符串前面加0
    *    5、通过StringBuffer.append()函数将16个长度为2的无符号进制字符串合并为一个32位String类型的MD5码
    */
    public static String getMD5(String str) {
        String strMD5 = null;

        if(null == str || str.length() == 0) {
            return null;
        }

        StringBuffer md5Code = new StringBuffer();

        try {
            //获取加密方式为md5的算法对象
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(str.getBytes());

            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 0xff);

                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                // 往字符串后添加字符
                //    md5Code = md5Code.append(b);
                md5Code.append(hexString);
                
                strMD5 = md5Code.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strMD5;
    }

    /**
     * 
     * @Title: getMD5Up 
     * @Description: MD5 加密，全大写
     * @author c332030
     * @time 2018年6月13日 下午12:11:33
     * @param str
     * @return
     */
    public static String getMD5Up(String str) {
        return getMD5(str).toUpperCase();
    }

    /**
     * 
     * @Title: prtBinary 
     * @Description: 输出二进制值
     * @author c332030
     * @time 2018年6月13日 下午12:04:14
     * @param x
     */
    public static void prtBinary(int x) {
        System.out.println("x= " + x + "\n" + getBinary(x) + "\n");
    }

    /**
     * 
     * @Title: getBinary 
     * @Description: 整型转二进制
     * @author c332030
     * @time 2018年6月13日 下午12:04:24
     * @param x
     * @return
     */
    public static String getBinary(int x) {
        StringBuffer sb = new StringBuffer();

        int i = 32;
        while(i-- > 0) {
            sb.append(x % 2);
            x /= 2;

            if((i) % 4 == 0) {
                sb.append(" ");
            }
        }

        return sb.reverse().toString();
    }

    /**
     * 
     * @Title: tableSizeFor 
     * @Description: 获取大于 cap 的最小 2 的 n 次方值
     * @author c332030
     * @time 2018年6月13日 下午12:04:44
     * @param cap
     * @return
     */
    public static int tableSizeFor(int cap) {

        int n = cap - 1;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n < 0) ? 1 : (n >= maxSize) ? maxSize : n + 1;
    }

    /**
     * 
     * @Title: enBase64 
     * @Description: Base64 编码
     * @author c332030
     * @time 2018年6月13日 下午12:20:58
     * @param str
     * @return
     */
    public static String enBase64(String str) {
        if(Tools.isEmpty(str)) {
            return null;
        }

        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 
     * @Title: deBase64 
     * @Description: Base64 解码
     * @author c332030
     * @time 2018年6月13日 下午12:21:06
     * @param str
     * @return
     */
    public static String deBase64(String str) {
        if(Tools.isEmpty(str)) {
            return null;
        }

        return new String(Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
    }

    /**
     * 
     * @Title: genUUID 
     * @Description: 生成UUID
     * @author c332030
     * @time 2018年8月4日 下午5:38:37
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}

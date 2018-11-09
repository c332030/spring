package c332030.utils.tools;

import c332030.utils.exception.CException;

import java.io.*;

public class ObjectUtils implements Tool {

	/**
	 * 
	 * @Title: seri 
	 * @Description: 对象序列化
	 * @author c332030
	 * @time 2018年8月4日 下午4:25:05
	 * @param obj
	 * @return
	 * @throws IOException 
	 */
	public static byte[] seri(Object obj) throws Exception {

		if(!(obj instanceof Serializable)) {
			throw new CException("obj Not instanceof Serializable!");
		}

		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;

		byte[] bytes = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);

			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} finally {
			if(!Tools.isEmpty(oo)) {
				oo.close();
			}
		}

		return bytes;
	}

	/**
	 * 
	 * @Title: reSeri 
	 * @Description: 对象反序列化
	 * @author c332030
	 * @time 2018年8月4日 下午4:25:50
	 * @param bytes
	 * @return
	 * @throws Exception 
	 */
	public Object reSeri(byte[] bytes) throws Exception {

		if(Tools.isEmpty(bytes)) {
			return null;
		}

		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;

		Object obj = null;

		try {
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);

			obj = oi.readObject();
		} finally {
			if(!Tools.isEmpty(oi)) {
				oi.close();
			}
		}

		return obj;
	}
}

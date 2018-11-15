package c332030.utils.data.model.message;

import c332030.utils.data.model.abstractclass.CUnmodify;
import c332030.utils.data.model.interfaces.CClone;
import c332030.utils.tools.Tools;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Message
 * @Description 通讯报文
 * @Author c332030
 * @Date 2018/10/30 10:07
 * @Version 1.0
 */
public class Message extends CUnmodify<Message> implements CClone<Message> {
    private static final long serialVersionUID = -8586503429751196808L;

    public static final String HEAD_STATUS = "status";

    /**
     * @Description 默认的失败消息
     * @author c332030
     * @date 2018/11/15 10:04
     */
    public static final Message FAILED_MESSAGE;
    static {
        Map<String, Object> headTmp = new HashMap<>();
        headTmp.put(HEAD_STATUS, Status.FAILED_STATUS);
        FAILED_MESSAGE = new Message(Collections.unmodifiableMap(headTmp), null).setUnmodify();
    }

    /**
     * @Description 默认的成功消息
     * @author c332030
     * @date 2018/11/15 10:05
     */
    public static final Message SUCCESS_MESSAGE;
    static {
        Map<String, Object> headTmp = new HashMap<>();
        headTmp.put(HEAD_STATUS, Status.SUCCESS_STATUS);
        SUCCESS_MESSAGE = new Message(Collections.unmodifiableMap(headTmp), null).setUnmodify();
    }

    public Message() {}

    public Message(Status status) {
        head = new HashMap<>();
        head.put(HEAD_STATUS, status);
    }

    public Message(Status status, Map<String, Object> body) {
        this(status);
        this.body = null != body ? new HashMap<>(body) : null;
    }

    public Message(Map<String, Object> head, Map<String, Object> body) {
        this.head = null != head ? new HashMap<>(head) : null;
        this.body = null != body ? new HashMap<>(body) : null;
    }

    /**
     * 报文头
     */
    private Map<String, Object> head;

    /**
     * 报文体
     */
    private Map<String, Object> body;

    @Override
    public Message clone() {
        return new Message(null != head ? new HashMap<>(head) : null,
                null !=body ? new HashMap<>(body) : null);
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(head) || Tools.isEmpty(body);
    }

    public Map<String, Object> getHead() {
        return head;
    }
    public void setHead(Map<String, Object> head) {
        if(isUnmodify()) {
            return;
        }
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }
    public void setBody(Map<String, Object> body) {
        if(isUnmodify()) {
            return;
        }
        this.body = body;
    }
}

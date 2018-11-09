package c332030.utils.data.model.message;

import c332030.utils.data.model.abstractclass.CUnmodify;
import c332030.utils.tools.Tools;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Message
 * @Description 通讯报文
 * @Author c332030
 * @Date 2018/10/30 10:07
 * @Version 1.0
 */
public class Message extends CUnmodify<Message> {
    private static final long serialVersionUID = -8586503429751196808L;

    public static final String HEAD_STATUS = "status";

    public Message() {}

    public Message(Status status) {
        head = new HashMap<>();
        head.put(HEAD_STATUS, status);
    }

    public Message(Status status, Map<String, Object> body) {
        this(status);
        this.body = new HashMap<>(body);
    }

    public Message(Map<String, Object> head, Map<String, Object> body) {
        this.head = new HashMap<>(head);
        this.body = new HashMap<>(body);
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

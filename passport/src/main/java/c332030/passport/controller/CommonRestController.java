package c332030.passport.controller;

import c332030.passport.model.VerifyCode;
import c332030.passport.tools.data.constant.AuthConstant;
import c332030.utils.data.model.message.Message;
import c332030.utils.data.model.message.Status;
import c332030.utils.tools.DataUtils;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommonRestController
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/14 21:15
 * @Version 1.0
 */
@RestController
public class CommonRestController extends LController {

    public static final Message ERROR_USERNAME = new Message(
            new Status("999999", "用户名错误！").setUnmodify()).setUnmodify();

    public static final Message ERROR_CODE = new Message(
            new Status("999999", "验证码错误！").setUnmodify()).setUnmodify();

    public static final Message SEND_TOO_MUCH_MESSAGE = new Message(
            new Status("999999", "一分钟只允许发送一次验证码！").setUnmodify()).setUnmodify();

    /**
     * @Description  TODO
     * @author c332030
     * @date 2018/11/15 9:31
     */
    @RequestMapping("SendVerifyCode")
    public Message sendVerifyCode(String username) {
        if(Tools.isEmpty(username)) {
            return ERROR_USERNAME;
        }

        username = DataUtils.deBase64(username);

        VerifyCode verifyCode = (VerifyCode) session.getAttribute(
                AuthConstant.Session.VERIFY_CODE);
        if(Tools.isEmpty(verifyCode)) {
            verifyCode = new VerifyCode(username);
        }

        if(username.equals(verifyCode.getUsername())) {
            if(verifyCode.notAllowReSend()) {
                return SEND_TOO_MUCH_MESSAGE;
            }
        } else {
            if(VerifyCode.notAllowReSend(verifyCode.getLastCodeTime())) {
                return SEND_TOO_MUCH_MESSAGE;
            }
            verifyCode.setUsername(username);
        }

        verifyCode.setCode("332030");

        LogUtils.debug(this, "验证码= " + verifyCode);

        session.setAttribute(AuthConstant.Session.VERIFY_CODE, verifyCode);


        Message message = Message.SUCCESS_MESSAGE.clone();
        Map<String, Object> bodyMap = new HashMap<>();
        message.setBody(bodyMap);

        bodyMap.put(VerifyCode.WAIT_TIMES_STR, VerifyCode.WAIT_TIMES);

        return message;
    }

    @RequestMapping("VerifyCode")
    public Message verifyCode(String username, String code) {

        if(Tools.isEmpty(username)
                || Tools.isEmpty(code)
            ) {
            return ERROR_CODE;
        }

        username = DataUtils.deBase64(username);
        code = DataUtils.deBase64(code);

        VerifyCode verifyCode = (VerifyCode) session.getAttribute(
                AuthConstant.Session.VERIFY_CODE);
        if(Tools.isEmpty(verifyCode)) {
            return ERROR_CODE;
        }

        if(username.equals(verifyCode.getUsername())
                && code.equals(verifyCode.getCode())
            ) {
            return Message.SUCCESS_MESSAGE;
        }

        return ERROR_CODE;

    }
}

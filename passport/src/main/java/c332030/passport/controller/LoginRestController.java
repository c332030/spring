package c332030.passport.controller;

import c332030.passport.model.LoginInfo;
import c332030.passport.model.User;
import c332030.passport.model.VerifyCode;
import c332030.passport.service.UserService;
import c332030.passport.tools.data.constant.AuthConstant;
import c332030.utils.comm.email.EmailUtils;
import c332030.utils.comm.phone.PhoneUtils;
import c332030.utils.data.model.message.Message;
import c332030.utils.data.model.message.Status;
import c332030.utils.tools.DataUtils;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import c332030.utils.tools.web.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginRestController
 * @Description 登录控制器，返回字符串
 * @Author c332030
 * @Date 2018-10-23 18:08
 * @Version 1.0
 */
@RestController
public class LoginRestController extends LController {

    /**
     * 用户名密码错误信息
     */
    public static final Message USERPWD_ERROR_MESSAGE =
            new Message(new Status("999999", "请检查用户名密码！")).setUnmodify();

    /**
     * 用户服务
     */
    @Autowired
    private UserService userService;

    @RequestMapping("VerifyLogin")
    public Message verifyLogin(String username, String password) {

//        LogUtils.debug(this, "username= " + username);
//        LogUtils.debug(this, "password= " + password);

        if(Tools.isEmpty(username)
                || Tools.isEmpty(password)
            ) {

            LogUtils.error(this, "用户名密码为空");
            return USERPWD_ERROR_MESSAGE;
        }

        try {
            username = DataUtils.deBase64(username);
            password = DataUtils.deBase64(password);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.FAILED_MESSAGE;
        }

        User user;
        if(PhoneUtils.isPhone(username)) {

            LogUtils.debug(this, "手机登录");
            user = userService.findByPhoneAndPwd(username, password);
        } else if(EmailUtils.isEmail(username)) {

            LogUtils.debug(this, "邮箱登录");
            user = userService.findByEmailAndPwd(username, password);
        } else {

            LogUtils.debug(this, "用户名登录");
            user = userService.findByUserAndPwd(username, password);
        }

        LogUtils.debug(this, "数据库返回的用户信息：" + user);

        if(Tools.isEmpty(user)) {
            return USERPWD_ERROR_MESSAGE;
        }

        LoginInfo loginInfo = verifyLoginLoginInfo(user);

        if(!lRedisUtils.lHSet(loginInfo)) {

            LogUtils.error(this, "登录信息对象存入 redis 失败");
            return Message.FAILED_MESSAGE;
        }

        return verifyLoginMessage();
    }

    /**
     * 处理单点登录的逻辑
     * @return
     */
    private LoginInfo verifyLoginLoginInfo(User user) {
        if(Tools.isEmpty(user)) {
            return null;
        }

        LoginInfo loginInfo = new LoginInfo(DataUtils.getUUID(), user);
        loginInfo.setDate(new SimpleDateFormat(LoginInfo.DATA_FORMAT).format(new Date()));

        String loginKey = LoginInfo.PRE_LOGIN_KEY
                + loginInfo.getDate()
                + LoginInfo.SPLIT
                + loginInfo.getKey();
        if(!CookieUtils.setLoginKey(response, DataUtils.enBase64(loginKey))) {

            LogUtils.error(this, "登录信息 key 存入 Cookie 失败！");
            return null;
        }

        return loginInfo;
    }

    /**
     * 用户名验证成功后数据返回
     * @return
     */
    private Message verifyLoginMessage() {

        Map<String, Object> bodyMap = new HashMap<>();

        bodyMap.put("username", "余巧玲");
        bodyMap.put("password", "余巧玲");
        bodyMap.put("url", "https://www.c332030.com");

        Message message = Message.SUCCESS_MESSAGE.clone();
        message.setBody(bodyMap);
        return message;
    }

    @RequestMapping("Registry")
    public Message registry(
            String username, String password, String code
    ) {
        if(Tools.isEmpty(username)
                || Tools.isEmpty(password)
                || Tools.isEmpty(code)
            ) {
            return Message.FAILED_MESSAGE;
        }

        username = DataUtils.deBase64(username);
        password = DataUtils.deBase64(password);
        code = DataUtils.deBase64(code);

        VerifyCode verifyCode = (VerifyCode) session.getAttribute(
                AuthConstant.Session.VERIFY_CODE);
        if(Tools.isEmpty(verifyCode)) {
            LogUtils.debug(this, "验证码为空！");
            return CommonRestController.ERROR_CODE;
        }

        if(!username.equals(verifyCode.getUsername())
                || !code.equals(verifyCode.getCode())
            ) {
            LogUtils.debug(this, "验证码校验失败！");
            return CommonRestController.ERROR_CODE;
        }

        User user = new User();
        if(PhoneUtils.isPhone(username)) {
            user.setPhone(username);
        } else if(EmailUtils.isEmail(username)) {
            user.setEmail(username);
        } else {
            user.setUsername(username);
        }

        user.setPassword(password);

        if(!userService.insert(user)) {
            LogUtils.debug(this, "插入失败！");
            return Message.FAILED_MESSAGE;
        }

        LogUtils.debug(this, "注册");
        return Message.SUCCESS_MESSAGE;
    }
}

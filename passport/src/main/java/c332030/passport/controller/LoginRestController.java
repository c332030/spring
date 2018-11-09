package c332030.passport.controller;

import c332030.passport.model.LoginInfo;
import c332030.passport.model.User;
import c332030.passport.service.UserService;
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
    private static final Message USERPWD_ERROR_MESSAGE =
            new Message(new Status("999999", "请检查用户名密码！")).setUnmodify();

    /**
     * 登录发生错误
     */
    private static final Message LOGIN_FAILED_MESSAGE =
            new Message(new Status("999999", "登录发生错误，请联系管理员！")).setUnmodify();

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
            return LOGIN_FAILED_MESSAGE;
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
            return LOGIN_FAILED_MESSAGE;
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

        return new Message(Status.SUCCESS_STATUS, bodyMap);
    }
}

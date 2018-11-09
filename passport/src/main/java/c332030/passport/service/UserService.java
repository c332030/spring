package c332030.passport.service;

import c332030.passport.mapper.UserMapper;
import c332030.passport.model.User;
import c332030.utils.data.service.Services;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Services {

    @Autowired
    private UserMapper userMapper;

    public boolean verifyUser(User user) {
        return userMapper.verifyUser(user) > 0;
    }

    public User findById(int id) {
        return userMapper.findById(id);
    }

    /**
     * 通过用户名密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUserAndPwd(String username, String password) {
        if(Tools.isEmpty(username)
            || Tools.isEmpty(password)
        ) {
            return null;
        }

        return userMapper.findByUserAndPwd(new User(username, password));
    }

    /**
     * 通过手机号码密码查询用户
     * @param phone
     * @param password
     * @return
     */
    public User findByPhoneAndPwd(String phone, String password) {
        if(Tools.isEmpty(phone)
                || Tools.isEmpty(password)
        ) {
            return null;
        }

        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);

        return userMapper.findByPhoneAndPwd(user);
    }

    /**
     * 通过电子邮件地址查询用户
     * @param email
     * @param password
     * @return
     */
    public User findByEmailAndPwd(String email, String password) {
        if(Tools.isEmpty(email)
                || Tools.isEmpty(password)
        ) {
            return null;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return userMapper.findByEmailAndPwd(user);
    }
}

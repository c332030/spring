package c332030.passport.service;

import c332030.passport.mapper.AuthMapper;
import c332030.passport.model.Auth;
import c332030.utils.data.service.Services;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 11:27
 * @Version 1.0
 */
@Service
public class AuthService implements Services {

    @Autowired
    private AuthMapper authMapper;

    public Auth findById(String authId) {
        if(Tools.isEmpty(authId)) {
            return null;
        }

        return authMapper.findById(authId);
    }

    public Auth findByIdAndSecret(String authId, String authSecret) {
        if(Tools.isEmpty(authId)
                || Tools.isEmpty(authSecret)
        ) {
            return null;
        }

        return authMapper.findByIdAndSecret(new Auth(authId, authSecret));
    }
}

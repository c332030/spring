package c332030.passport.mapper;

import c332030.passport.model.Auth;

/**
 * @ClassName AuthMapper
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 15:44
 * @Version 1.0
 */
public interface AuthMapper {

    /**
     * 通过授权 id 查询授权应用信息
     * @param auth_id
     * @return
     */
    Auth findById(String auth_id);

    /**
     * 通过授权 id 和授权码查询授权应用信息
     * @param auth
     * @return
     */
    Auth findByIdAndSecret(Auth auth);
}

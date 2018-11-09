package c332030.passport.mapper;

import c332030.passport.model.User;
import c332030.utils.data.mapper.Mapper;

public interface UserMapper extends Mapper {

    Integer verifyUser(User user);

    User findById(Integer id);

    User findByUserAndPwd(User user);
    User findByPhoneAndPwd(User user);
    User findByEmailAndPwd(User user);
}

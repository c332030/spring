package c332030.passport.mapper;

import c332030.passport.model.User;
import c332030.utils.data.mapper.Mapper;

public interface UserMapper extends Mapper {

    int verifyUser(User user);

    User findById(Integer id);

    User findByUserAndPwd(User user);
    User findByPhoneAndPwd(User user);
    User findByEmailAndPwd(User user);

    int insert(User user);
}

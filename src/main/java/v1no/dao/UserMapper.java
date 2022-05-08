package v1no.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import v1no.pojo.User;

import java.util.List;

public interface UserMapper {

    @Select("select * from users")
    List<User> selectAll();

    User selectByUsername(@Param("username") String username);
    User selectByUid(int uid);

    void add(User user);

    void update(User user);

    void deleteByUid(int uid);
}

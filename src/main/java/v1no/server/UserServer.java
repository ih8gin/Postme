package v1no.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import v1no.dao.UserMapper;
import v1no.pojo.User;
import v1no.utils.SqlSessionFactoryUtils;

import java.util.List;

public class UserServer {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 全选
     * @return user
     */
    public List<User> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);

        List<User> users = opts.selectAll();

        sqlSession.close();
        return users;
    }

    /**
     * 根据用户名查询用户
     * @return user
     */
    public User selectByUsername(String username){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);


        User user = opts.selectByUsername(username);

        sqlSession.close();
        return user;
    }

    /**
     * 根据uid查询用户
     * @return user
     */
    public User selectByUid(int uid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);


        User user = opts.selectByUid(uid);

        sqlSession.close();
        return user;
    }

    /**
     * 注册
     * @param user
     */
    public void add(User user){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);

        opts.add(user);

        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 更新
     * @param user
     */
    public void update(User user){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);

        opts.update(user);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 注销
     * @param uid
     */
    public void deleteByUid(int uid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper opts = sqlSession.getMapper(UserMapper.class);

        opts.deleteByUid(uid);

        sqlSession.commit();
        sqlSession.close();
    }
}

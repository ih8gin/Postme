package v1no.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import v1no.dao.PostMapper;
import v1no.pojo.Post;
import v1no.utils.SqlSessionFactoryUtils;

import java.util.List;

public class PostServer {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 全选
     * @return user
     */
    public List<Post> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        List<Post> posts = opts.selectAll();

        sqlSession.close();
        return posts;
    }

    /**
     * 查询用户发贴
     * @param uid
     * @return
     */
    public List<Post> selectByUid(int uid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        List<Post> posts = opts.selectByUid(uid);

        sqlSession.close();
        return posts;
    }

    /**
     * 根据id查询贴子
     * @param pid
     */
    public Post selectByPid(int pid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        Post post = opts.selectByPid(pid);

        sqlSession.close();
        return post;
    }

    /**
     * 根据id删除贴子
     * @param pid
     */
    public void deleteByPid(int pid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        opts.deleteByPid(pid);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 更新贴子主题、内容和状态
     * @param post
     */
    public void update(Post post){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        opts.update(post);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 发布贴子
     * @param post
     */
    public void add(Post post){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper opts = sqlSession.getMapper(PostMapper.class);

        opts.insert(post);

        sqlSession.commit();
        sqlSession.close();
    }
}

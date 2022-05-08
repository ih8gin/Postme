package v1no.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import v1no.dao.CommentMapper;
import v1no.pojo.Comment;
import v1no.utils.SqlSessionFactoryUtils;

import java.util.List;

public class CommentServer {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 全选
     * @return user
     */
    public List<Comment> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        List<Comment> comments = opts.selectAll();

        sqlSession.close();
        return comments;
    }

    /**
     * 根据id查询评论
     * @param cid
     * @return
     */
    public Comment selectByCid(int cid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        Comment comment = opts.selectByCid(cid);

        sqlSession.close();
        return comment;
    }

    /**
     * 查询用户所有评论
     * @param uid
     * @return
     */
    public List<Comment> selectByUid(int uid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        List<Comment> comments = opts.selectByUid(uid);

        sqlSession.close();
        return comments;
    }

    /**
     * 查询贴子下所有评论
     * @param pid
     */
    public List<Comment> selectByPid(int pid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        List<Comment> comments = opts.selectByPid(pid);

        sqlSession.close();
        return comments;
    }

    /**
     * 根据id删除评论
     * @param cid
     */
    public void deleteByCid(int cid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        opts.deleteByCid(cid);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 发布评论
     * @param comment
     */
    public void add(Comment comment){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper opts = sqlSession.getMapper(CommentMapper.class);

        opts.insert(comment);

        sqlSession.commit();
        sqlSession.close();
    }
}

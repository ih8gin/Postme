package v1no.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import v1no.dao.ReplyMapper;
import v1no.pojo.Reply;
import v1no.utils.SqlSessionFactoryUtils;

import java.util.List;

public class ReplyServer {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 全选
     * @return user
     */
    public List<Reply> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);

        List<Reply> replies = opts.selectAll();

        sqlSession.close();
        return replies;
    }

    /**
     * 根据id查询回复
     * @param rid
     * @return
     */
    public Reply selectByRid(int rid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);

        Reply comment = opts.selectByRid(rid);

        sqlSession.close();
        return comment;
    }

    /**
     * 查询用户所有回复
     * @param uid
     * @return
     */
    public List<Reply> selectByUid(int uid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);

        List<Reply> comments = opts.selectByUid(uid);

        sqlSession.close();
        return comments;
    }

    /**
     * 查询贴子下所有回复
     * @param pid
     */
    public List<Reply> selectByPre(int pid, int cid, int rid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);


        List<Reply> replies = opts.selectByPre(pid, cid, rid);

        sqlSession.close();
        return replies;
    }

    /**
     * 根据id删除回复
     * @param rid
     */
    public void deleteByRid(int rid){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);

        opts.deleteByRid(rid);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 发布回复
     * @param reply
     */
    public void add(Reply reply){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReplyMapper opts = sqlSession.getMapper(ReplyMapper.class);

        opts.insert(reply);

        sqlSession.commit();
        sqlSession.close();
    }
}

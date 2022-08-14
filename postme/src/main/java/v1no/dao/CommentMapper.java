package v1no.dao;

import org.apache.ibatis.annotations.Select;
import v1no.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    @Select("select * from comments")
    List<Comment> selectAll();

    List<Comment> selectTopN(int num);

    Comment selectByCid(int cid);

    List<Comment> selectByUid(int uid);

    List<Comment> selectByPid(int pid);

    void deleteByCid(int cid);

    void insert(Comment comment);
}

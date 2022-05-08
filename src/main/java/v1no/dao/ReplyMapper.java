package v1no.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import v1no.pojo.Reply;

import java.util.List;

public interface ReplyMapper {

    @Select("select * from replies")
    List<Reply> selectAll();

    List<Reply> selectTopN(int num);

    Reply selectByRid(int rid);

    List<Reply> selectByUid(int uid);

    void deleteByRid(int rid);

    void insert(Reply reply);

    List<Reply> selectByPre(@Param("pid")int pid, @Param("cid")int cid, @Param("rid")int rid);
}

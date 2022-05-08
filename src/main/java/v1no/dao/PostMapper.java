package v1no.dao;

import org.apache.ibatis.annotations.Select;
import v1no.pojo.Post;

import java.util.List;

public interface PostMapper {

    @Select("select * from posts")
    List<Post> selectAll();

    List<Post> selectTopN(int num);

    Post selectByPid(int pid);

    List<Post> selectByUid(int uid);

    void deleteByPid(int pid);

    void update(Post post);

    void insert(Post post);
}

package v1no.pojo;

public class Post {
    private Integer pid;        //贴子id，唯一标识
    private Integer uid;        //发贴用户id
    private String username;    //发贴用户昵称
    private String postTime;    //发布时间
    private String updateTime;  //最近更新时间
    private String title;       //标题
    private String content;     //正文
    private Integer visitNum;   //访问量
    private Integer replyNum;   //评论数
    private Integer likeNum;    //点赞数
    private Integer status;     //状态标识位

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", postTime='" + postTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", visitNum=" + visitNum +
                ", replyNum=" + replyNum +
                ", likeNum=" + likeNum +
                ", status=" + status +
                '}';
    }
}

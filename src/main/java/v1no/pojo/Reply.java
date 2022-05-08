package v1no.pojo;

public class Reply {
    private Integer rid;
    private Integer uid;
    private String username;    //发贴用户昵称
    private Integer pid;
    private Integer cid;
    private Integer preRid;
    private String content;
    private Integer likeNum;
    private Integer status;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPreRid() {
        return preRid;
    }

    public void setPreRid(Integer preRid) {
        this.preRid = preRid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Reply{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", preRid=" + preRid +
                ", content='" + content + '\'' +
                ", likeNum=" + likeNum +
                ", status=" + status +
                '}';
    }
}

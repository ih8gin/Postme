package v1no.web.Visit;

import v1no.pojo.Comment;
import v1no.pojo.Post;
import v1no.pojo.Reply;
import v1no.server.CommentServer;
import v1no.server.PostServer;
import v1no.server.ReplyServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/replySelectForReplyServlet")
public class ReplySelectForReply extends HttpServlet {
    private PostServer postServer = new PostServer();
    private CommentServer commentServer = new CommentServer();
    private ReplyServer replyServer = new ReplyServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查询一条回复所属的贴子及评论
         */
        int pid = Integer.parseInt(request.getParameter("pid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        int rid = Integer.parseInt(request.getParameter("rid"));
        Post post = postServer.selectByPid(pid);
        Comment comment = commentServer.selectByCid(cid);
        Reply reply = replyServer.selectByRid(rid);

        request.setAttribute("post", post);
        request.setAttribute("comment", comment);
        request.setAttribute("reply", reply);

        request.getRequestDispatcher("Visit/replyToReply.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
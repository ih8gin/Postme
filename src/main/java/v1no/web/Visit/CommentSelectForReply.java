package v1no.web.Visit;

import v1no.pojo.Comment;
import v1no.pojo.Post;
import v1no.server.CommentServer;
import v1no.server.PostServer;
import v1no.server.ReplyServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/commentSelectForReplyServlet")
public class CommentSelectForReply extends HttpServlet {
    private PostServer postServer = new PostServer();
    private CommentServer commentServer = new CommentServer();
    private ReplyServer replyServer = new ReplyServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 根据id查询一个评论
         * 并查询其下的回复
         */
        String pid = request.getParameter("pid");
        String cid = request.getParameter("cid");
        Post post = postServer.selectByPid(Integer.parseInt(pid));
        Comment comment = commentServer.selectByCid(Integer.parseInt(cid));
        request.setAttribute("post", post);
        request.setAttribute("comment", comment);

        request.getRequestDispatcher("Visit/replyToComment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
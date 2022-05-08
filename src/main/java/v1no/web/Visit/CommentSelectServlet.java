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
import java.util.List;

@WebServlet("/commentSelectServlet")
public class CommentSelectServlet extends HttpServlet {
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
        List<Reply> replies = replyServer.selectByPre(Integer.parseInt(pid), Integer.parseInt(cid), 0);
        request.setAttribute("post", post);
        request.setAttribute("comment", comment);
        request.setAttribute("replies", replies);

        request.getRequestDispatcher("Visit/replyDisplay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
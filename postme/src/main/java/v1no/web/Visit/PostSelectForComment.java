package v1no.web.Visit;

import v1no.pojo.Comment;
import v1no.pojo.Post;
import v1no.server.CommentServer;
import v1no.server.PostServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/postSelectForCommentServlet")
public class PostSelectForComment extends HttpServlet {
    private PostServer postServer = new PostServer();
    private CommentServer commentServer = new CommentServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查询一个贴子的详细信息以及其评论
         */
        String pid = request.getParameter("pid");
        Post post = postServer.selectByPid(Integer.parseInt(pid));
        List<Comment> comments = commentServer.selectByPid(Integer.parseInt(pid));
        request.setAttribute("post", post);
        request.setAttribute("comments", comments);

        request.getRequestDispatcher("Visit/commentWrite.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
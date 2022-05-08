package v1no.web.User;

import v1no.pojo.Post;
import v1no.server.PostServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
    private PostServer server = new PostServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 修改贴子标题、正文、状态
         * 更新提交时间
         */
        String pid = request.getParameter("pid");
        Post post = server.selectByPid(Integer.parseInt(pid));
        post.setTitle(request.getParameter("title"));
        post.setContent(request.getParameter("content"));
        post.setStatus(Integer.parseInt(request.getParameter("status")));
        server.update(post);

        request.getRequestDispatcher("/infoDisplayServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
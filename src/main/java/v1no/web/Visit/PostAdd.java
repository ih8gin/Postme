package v1no.web.Visit;

import v1no.pojo.Post;
import v1no.server.PostServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postAddServlet")
public class PostAdd extends HttpServlet {
    private PostServer server = new PostServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 发布贴子，将贴子加入库中
         */
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("visitor");
        String visitorName = (String)session.getAttribute("visitorName");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Post post = new Post();
        post.setUid(uid);
        post.setUsername(visitorName);
        post.setTitle(title);
        post.setContent(content);
        server.add(post);

        request.getRequestDispatcher("/postDisplayServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
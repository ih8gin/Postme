package v1no.web.Visit;

import v1no.pojo.Post;
import v1no.server.PostServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/postDisplayServlet")
public class PostDisplay extends HttpServlet {
    private PostServer server = new PostServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查询首页上的推荐贴
         */
        List<Post> posts = server.selectAll();
        request.setAttribute("posts", posts);

        request.getRequestDispatcher("Visit/postDisplay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
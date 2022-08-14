package v1no.web.User;

import v1no.pojo.Post;
import v1no.server.PostServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postSelectForUpdateServlet")
public class PostSelectForUpdate extends HttpServlet {
    private PostServer server = new PostServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查找待修改的贴子信息
         * 回显至修改页面
         */
        String pid = request.getParameter("pid");
        Post post = server.selectByPid(Integer.parseInt(pid));
        request.setAttribute("post", post);

        request.getRequestDispatcher("User/postUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
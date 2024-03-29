package v1no.web.User;

import v1no.server.PostServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postDeleteServlet")
public class PostDelete extends HttpServlet {
    private PostServer server = new PostServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 删除贴子
         * 跳转回用户详情页面
         */
        String pid = request.getParameter("pid");
        server.deleteByPid(Integer.parseInt(pid));

        request.getRequestDispatcher("/userInfoSelectForDisplayServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
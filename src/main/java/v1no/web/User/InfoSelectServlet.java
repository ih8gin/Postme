package v1no.web.User;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/infoSelectServlet")
public class InfoSelectServlet extends HttpServlet {
    private UserServer server = new UserServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查找待修改的贴子信息回显至修改页面
         */
        String uid = request.getParameter("uid");
        User user = server.selectByUid(Integer.parseInt(uid));
        request.setAttribute("user", user);

        request.getRequestDispatcher("User/infoUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
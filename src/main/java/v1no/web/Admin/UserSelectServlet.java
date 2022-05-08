package v1no.web.Admin;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userSelectServlet")
public class UserSelectServlet extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查询一个用户
         */
        String uid = request.getParameter("uid");
        User user = server.selectByUid(Integer.parseInt(uid));
        request.setAttribute("user", user);

        request.getRequestDispatcher("Admin/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
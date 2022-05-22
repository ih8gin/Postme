package v1no.web.Admin;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userSelectAllServlet")
public class UserSelectAll extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 显示所有用户信息
         */
        List<User> users = server.selectAll();
        request.setAttribute("users", users);

        request.getRequestDispatcher("Admin/allUsers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
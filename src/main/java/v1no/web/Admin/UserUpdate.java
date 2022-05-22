package v1no.web.Admin;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userUpdateServlet")
public class UserUpdate extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*
         * 更新用户信息
         */
        String uid = request.getParameter("uid");
        User user = server.selectByUid(Integer.parseInt(uid));
        user.setSubName(request.getParameter("subName"));
        user.setPassword(request.getParameter("password"));
        user.setStatus(Integer.parseInt(request.getParameter("status")));

        server.update(user);

        request.getRequestDispatcher("/userSelectAllServlet").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
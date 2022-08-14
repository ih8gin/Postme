package v1no.web.Admin;

import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userDeleteServlet")
public class UserDelete extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 删除用户信息
         */
        String uid = request.getParameter("uid");
        server.deleteByUid(Integer.parseInt(uid));

        request.getRequestDispatcher("/userSelectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
package v1no.web.User;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class Register extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /*
         * 检查用户名是否存在
         * 不存在则添加到库中
         * 完成添加后跳转到login页面
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");

        if(server.selectByUsername(username) != null){
            request.setAttribute("errMsg","用户名已被注册，请换一个！");
            request.getRequestDispatcher("User/register.jsp").forward(request, response);
        }else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setGender(Integer.parseInt(gender));
            user.setTelephone(telephone);
            server.add(user);
            request.getRequestDispatcher("User/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
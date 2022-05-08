package v1no.web.User;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /*
         * 检查用户名是否存在
         * 用户名存在则将username写入cookie（可选）
         * 检查密码是否正确
         * 密码正确则跳转至主页面，并将username写入session，同时将password写入cookie（可选）
         */

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User usr = server.selectByUsername(username);
        Writer writer = response.getWriter();
        if(usr != null){
            if(password.equals(usr.getPassword())){
                System.out.println(username + "登陆成功");
                if("1".equals(remember)){ // 登陆成功则保存账号密码一天
                    Cookie c_username = new Cookie("username", username);
                    Cookie c_password = new Cookie("password", password);
                    c_username.setMaxAge(60*60*24);
                    c_password.setMaxAge(60*60*24);
                    response.addCookie(c_username);
                    response.addCookie(c_password);
                }

                HttpSession session = request.getSession();
                session.setAttribute("visitor", usr.getUid());
                session.setAttribute("visitorName", usr.getSubName());
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath+"/postDisplayServlet");
            }else{
                if("1".equals(remember)){ // 登陆失败则保存账号一个小时
                    Cookie c_username = new Cookie("username", username);
                    c_username.setMaxAge(60*60);
                    response.addCookie(c_username);
                }
                request.setAttribute("errMsg", "密码错误！");
                request.getRequestDispatcher("User/login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("errMsg", "用户名不存在！");
            request.getRequestDispatcher("User/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
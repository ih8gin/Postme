package v1no.web.User;

import v1no.pojo.User;
import v1no.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/infoUpdateServlet")
public class InfoUpdateServlet extends HttpServlet {
    private UserServer server = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 修改个人信息
         */
        String uid = request.getParameter("uid");
        String subName = request.getParameter("subName");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String telephone = request.getParameter("telephone");
        String description = request.getParameter("description");
        String password = request.getParameter("password");

        System.out.println(subName);

        User user = server.selectByUid(Integer.parseInt(uid));
        user.setSubName(subName);
        user.setGender(Integer.parseInt(gender));
        user.setAge(Integer.parseInt(age));
        user.setTelephone(telephone);
        user.setDescription(description);
        user.setPassword(password);

        server.update(user);

        request.getRequestDispatcher("/infoDisplayServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
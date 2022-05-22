package v1no.web.User;

import v1no.pojo.Post;
import v1no.pojo.User;
import v1no.server.PostServer;
import v1no.server.UserServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userInfoSelectForDisplayServlet")
public class UserInfoSelectForDisplay extends HttpServlet {
    private PostServer postServer = new PostServer();
    private UserServer userServer = new UserServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 从user中查用户信息
         * 从post中查该用户发送的贴
         * 检查是否是本人，不是本人则隐藏修改选项
         */
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("visitor");
        User user = userServer.selectByUid(uid);
        List<Post> posts = postServer.selectByUid(user.getUid());

        request.setAttribute("user", user);
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("User/userInfoDisplay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
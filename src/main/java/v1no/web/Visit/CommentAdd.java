package v1no.web.Visit;

import v1no.pojo.Comment;
import v1no.server.CommentServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/commentAddServlet")
public class CommentAdd extends HttpServlet {
    private CommentServer commentServer = new CommentServer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 将用户写入的评论信息存入数据库
         */
        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("visitor");
        String visitorName = (String)session.getAttribute("visitorName");
        String pid = request.getParameter("pid");
        String content = request.getParameter("content");

        Comment comment = new Comment();
        comment.setUid(uid);
        comment.setUsername(visitorName);
        comment.setPid(Integer.parseInt(pid));
        comment.setContent(content);

        commentServer.add(comment);

        request.getRequestDispatcher("/postSelectForDisplayServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
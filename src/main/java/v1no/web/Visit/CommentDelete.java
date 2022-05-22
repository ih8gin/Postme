package v1no.web.Visit;

import v1no.server.CommentServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/commentDeleteServlet")
public class CommentDelete extends HttpServlet {
    private CommentServer server = new CommentServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 删除某条评论
         * 写此条评论的用户本人和评论所在主题帖所有者有删除权限
         * 跳转回贴子内容展开页面
         */
        String pid = request.getParameter("pid");
        String cid = request.getParameter("cid");
        server.deleteByCid(Integer.parseInt(cid));

        request.getRequestDispatcher("/postSelectForDisplayServlet?pid="+pid).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
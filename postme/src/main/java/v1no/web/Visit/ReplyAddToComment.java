package v1no.web.Visit;

import v1no.pojo.Reply;
import v1no.server.ReplyServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/replyToCommentServlet")
public class ReplyAddToComment extends HttpServlet {
    private ReplyServer replyServer = new ReplyServer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
         * 将回复内容存入数据库
         * 增加贴子回复数、增加评论回复数
         */

        HttpSession session = request.getSession();
        int uid = (int)session.getAttribute("visitor");
        String username = (String)session.getAttribute("visitorName");
        String pid = request.getParameter("pid");
        String cid = request.getParameter("cid");
        String content = request.getParameter("content");

        Reply reply = new Reply();
        reply.setUid(uid);
        reply.setUsername(username);
        reply.setPid(Integer.parseInt(pid));
        reply.setCid(Integer.parseInt(cid));
        reply.setPreRid(0);
        reply.setContent(content);

        replyServer.add(reply);

        request.getRequestDispatcher("/commentSelectForDisplayServlet?pid="+pid+"&cid="+cid).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
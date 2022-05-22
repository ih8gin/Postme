package v1no.web.Visit;

import v1no.pojo.Reply;
import v1no.server.ReplyServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/replyToReplyServlet")
public class ReplyAddToReply extends HttpServlet {
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
        String rid = request.getParameter("rid");
        String content = request.getParameter("content");

        Reply reply = new Reply();
        reply.setUid(uid);
        reply.setUsername(username);
        reply.setPid(Integer.parseInt(pid));
        reply.setCid(Integer.parseInt(cid));
        reply.setPreRid(Integer.parseInt(rid));
        reply.setContent(content);

        replyServer.add(reply);

        request.getRequestDispatcher("/commentSelectForDisplayServlet?pid="+pid+"&cid="+cid).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
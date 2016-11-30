import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DonBusLine extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Don-BusLine</title><style> body { background: #a6bdd7 url(images/route.jpg); color: #fff; }</style></head><body>");
        out.println("<h2>Пожалуйста, введите ваши данные. Мы вам перезвоним.</h2>");
        out.println("<form method =\"post\" action =\"" + request.getContextPath()+"/\" >");
        out.println("<table border =\"0\"><tr><td valign=\"top\">");
        out.println("Ваше имя:</td> <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"name\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Телефон: </td> <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"phone\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("<input type=\"submit\" value=\"Отправить\"></td></tr>");
        out.println("</table></form>");
        out.println("</body></html>");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        Enumeration paramNames = request.getParameterNames();

        boolean emptyEnum = false;
        if (!paramNames.hasMoreElements()) {
            emptyEnum = true;
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Отправленные параметры</title></head><body>");

        if (emptyEnum) {
            out.println("<h2>Запрос не содержит параметров</h2>");
        } else {
            String name = request.getParameter("name");
            String number = request.getParameter("phone");
            out.println("<h2>Ожидайте, мы вам перезвоним "+name+".</h2>");
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost("https://api.telegram.org/bot230567871:AAFsg6Ijzetf5uzGY_FTmdzYNM7LfD1Z-DI/sendMessage");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addTextBody("chat_id", "-1001071572976",ContentType.TEXT_PLAIN);
            builder.addTextBody("text",name+" "+number, ContentType.create("text/plain", MIME.UTF8_CHARSET));
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            CloseableHttpResponse httpResponse =  httpClient.execute(uploadFile);
            System.out.println(httpResponse.toString());
        }
    }
}

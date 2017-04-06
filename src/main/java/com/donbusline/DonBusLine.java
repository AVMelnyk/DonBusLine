package com.donbusline;

import com.google.i18n.phonenumbers.NumberParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DonBusLine extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("path",path);
        request.setAttribute("severity", "empty");
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String start_point = request.getParameter("start_point");
        String end_point = request.getParameter("end_point");
        String date = request.getParameter("data");
        String birthdate = request.getParameter("birthdate");
        String time = request.getParameter("time");
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String number = request.getParameter("tel");
        String comment = request.getParameter("comment");
        CallbackModel model = new CallbackModel(start_point, end_point, surname, name, birthdate, number, date, time, comment);
        response.setContentType("text/html;charset=utf-8");
        if (model.validePhoneNumber(number)&&date.length()>0&&birthdate.length()>0&& time.length()>0&&surname.length()>0&&name.length()>0 ) {
            request.setAttribute("name", name);
            model.notifyRecipient();
            request.setAttribute("severity", "success");
            request.setAttribute("message", "Ожидайте, мы вам перезвоним, " + name + ".");
        } else {
            request.setAttribute("severity", "warning");
            request.setAttribute("message", "Для заказа билета заполните обязательные поля и введите корректный номер телефона.");
            System.out.println("Invalid Number");
        }
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}

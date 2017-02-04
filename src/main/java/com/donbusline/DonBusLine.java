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
        String name = request.getParameter("name");
        String number = request.getParameter("tel");

        CallbackModel model = new CallbackModel(name,number);
        response.setContentType("text/html;charset=utf-8");
        if (model.validePhoneNumber(number)) {
            request.setAttribute("name", name);
            model.notifyRecipient();
            request.setAttribute("severity", "success");
            request.setAttribute("message", "Ожидайте, мы вам перезвоним, " + name + ".");
        } else {
            request.setAttribute("severity", "warning");
            request.setAttribute("message", "Введите корректный номер телефона.");
            System.out.println("Invalid Number");
        }
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}

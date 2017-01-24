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
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String number = request.getParameter("tel");
        try {
            new PhoneNumberValidator().validePhoneNumber(number);
            request.setAttribute("name", name);
            new CallbackModel(name, number).notifyRecipient();
            response.setContentType("text/html;charset=utf-8");
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
        catch (NumberParseException e){
            response.setContentType("text/html;charset=utf-8");
            request.getRequestDispatcher("/invalidPhoneNumber.jsp").forward(request, response);
            System.out.println(number);
            System.out.println("NumberParseException");
        }
        catch (PhoneNumberValidator.InvalidPhoneNumberException e){
            response.setContentType("text/html;charset=utf-8");
            request.getRequestDispatcher("/invalidPhoneNumber.jsp").forward(request, response);
            System.out.println("Invalid Nmber");
        }
    }
}

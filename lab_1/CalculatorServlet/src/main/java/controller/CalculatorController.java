package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorController extends HttpServlet {
    Calculator calculator=new Calculator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/calculator/calculator.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add1 = req.getParameter("add1").trim() ;
        String add2 = req.getParameter("add2").trim();
        String mult1 = req.getParameter("mult1").trim();
        String mult2 = req.getParameter("mult2").trim();
        calculator.setAdd1(Integer.parseInt(add1));
        calculator.setAdd2(Integer.parseInt(add2));
        calculator.setMult1(Integer.parseInt(mult1));
        calculator.setMult2(Integer.parseInt(mult2));
        String sum = "";
        String product = "";

        // Check for valid inputs....
        try {
            sum = "" + (calculator.getAdd1()+calculator.getAdd2());
        } catch(NumberFormatException e) {
            if (add1.isEmpty()) add1 = "''";
            if (add2.isEmpty()) add2 = "''";
            sum = "''";
        }

        /*
         * Integer.parseInt(str) throws NumberFormatException
         * if the string cannot be converted to an integer.
         */

        try {

            product = "" + (calculator.getMult1() * calculator.getMult2());
        } catch(NumberFormatException e) {
            if (mult1.isEmpty()) mult1 = "''";
            if (mult2.isEmpty()) mult2 = "''";
            product = "''";
        }
        req.setAttribute("calculator",calculator);
        req.setAttribute("sum",sum);
        req.setAttribute("product",product);
        req.getRequestDispatcher("WEB-INF/calculator/result.jsp").forward(req,resp);

    }
}

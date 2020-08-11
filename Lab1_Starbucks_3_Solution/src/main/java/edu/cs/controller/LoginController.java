package edu.cs.controller;

import edu.data.DataFacade;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/action/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/solution/advice.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = request.getServletContext();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
        String expectedPassword = data.findPassword(name);

        if(expectedPassword == null || !expectedPassword.equals(password)) {

            response.sendRedirect("/WEB-INF/solution/index.jsp");
        } else {

            request.getRequestDispatcher("/WEB-INF/solution/successful-page.jsp").forward(request,response);
        }
    }
}


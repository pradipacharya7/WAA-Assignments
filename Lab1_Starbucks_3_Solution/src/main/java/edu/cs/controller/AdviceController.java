package edu.cs.controller;

import edu.data.DataFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/action/advice")
public class AdviceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roast = request.getParameter("roast");

        DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
        List<String> advice = data.getAdvice(roast);
        request.setAttribute("advices",advice);
        request.getRequestDispatcher("/WEB-INF/solution/display.jsp").forward(request,response);
//        String adviceOutput = prepareAdviceOutput(roast, advice);

//        response.setContentType("text/html");
//        response.setHeader("Cache-Control", "no-cache");
//        PrintWriter writer = response.getWriter();
//        writer.println(adviceOutput);
    }
//    private String prepareAdviceOutput(String roast, List<String> advice) {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("<!DOCTYPE html>\n");
//        sb.append("<html><head> </head>\n");
//        sb.append("<body><form action=\"../action/login\" method=\"get\">\n");
//
//        sb.append("Starbuck's " + roast.toUpperCase() + " Roast Coffees:");
//
//        sb.append("<table>\n");
//        for( int i=0;i<advice.size();i++) {
//            if (i%2 == 0)  sb.append("<tr style=\"background-color:cyan\">");
//            else sb.append("<tr style=\"background-color:yellow\">");
//
//            sb.append("<td>" + advice.get(i) + "</td></tr>\n");
//
//        }
//        sb.append("</table>\n");
//
//        sb.append("<input type=\"submit\" value=\"Back\">\n");
//        sb.append("</body></html>");
//        return sb.toString();
//    }
}

package my_package_calc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/calculate")
public class CalculatorServlet  extends HttpServlet {
     @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String coreModel = request.getParameter("coreModel");
        // Perform calculations...
        request.setAttribute("coreModel", coreModel);
        // Forward results to JSP or send a response back
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

}

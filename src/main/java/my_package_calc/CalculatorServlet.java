package my_package_calc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String coreModel = request.getParameter("coreModel");
        double coreVolume = Double.parseDouble(request.getParameter("coreVolume"));
        double magneticLength = Double.parseDouble(request.getParameter("magneticLength"));
        double crossSectionArea = Double.parseDouble(request.getParameter("crossSection"));
        double windowArea = Double.parseDouble(request.getParameter("windowArea"));

        // Sample calculations (replace these with actual logic)
        double coreFactor = coreVolume * magneticLength;
        double effectiveLength = magneticLength * crossSectionArea;
        double effectiveArea = coreVolume / magneticLength;
        double minimumArea = windowArea * crossSectionArea;

        // Set attributes to forward to JSP
        request.setAttribute("coreFactor", coreFactor);
        request.setAttribute("effectiveVolume", coreVolume);
        request.setAttribute("effectiveLength", effectiveLength);
        request.setAttribute("effectiveArea", effectiveArea);
        request.setAttribute("minimumArea", minimumArea);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}

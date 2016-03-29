package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buy.org.bean.BuyBean;

public class Controller extends HttpServlet {
	static final long serialVersionUID = 2812134262646769591L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create a JavaBean for the registration
		BuyBean bb = new BuyBean();

		// set simple String properties
		bb.setName(request.getParameter("name"));
		bb.setLastname(request.getParameter("lastname"));
		bb.setOption(request.getParameter("option"));

		
		 bb.setName("name");
		 bb.setLastname("lastname");
		 bb.setOption("option");
		 
		 
		 request.setAttribute("BuyBean", "bean");
		 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		 
		 // store the Bean reference in the session
		HttpSession session = request.getSession();
		session.setAttribute("regBean", bb);

		// redirect the request to the JSP
		rd.forward(request, response);
	}
}

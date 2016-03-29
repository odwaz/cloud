package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import conference.RegistrationBean;
import dao.RegistrationDAO;

@SuppressWarnings("serial")
public class InsertRegistration extends HttpServlet implements Servlet {
	private DataSource ds;

	private RegistrationDAO dao = new RegistrationDAO();

	public void init() throws ServletException {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			ctx.close();
			dao.setDataSource(ds);
		} catch (NamingException e) {
			throw new ServletException(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Insert Results</title></head>");
		out.println("<img src='logo.jpg'>");
		out.println("<h2>Insert Results</h2>");

		// create a RegistrationBean and initialize it
		// from the request
		RegistrationBean rb = new RegistrationBean();
		rb.setAddress(request.getParameter("address"));
		rb.setAttendees(Integer.parseInt(request.getParameter("attendees")));
		rb.setCds(Integer.parseInt(request.getParameter("cds")));
		rb.setCity(request.getParameter("city"));
		rb.setDate(new Date());

		if (request.getParameter("guildmember") != null)
			rb.setGuildmember(true);
		else
			rb.setGuildmember(false);

		rb.setName(request.getParameter("name"));
		rb.setState(request.getParameter("state"));
		rb.setZip(request.getParameter("zip"));

		int confirmNum = -1;
		try {
			confirmNum = dao.insertRegistration(rb);
			out.println("<p>Insert successful, ");
			out.println("confirmation number: " + confirmNum);
			out.println("</p>");
		} catch (SQLException e) {
			out.println("An error occurred: " + e.getMessage());
		}

		out.println("</body></html>");
	}
}

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

import order.Order;
import OrderDAO.orderDAO;

@SuppressWarnings("serial")
public class Controller extends HttpServlet implements Servlet
{
    private DataSource ds;

    private orderDAO dao = new orderDAO();

    public void init() throws ServletException
    {
        try
        {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
            ctx.close();
            dao.setDataSource(ds);
        }
        catch (NamingException e)
        {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Insert Results</title></head>");
        out.println("<img src='logo.jpg'>");
        out.println("<h2>Insert Results</h2>");
        
        // create a RegistrationBean and initialize it
        // from the request        
        Order rb = new Order();
        rb.setAddress(request.getParameter("address"));
        rb.setCount(Integer.parseInt(request.getParameter("Count")));
       
        rb.setCity(request.getParameter("city"));

       
        
        rb.setName(request.getParameter("name"));
       
        
        int confirmNum = -1;
        try
        {
            confirmNum = dao.insertRegistration(rb);
            out.println("<p>Insert successful, ");
            out.println("confirmation number: " + confirmNum);
            out.println("</p>");
        }
        catch (SQLException e)
        {
            out.println("An error occurred: " + e.getMessage());
        }

        out.println("</body></html>");
    }
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
import dao.RegistrationNotFoundException;

@SuppressWarnings("serial")
public class FindRegistration extends HttpServlet implements Servlet
{
    private DataSource ds;              
    private RegistrationDAO dao = new RegistrationDAO();

    public void init() throws ServletException
    {
        try
        {
            InitialContext ctx = new InitialContext();
            ds = (DataSource)ctx.lookup ("java:comp/env/jdbc/TestDB" );
            ctx.close();
            dao.setDataSource(ds);
        }
        catch (NamingException e)
        {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            
        out.println("<html>");
        out.println("<head><title>Find Results</title></head>");
        out.println("<img src='logo.jpg'>");
        out.println("<h2>Find Results</h2>");
        
        String s = request.getParameter("confirmNum");
        int confirmNum = -1;
        try
        {
            confirmNum = Integer.parseInt(s);
            
            try
            {
                RegistrationBean rb = dao.findRegistration(confirmNum);
                
                out.println("<p><b>Confirmation number:</b> " + rb.getConfirmationNumber() + "</p>");
                out.println("<p><b>Name:</b> " + rb.getName() + "</p>");
                out.println("<p><b>Amount Due:</b> " + rb.getAmountDue() + "</p>");
            } 
            catch (RegistrationNotFoundException e)
            {
                out.println("Confirmation number: " + confirmNum + " not found");
            } 
            catch (Exception e)
            {
                out.println("<p>An error occurred: " + e.getMessage() + "</p>");
            }           
        } 
        catch (NumberFormatException e1)
        {
            out.println("<p>Please enter a numeric confirmation number.</p>");
        }
                
        out.println("</body></html>");
    }
}

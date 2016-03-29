package servlets;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conference.RegistrationBean;

public class Controller extends HttpServlet
{
	static final long serialVersionUID = -2812134262646769591L;	
	
    public void doPost ( HttpServletRequest request
                       , HttpServletResponse response )
        throws ServletException, IOException
    {
      // create a JavaBean for the registration
        RegistrationBean rb = new RegistrationBean();

      // initialize confirmation number property
        Random rand = new Random();
        int confirmNum = Math.abs(rand.nextInt());
        rb.setConfirmationNumber(confirmNum);
        
      // initialize date property
        Date curDate = new Date();
        rb.setDate ( curDate );

      // initialize guild-member property
        String s = request.getParameter ( "guildmember" );

        boolean guildMember = false;

        if ( s != null )
        {
            guildMember = true;
        }

        rb.setGuildmember ( guildMember );

        try
        {
          // set attendee count property
            String temp = request.getParameter ( "attendees" );
            int i = Integer.parseInt ( temp );
            rb.setAttendees ( i );

          // set CD count property
            temp = request.getParameter ( "cds" );
            i = Integer.parseInt ( temp );
            rb.setCds ( i );
        }
        catch ( NumberFormatException e )
        {
        	System.out.println(e.getMessage());

            // store the exception object in the request
          	HttpSession session = request.getSession();
              session.setAttribute (
                      "errMsg", e );

            // redirect to an error JSP
              response.sendRedirect("error.jsp");
            return;
        }

      // set simple String properties
        rb.setName ( request.getParameter ( "name" ) );
        rb.setAddress ( request.getParameter ( "address" ) );
        rb.setCity ( request.getParameter ( "city" ) );
        rb.setState ( request.getParameter ( "state" ) );
        rb.setZip ( request.getParameter ( "zip" ) );

      // store the Bean reference in the session
        HttpSession session = request.getSession ();
        session.setAttribute ( "regBean", rb );

      // redirect the request to the JSP
        response.sendRedirect ( "register.jsp" );
    }
}


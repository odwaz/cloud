/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-16 05:27:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Register for the Conference</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"resources/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t<h1>Hello, world!</h1>\r\n");
      out.write("\t\t\t<p>This is an example to show the potential of an offcanvas\r\n");
      out.write("\t\t\t\tlayout pattern in Bootstrap. Try some responsive-range viewport\r\n");
      out.write("\t\t\t\tsizes to see it in action.</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"InsertRegistration\" method=\"post\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label>First Name</label> <input type=\"text\" class=\"form-control\" value=\"");
      out.print(request.getParameter(""));
      out.write("\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\tUSER ID<input type=text\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(request.getParameter("testuid"));
      out.write("disabled\"> <br>\r\n");
      out.write("\t\t\tName <input type=\"text\"\r\n");
      out.write("\t\t\t\tvalue=\" ");
      out.print(request.getParameter("testupwd"));
      out.write("\" disabled> <br>\r\n");
      out.write("\t\t\tAnother <input type=text value=\"");
      out.print(request.getParameter("page1"));
      out.write("\"\r\n");
      out.write("\t\t\t\tdisabled> <br> Home <input type=text\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(request.getParameter("testuid"));
      out.write("\" disabled>\r\n");
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

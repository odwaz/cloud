/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-16 05:43:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddressInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      order.Order theOrder = null;
      synchronized (session) {
        theOrder = (order.Order) _jspx_page_context.getAttribute("theOrder", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (theOrder == null){
          theOrder = new order.Order();
          _jspx_page_context.setAttribute("theOrder", theOrder, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("theOrder"), "name", "${param.name}", _jspx_page_context, null);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("theOrder"), "address", "${param.address}", _jspx_page_context, null);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("theOrder"), "email", "${param.email}", _jspx_page_context, null);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <body>\r\n");
      out.write("    <img alt=\"Logo\" src=\"logo.gif\">\r\n");
      out.write("    <h2>Address and Payment Confirmation</h2>\r\n");
      out.write("    \r\n");
      out.write("      <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td valign=\"top\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"left\">Name: </td>\r\n");
      out.write("                    <td align=\"left\"><input type=\"text\" size=\"25\" maxlength=\"25\" name=\"name\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"left\">Address: </td>\r\n");
      out.write("                    <td align=\"right\"><input type=\"text\" size=\"25\" maxlength=\"25\" name=\"address\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td align=\"left\">City: </td>\r\n");
      out.write("                    <td align=\"right\"><input type=\"text\" size=\"25\" maxlength=\"25\" name=\"city\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>State:</td>\r\n");
      out.write("                    <td><input type=\"text\" size=\"2\" maxlength=\"2\" name=\"state\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Zip:</td>\r\n");
      out.write("                    <td><input type=\"text\" size=\"5\" maxlength=\"5\" name=\"zip\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" value=\"Submit\" onclick=\"index.jsp\">\r\n");
      out.write("                        <input type=\"Reset\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            </td>\r\n");
      out.write("\r\n");
      out.write("            <td width=\"5%\">\r\n");
      out.write("            </td>\r\n");
      out.write("\r\n");
      out.write("            <td valign=\"top\">\r\n");
      out.write("            <table>\r\n");
      out.write("            \r\n");
      out.write("            </table>\r\n");
      out.write("            </td>\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("  </body>\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2016-03-17 06:30:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.ResultException;
import com.iveri.enterprise.ResultExceptionAction;
import com.iveri.enterprise.ResultStatus;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Statement");
    _jspx_imports_classes.add("com.iveri.enterprise.ResultStatus");
    _jspx_imports_classes.add("com.iveri.enterprise.Enterprise");
    _jspx_imports_classes.add("com.iveri.enterprise.ResultException");
    _jspx_imports_classes.add("com.iveri.enterprise.ResultExceptionAction");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String id = request.getParameter("employee");
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "dbuser";
	String userId = "root";
	String password = "root";

	String gateway = "host"; // Change gateway here if not using iVeriClient config file default
	String certificateID = "a2120034-9ce1-467e-82e5-e42d349f61d5"; // Enter GUID here if not using iVeriClient config file default
	String applicationID = "67ccde9f-d03c-480c-a86a-d9d0a7e8aa48"; // Enter GUID here
	String mode = "Test"; // Change default mode here
	// Change the Credit Card number here
	//static String expiry = "1216"; // Change the creditcard expiry date here (MMYY)
	//static String amount = "123"; // Change the amount in cents, here (1.23)
	String currency = "USD"; // Change the amount in cents, here (1.23)

	Enterprise e = new Enterprise(gateway, certificateID,
			ResultExceptionAction.RESULT_EXCEPTION_ON_UNSUCCESSFUL);

	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

      out.write("\r\n");
      out.write("<h2 align=\"center\">\r\n");
      out.write("\t<font><strong>Retrieve data from database in jsp</strong></font>\r\n");
      out.write("</h2>\r\n");
      out.write("<table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr bgcolor=\"#A52A2A\">\r\n");
      out.write("\t\t<td><b>id</b></td>\r\n");
      out.write("\t\t<td><b>Name</b></td>\r\n");
      out.write("\t\t<td><b>Address</b></td>\r\n");
      out.write("\t\t<td><b>Language</b></td>\r\n");
      out.write("\t\t<td><b>Year</b></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

		try {
			connection = DriverManager.getConnection(
					connectionUrl + dbName, userId, password);
			statement = connection.createStatement();
			String sql = "SELECT * FROM employee";

			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
	
      out.write("\r\n");
      out.write("\t<tr bgcolor=\"#DEB887\">\r\n");
      out.write("\r\n");
      out.write("\t\t<td>");
      out.print(resultSet.getString("id"));
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(resultSet.getString("name"));
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(resultSet.getString("address"));
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(resultSet.getString("language"));
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(resultSet.getString("year"));
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t");

		}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

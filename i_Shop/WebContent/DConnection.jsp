<%@page import="java.sql.*" %>
<%!
public class DConnection {

    Connection con;
    ResultSet rs=null;
    Statement st;

    public int setData(String str){
        int i=0;
        try{
            Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/shopping?user=root&password=jayvik");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "root");
            st=con.createStatement();
            st.execute(str);
            i = st.getUpdateCount();
        }catch(Exception e){
           
        }
        return i;
    }

    public ResultSet getData(String str) {

        try{
            Class.forName ("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/shopping?user=root&password=jayvik");
            st=con.createStatement();
            rs = st.executeQuery(str);
        }
        catch (Exception e){
       }
        return rs;
    }

}

%>
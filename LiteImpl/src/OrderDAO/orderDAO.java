package OrderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import order.Order;

public class orderDAO
{
    private DataSource ds;

    public void setDataSource(DataSource ds)
    {
        this.ds = ds;
    }

    public DataSource getDataSource()
    {
        return this.ds;
    }

    public Order findRegistration(int confirmNum)
        throws SQLException, RegistrationNotFoundException, ParseException
    {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-mm-DD hh:mm:ss");

        Connection con = null;
        Order rb = null;

        try
        {
            // connect to database
            con = connect();

            // create a statement
            Statement stmt = con.createStatement();

            // define a string with SQL to select all
            // columns from the registration table for
            // the specified confirmation number
            String sql = "SELECT * FROM users WHERE confirmNum=" + confirmNum;

            ResultSet rs = null;
            try
            {
                // execute the query and retrieve a result set
                rs = stmt.executeQuery(sql);

                if (!rs.next())
                    throw new RegistrationNotFoundException("No registration for " + confirmNum);

                // create a RegistrationBean and intialize its
                // properties from the result set
                rb = new Order();
                rb.setAddress(rs.getString("address"));
                rb.setCount(rs.getInt(0));
                rb.setCity(rs.getString("city"));
                rb.setConfirmationNumber(rs.getInt("confirmNum"));
                rb.setName(rs.getString("name"));
            
               
               // Date date = df.parse(dateStr);
                //rb.setDate(date);               
            }
            finally
            {
                if (rs != null) rs.close();
            }
        }
        finally
        {
            if (con != null) con.close();
        }

        return rb;
    }

    public int insertRegistration(Order rb)
            throws SQLException
    {
        int confirmNum = -1;

        Connection con = null;

        try
        {
            // connect to database
            con = connect();

            // define a string with SQL to insert
            // a row into the registration table
            String sql = "INSERT INTO registration " +
              "(name, address, city,count, guildmember, regdate)" +
              " VALUES (?,?,?,?,?,?,?,?,?)";

            // create a prepared statement
           PreparedStatement ps = con.prepareStatement(sql);


            // provide the parameter values
            ps.setString(1, rb.getName());
            ps.setString(2, rb.getAddress());
            ps.setString(3, rb.getCity());
            ps.setFloat(6, rb.getCount());
      
           

            
            
            // execute the insert
            int rows = ps.executeUpdate();

            if (rows != 1)
                throw new SQLException("Insert failed");

            // retrieve the auto-generated key
            // will use as confirmation number
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                confirmNum = rs.getInt(1);
            else
                throw new SQLException("Unable to retrieve key");

        }
        finally
        {
            if (con != null)
                con.close();
        }

        return confirmNum;
    }

    private Connection connect()
        throws SQLException
    {
        return ds.getConnection();
    }
}

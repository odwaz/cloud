package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import conference.RegistrationBean;

public class RegistrationDAO {
	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public DataSource getDataSource() {
		return this.ds;
	}

	public RegistrationBean findRegistration(int confirmNum)
			throws SQLException, RegistrationNotFoundException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("yyyy-mm-DD hh:mm:ss");

		Connection con = null;
		RegistrationBean rb = null;

		try {
			// connect to database
			con = connect();

			// create a statement
			Statement stmt = con.createStatement();

			// define a string with SQL to select all
			// columns from the registration table for
			// the specified confirmation number
			String sql = "SELECT * FROM registration WHERE confirmNum="
					+ confirmNum;

			ResultSet rs = null;
			try {
				// execute the query and retrieve a result set
				rs = stmt.executeQuery(sql);

				if (!rs.next())
					throw new RegistrationNotFoundException(
							"No registration for " + confirmNum);

				// create a RegistrationBean and intialize its
				// properties from the result set
				rb = new RegistrationBean();
				rb.setAddress(rs.getString("address"));
				rb.setAttendees(rs.getInt("attendees"));
				rb.setCds(rs.getInt("cds"));
				rb.setCity(rs.getString("city"));
				rb.setConfirmationNumber(rs.getInt("confirmNum"));
				rb.setName(rs.getString("name"));
				rb.setState(rs.getString("state"));
				rb.setZip(rs.getString("zip"));

				int guildMember = rs.getInt("guildmember");
				if (guildMember == 0)
					rb.setGuildmember(false);
				else
					rb.setGuildmember(true);

				String dateStr = rs.getString("regdate");
				// Date date = df.parse(dateStr);
				// rb.setDate(date);
			} finally {
				if (rs != null)
					rs.close();
			}
		} finally {
			if (con != null)
				con.close();
		}

		return rb;
	}

	public int insertRegistration(RegistrationBean rb) throws SQLException {
		int confirmNum = -1;

		Connection con = null;

		try {
			// connect to database
			con = connect();

			// define a string with SQL to insert
			// a row into the registration table
			String sql = "INSERT INTO registration "
					+ "(name, address, city, state, zip, attendees, cds, guildmember, regdate)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			// create a prepared statement
			PreparedStatement ps = con.prepareStatement(sql);

			// provide the parameter values
			ps.setString(1, rb.getName());
			ps.setString(2, rb.getAddress());
			ps.setString(3, rb.getCity());
			ps.setString(4, rb.getState());
			ps.setString(5, rb.getZip());
			ps.setInt(6, rb.getAttendees());
			ps.setInt(7, rb.getCds());
			if (rb.getGuildmember())
				ps.setInt(8, 1);
			else
				ps.setInt(8, 0);

			ps.setDate(9, new java.sql.Date(rb.getDate().getTime()));

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

		} finally {
			if (con != null)
				con.close();
		}

		return confirmNum;
	}

	private Connection connect() throws SQLException {
		return ds.getConnection();
	}
}

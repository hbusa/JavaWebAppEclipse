import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		// JDBC driver name and database URL
		//final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/userlogin";
		
		// Database Credentials
		final String USER = "root";
		final String PASS = "1921";
		
		// set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		

		try {
			// Register JDBC drive
			Class.forName("com.mysql.jdbc.Driver");
			// Open a Connection
			Connection con = DriverManager.getConnection(DB_URL,USER,PASS);

			String n = request.getParameter("userName");
			String p = request.getParameter("Passwd");
			
			// Run SQL
			
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?)");

			ps.setString(1, n);
			ps.setString(2, p);

			int i = ps.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered...");

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}
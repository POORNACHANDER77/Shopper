package Ayu;

import java.sql.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 */
public class Ayureg2 extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ayureg2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		     
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1=request.getParameter("fname");
			String s2=request.getParameter("lname");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			
			String s5=request.getParameter("mn");
	        
	         PreparedStatement pt=con.prepareStatement("insert into ayu4 values (?,?,?,?,?)");
	         pt.setString(1, s1);
	         pt.setString(2, s2);
	         pt.setString(3, s3);
	         pt.setString(4, s4);
	         pt.setString(5, s5);
	       
	         pt.executeUpdate();
	         PrintWriter pw=response.getWriter();
	         pw.println("<html><body text=red bgcolor=black><center> ");
	         pw.println("<h1>sucessfully registered</h1>");
	         pw.println("<a href='Ayulog.html'>Click here to login-></a>");
	         pw.println("</center></body></html>");         
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
	}

}

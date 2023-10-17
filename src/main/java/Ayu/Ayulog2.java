package Ayu;

import java.sql.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

/**
 * Servlet implementation class Ayulog
 */
public class Ayulog2 extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ayulog2() {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      try {
	     	 String s1=request.getParameter("uname");
		     String s2=request.getParameter("pword");
		     PreparedStatement pt = con.prepareStatement("select * from ayu4 where uname=? and pword=? ");
		    pt.setString(1, s1);
			pt.setString(2, s2);
			ResultSet rs=pt.executeQuery();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body text=red><h1><center>");
			if(rs.next())
			{
				response.sendRedirect("Ayu.jsp");
			}
			else
			{
				
				pw.println("invalid username/password</h1>");
				
				RequestDispatcher rd=request.getRequestDispatcher("Ayulog.html");
				rd.include(request,response);
				
			}
			pw.println("</center></body></html>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
}

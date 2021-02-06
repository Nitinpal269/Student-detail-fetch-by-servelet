import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddStudent extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String std_id=req.getParameter("std_id");
		String std_name=req.getParameter("std_name");
		String computer=req.getParameter("computer");
		String english=req.getParameter("english");
		String science=req.getParameter("science");
		String math=req.getParameter("math");
		String art=req.getParameter("art");
		String hindi=req.getParameter("hindi");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
			Statement s=c.createStatement();
			s.executeUpdate("insert into cbse values('"+std_id+"','"+std_name+"','"+computer+"','"+english+"','"+science+"','"+math+"','"+art+"','"+hindi+"')");
		}
		catch(Exception e)
		{
			
		}
		out.println("Record added!!!!..");
		out.println("<br><br><a href='four.html'>Back to Home</a>");
		out.println("</body></html>");
		
	}
}


			
		
		


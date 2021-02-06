import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SearchStudent extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String std_id=req.getParameter("std_id");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from cbse where std_id='"+std_id+"' ");
			if(rs.next())
			{
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				String s3=rs.getString(3);
				String s4=rs.getString(4);
				String s5=rs.getString(5);
				String s6=rs.getString(6);
				String s7=rs.getString(7);
				String s8=rs.getString(8);
				
				double d1=Double.parseDouble(s3);
				double d2=Double.parseDouble(s4);
				double d3=Double.parseDouble(s5);
				double d4=Double.parseDouble(s6);
				double d5=Double.parseDouble(s7);
				double d6=Double.parseDouble(s8);
				
				double averagemark=(d1+d2+d3+d4+d5+d6)/6;
				double percentagemark=(averagemark/100)*100;
				
				out.println("id: "+s1+"<br>");
				out.println("Name: "+s2+"<br>");
				out.println("computer_mark: "+d1+"<br>");
				out.println("english_mark: "+d2+"<br>");
				out.println("science_mark: "+d3+"<br>");
				out.println("math_mark: "+d4+"<br>");
				out.println("art_mark: "+d5+"<br>");
				out.println("hindi_mark: "+d6+"<br>");
				out.println("Average marks of "+s2+ "= "+averagemark+"<br>");
				out.println("Percentage marks of "+s2+ "= "+percentagemark+"%<br>");
				
				if(averagemark>=60)
					out.println("First Division");
				if(averagemark<59)
				out.println("Second Division");
				if(averagemark<50)
				out.println("Third Division");
			}
			else
			out.println("Enter correct std_id");
		}
		catch(Exception e)
		{}
		out.println("<br><br><a href='four.html'>Back to Home</a>");
		out.println("</body></html>");
	}
}




			
			
			
			
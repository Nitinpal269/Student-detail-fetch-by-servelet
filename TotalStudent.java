import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class TotalStudent extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from cbse");
			ResultSetMetaData rsmd=rs.getMetaData();
			out.println("<table border=1 width=200>");
			out.println("<tr>");
			for(int i=1; i<=rsmd.getColumnCount(); i++)
			{
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("</tr>");
			}
		}
			catch(Exception e)
			{}
			out.println("</table>");
			out.println("<br><br><a href='four.html'>Back to Home</a>");
			out.println("</body></html>");
	}
}




	
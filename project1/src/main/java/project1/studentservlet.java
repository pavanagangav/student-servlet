package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")

public class studentservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Scanner sc =new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			String sql="insert into student (id,name) value(?,?)";
			int id=Integer.parseInt(req.getParameter("ID"));
			String name=req.getParameter("NAME");
			PreparedStatement pmst=conn.prepareStatement(sql);
			PrintWriter pw=resp.getWriter();
			pmst.setInt(1, id);
			pmst.setString(2, name);
			int i=pmst.executeUpdate();
			
			
			
			if(i>0) {
				System.out.println("success");
//				pw.println("succesful");
				resp.sendRedirect("welcome.jsp");
			}
			else {
				System.out.println("error");
//				pw.println("error");
				resp.sendRedirect("error.jsp");
	}
			conn.close();
			pmst.close();

}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    }
		}
		

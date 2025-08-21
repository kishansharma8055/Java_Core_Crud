package in.kishan.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowTable {
	public void showData() {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Kishan@123");
				
		PreparedStatement ps = conn.prepareStatement("select *from register");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("name       email           pass        gender    city  ");

		
		while(rs.next()) {
//					Type 1
					String name1 = rs.getString("name");
//					System.out.print(name1);
					
//					Type 2			
					String email1 = rs.getString("email");
					String password1 = rs.getString("password");
					String gender1 = rs.getString("gender");
					String city1 = rs.getString("city");
//					System.out.println(" email : "+ email1 + " pass : "+ password1 + " gender : " + gender1 + " city : " + city1);
					System.out.println(name1 + " "+ email1 + " "+ password1+" " + gender1 +" "+ city1);
					
//					Type3
//			System.out.println(" name : "+ rs.getString("name") +" email : "+ rs.getString("email") + " pass : "+ rs.getString("password") + " gender : " + rs.getString("gender") + " city : " + rs.getString("city"));
		}
		}catch(Exception e) {
			System.out.println("show table exception error" + e);
		}
	}
}

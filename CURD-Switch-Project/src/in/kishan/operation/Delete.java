package in.kishan.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Delete {
	public  void deleteData(){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("enter corresponding email");
		String email1 = scan.nextLine();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root" ,"Kishan@123");
		PreparedStatement ps = conn.prepareStatement("delete from register where email=?");
		ps.setString(1, email1);
		
		int count = ps.executeUpdate();
		if(count>0) {
			System.out.println("delete successful");
		}else {
			System.out.println("deletion fail");
		}
		}catch(Exception e) {
			System.out.println("delete file exception" + e);
		}
	}
}

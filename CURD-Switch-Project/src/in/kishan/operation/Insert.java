package in.kishan.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {


	public void insertData()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Insert data into table");
		
		System.out.print("Enter Name : ");
		String name1 = scan.nextLine();
		System.out.print("Enter Email : ");
		String email1 = scan.nextLine();
		System.out.print("Enter Password : ");
		String pass1 = scan.nextLine();
		System.out.print("Enter Gender : ");
		String gender1 = scan.nextLine();
		System.out.print("Enter City : ");
		String city1 = scan.nextLine();
		
		try {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");		
//		System.out.println("driver class loaded");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Kishan@123");
//		System.out.println("database connection successful");
//		PreparedStatement ps =  conn.prepareStatement("insert into register values('kishan', 'kishan@gmail.com', '123456', 'male', 'ajmer')");
//		PreparedStatement ps =  conn.prepareStatement("insert into register values('"+name1+"', '"+email1+"', '"+pass1+"', '"+gender1+"', '"+city1+"')");
//		? => positional parameter best way to insert value in database
		PreparedStatement ps =  conn.prepareStatement("insert into register values(?,?,?,?,?)");

		ps.setString(1, name1);
		ps.setString(2, email1);
		ps.setString(3, pass1);
		ps.setString(4, gender1);
		ps.setString(5, city1);
		
		int i =  ps.executeUpdate();
		
		if(i>0) {
			System.out.println("Data Insert Successfully");
		}else {
			System.out.println("Fail to Data Insert");
		}
		}catch(Exception e) {
			System.out.println("Exception in Insert data file");
		}

	}

}
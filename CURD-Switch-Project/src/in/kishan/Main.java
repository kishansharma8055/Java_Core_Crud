package in.kishan;

import java.util.Scanner;
import in.kishan.operation.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int a;
		
		do{
		System.out.println("select, what operation you perform on database");
		System.out.println("1. Insert \n2. Update \n3. Delete \n4. show table");
		a = scan.nextInt();
		System.out.println(a);
		Insert obj1 = new Insert();
		Update obj2 = new Update();
		Delete obj3 = new Delete();
		ShowTable obj4 = new ShowTable();
		
		switch(a) 
		{
		case 1:
			obj1.insertData();
			break;
		
		case 2:
			obj2.updateData();
			break;
			
		case 3:
			obj3.deleteData();
			break;
			
		case 4:
			obj4.showData();
			break;
			
		default:
			System.out.println("Please enter valid input!");
		}
		System.out.println("you can choose again");
		
		}while(a>0);
	}

}

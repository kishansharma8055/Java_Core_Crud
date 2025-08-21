package in.kishan.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

    public void updateData() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What column do you want to update?");
        System.out.println("1. name");
        System.out.println("2. password");
        System.out.println("3. gender");
        System.out.println("4. city");
        int choice = scan.nextInt();
        scan.nextLine(); // Clear the newline after nextInt()

        String column = null;
        switch (choice) {
            case 1: column = "name"; break;
            case 2: column = "password"; break;
            case 3: column = "gender"; break;
            case 4: column = "city"; break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        System.out.print("Enter updated value for " + column + ": ");
        String newValue = scan.nextLine();

        System.out.print("Enter email (primary key) of the record to update: ");
        String email = scan.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_db", "root", "Kishan@123"
            );

            // Dynamic SQL with column name
            String sql = "UPDATE register SET " + column + "=? WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newValue);
            ps.setString(2, email);

            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("Updated successfully.");
            } else {
                System.out.println("Update failed. No matching record found.");
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Exception in updateData: " + e);
        }
    }

    public static void main(String[] args) {
        new Update().updateData();
    }
}

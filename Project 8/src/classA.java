import java.util.Scanner;
import java.sql.*;

public class classA {

	public static void main(String[] args) {
		String JdbcURL = "jdbc:mysql://localhost:3306/music_store";
		String Username = "root";
		String Password = "prabhat24";
		Scanner s = new Scanner(System.in);

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database..........................");
			con = DriverManager.getConnection(JdbcURL, Username, Password);
			System.out.println("Connection is successful!!!");
			Statement stmt = con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		boolean temp = true;
		while (temp) {
			System.out.println("1. Enter Inventory\n2. Show Inventory\n3. Sales\n4. Exit\nEnter your choice");
			int choice = s.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter Name: ");
				String cd = s.next();
				System.out.println("Enter quantity: ");
				int quantity = s.nextInt();
				System.out.println("Enter price:");
				String price = s.next();
				try {
					PreparedStatement ps = con.prepareStatement("INSERT into inventory(Name, Quantity, Cost) values(?,?,?)");
					ps.setString(1, cd);
					ps.setInt(2, quantity);
					ps.setString(3,price);
					int n = ps.executeUpdate();
					System.out.println(n+" number of rows has been successfully executed.");
					break;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
				}
			case 2:{
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory;");
					ResultSet rs = ps.executeQuery();
					System.out.println("Id\tName\tQuantity\tCost");
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int quantity = rs.getInt(3);
						int cost = rs.getInt(4);
						System.out.format("%s\t%s\t\t\t%s\t%s\n",id, name, quantity, cost);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 3:{
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory;");
					ResultSet rs = ps.executeQuery();
					System.out.println("Id\tName\tQuantity\tCost");
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int quantity = rs.getInt(3);
						int cost = rs.getInt(4);
						System.out.format("%s\t%s\t\t\t%s\t%s\n",id, name, quantity, cost);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("Enter the id of the music cd that you want to buy:");
				int buy = s.nextInt();
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory;");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int quantity = rs.getInt(3);
						int cost = rs.getInt(4);
						if(buy == id) {
							quantity = quantity-1;
							ps = con.prepareStatement("UPDATE inventory SET Quantity  =  "+ quantity +"  WHERE Id =  "+buy+" ");
							ps.executeUpdate();
							System.out.println("You bought "+ name + " of quantity 1 for price "+ cost);
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 4:{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				temp = false;
			}
			}
			}
		}
	}


package assgn15_11;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
	private static final String URL = "jdbc:mysql://localhost:3306/java";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	static int ticketcount = 10;

	public void insert() {
		Scanner src = new Scanner(System.in);

		System.out.println("how many records you want to insert:");
		int len = src.nextInt();

		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			int row = 0;

			PreparedStatement pt = con.prepareStatement("insert into flight values(?,?,?,?,?,?);");

			System.out.println("Enter the Flight id:");
			int flight_Id = src.nextInt();

			System.out.println("Enter the Source name:");
			String source = src.next();

			System.out.println("Enter the Destiantion name:");
			String destination = src.next();

			System.out.println("Enter the service provider name:");
			String sp = src.next();

			System.out.println("Enter the ticket Price:");
			int price = src.nextInt();

			System.out.println("Enter the tickets avalaibale:");
			int avail_ticket = src.nextInt();

			pt.setInt(1, flight_Id);
			pt.setString(2, source);
			pt.setString(3, destination);
			pt.setString(4, sp);
			pt.setInt(5, price);
			pt.setInt(6, avail_ticket);

			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ticketcount() {
		int avail_ticket = 0;
		System.out.println(avail_ticket);
	}

	public void update() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			Scanner src = new Scanner(System.in);

			System.out.println("Enter the id ");
			int flight_Id = src.nextInt();

			System.out.println("Enter the Source name to be modified:");
			String source = src.next();

			System.out.println("Enter the Destiantion name to be modified:");
			String destination = src.next();

			System.out.println("Enter the service provider  name to be modified:");
			String sp = src.next();

			System.out.println("Enter the price of a ticket");
			int price = src.nextInt();

			PreparedStatement pt = con
					.prepareStatement("update  flight set source=?  ,destination=?,  sp=?,  price=? where flight_Id=?");

			pt.setString(1, source);
			pt.setString(2, destination);
			pt.setString(3, sp);
			pt.setInt(4, price);
			pt.setInt(5, flight_Id);

			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			Scanner src = new Scanner(System.in);
			PreparedStatement pt = con.prepareStatement("delete from flight where flight_id=?");
			System.out.println("Enter the fight id");
			int flight_id = src.nextInt();
			pt.setInt(1, flight_id);
			pt.executeUpdate();
			pt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void view_flight() {
		try {
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			Scanner src = new Scanner(System.in);
			PreparedStatement pt = con.prepareStatement("select * from flight where flight_id=?");
			System.out.println("Enter the flight id");
			int flight_id = src.nextInt();
			pt.setInt(1, flight_id);

			ResultSet rs = pt.executeQuery();
			System.out.println("Flight Id\tsource\tDestination\tservice provide\tTicket price\t");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getInt(5));

			}

			pt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


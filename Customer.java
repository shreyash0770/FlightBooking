package assgn15_11;

//Adding this line for modification


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
	private static final String URL = "jdbc:mysql://localhost:3306/assignmets";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	Scanner src = new Scanner(System.in);
	

	public void search_flight() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// create connection
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			int row = 0;

			PreparedStatement pt = con.prepareStatement("select * from flight where source=? and destination=?");
			System.out.println("Enter the Source");
			String source = src.next();
			System.out.println("Enter the destination:");
			String destination = src.next();
			pt.setString(1, source);
			pt.setString(2, destination);

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

	public void book_flight() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// create connection
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			PreparedStatement pt = con
					.prepareStatement("select * from flight where source=? and destination=? and sp=?");
			System.out.println("Enter the Source");
			String source = src.next();
			System.out.println("Enter the destination:");
			String destination = src.next();
			System.out.println("Enter the service provider");
			String sp = src.next();

			pt.setString(1, source);
			pt.setString(2, destination);
			pt.setString(3, sp);

			ResultSet rs = pt.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getInt(5));

			}

			ResultSet rs2;
			int result = 0;

			Statement st = con.createStatement();
			String query = "update flight set avail_ticket=avail_ticket-1 where avail_ticket>0";
			st.executeUpdate(query);

			PreparedStatement preparedStatement = con.prepareStatement("SELECT avail_ticket FROM flight");
			
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				result = resultSet.getInt("avail_ticket");
			}
			System.out.println("Only "+result+"tickets are left ..Hurry up!");

			if (result > 0) {
				System.out.println("Congratulations!!!!Your ticket is booked!");

			}

			else {
				System.out.println("oops!no ticket is left..........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
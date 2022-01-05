package assgn15_11;



import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		Customer cust = new Customer();
		Scanner src = new Scanner(System.in);

		String c;

		do {
			System.out.println("enter the operation which you want to perform:\n1.insert\n2.update\n3.delete\n4.view\n5.search\n6.book");
			int ch = src.nextInt();

			switch (ch) {
			case 1:
				a.insert();
				break;

			case 2:
				a.update();
				break;

			case 3:
				a.delete();
				break;

			case 4:
				a.view_flight();
				break;

			case 5:
				cust.search_flight();
				break;
			case 6:
				cust.book_flight();
				break;

			default:
				System.out.println("Invalid choice");
				break;

			}
			System.out.println("Do you want to continue? press Y /y to continue");
			c = src.next();

		} while (c.equalsIgnoreCase(("Y")));

	}
}


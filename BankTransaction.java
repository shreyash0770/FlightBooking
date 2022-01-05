package day2;
import java.util.Scanner;





public class BankTransaction 
{
	
		String name;
		String address;
		String acc_type;
		Float balance=0f;
		Scanner sc=new Scanner(System.in);
		void OpenAcc()
		{
			System.out.println("Enter Account Holder's name:");
			name=sc.next();
			System.out.println("Enter Account Holder's address:");
			address=sc.next();
			System.out.println("Enter Account Type from Below \n1.Saving\n2.Current");
			acc_type=sc.next();
		}
		
		void Deposite()
		{
			int amount;
			System.out.println("Enter the amount you want to deposite=");
			amount=sc.nextInt();
			balance+=balance;
			System.out.println("Total balance:"+balance);
		}
		void Withdraw()
		{
			int withdraw;
			System.out.println("Enter the Amount you want to withdraw=");
			withdraw=sc.nextInt();
			if(balance>=withdraw)
				balance-=withdraw;
			System.out.println("remaining balance is="+balance);
			
		}
		
	

	public static void main(String[] args) 
	{
		BankTransaction operation=new BankTransaction();
		operation.OpenAcc();
		operation.Deposite();
		operation.Withdraw();

	}

}

//This is new branch

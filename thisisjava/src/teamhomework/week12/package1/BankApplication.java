package teamhomework.week12.package1;

import java.util.Scanner;

public class BankApplication {
	   
	   private static Account[]  accountArray = new  Account[100];
	   private static Scanner scanner = new Scanner (System.in);
	   
	   public static void main(String[] args) {
	      
	      boolean run = true;
	      
	      while (run) {
	         
	         System.out.println("----------------------");
	         System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
	         System.out.println("----------------------");
	         System.out.print("선택 > ");
	         
	         int Num = scanner.nextInt();
	         scanner.nextLine();
	         
	         if (Num==1) {
	            createAccount();
	         }
	         else if (Num ==2) {
	            accountList();
	         }
	         else if (Num ==3) {
	            deposit();
	         }
	         else if (Num ==4) {
	            withdraw();
	         }
	         else if (Num ==5) {
	            run = false;
	      }
	   }
	   
	      System.out.println("프로그램 종료");   

	}
	   
	private static void createAccount() {
	   
	   System.out.println("-----------");
	   System.out.println("계좌생성");
	   System.out.println("-----------");
	   System.out.print("계좌번호 : ");
	   String account = scanner.nextLine();
	   System.out.print("계좌주: ");
	   String owner = scanner.nextLine();
	   System.out.print("초기입금액: ");
	   int balance = scanner.nextInt();
	   scanner.nextLine();
	   
	   Account newAccount = new Account (account, owner, balance);
	   
	   for (int i = 0; i<accountArray.length; i++) {
	      
	      if ( accountArray[i] == null) {
	         
	         accountArray[i] = newAccount;
	         System.out.println("결과: 계좌가 생성되었습니다.");
	         break;
	      }
	   }	   
	      
	}

	private static void accountList() {
	   
	   System.out.println("-----------");
	   System.out.println("계좌목록");
	   System.out.println("-----------");
	   
	   for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				Account account = accountArray[i];
				System.out.printf("%s\t%s\t%d\n", 
					account.getAccount(), 
					account.getOwner(), 
					account.getBalance());
			}
		}
	   
	}

	private static void deposit() {
	   
	   System.out.println("-----------");
	   System.out.println("예금");
	   System.out.println("-----------");
	   
	   System.out.print("계좌번호: ");
	   String accountNum = scanner.nextLine();
	   
	   System.out.print("예금액: ");
	   int amount = scanner.nextInt();
	   scanner.nextLine();
	   
	   Account account = findAccount(accountNum);
	   
	   account.deposit(amount);
	   
	   System.out.println("결과: 예금이 성공되었습니다.");
	   
	}

	private static void withdraw() {
	   
	   System.out.println("-----------");
	   System.out.println("출금");
	   System.out.println("-----------");   
	   
	   System.out.print("계좌번호: ");
	   String accountNum = scanner.nextLine();
	   
	   System.out.print("출금액: ");
	   int amount = scanner.nextInt();
	   scanner.nextLine();
	   
	   Account account = findAccount(accountNum);
	   
	   if(account.withdraw(amount)) {
		   System.out.println("결과: 출금이 성공되었습니다.");
	   } else {
		   System.out.println("결과: 잔액이 부족합니다.");
	   }
	   
	   
	}

	private static Account findAccount(String accountNum) {
	   
	   for (int i =0; i<accountArray.length; i++) {
	      
	      if (accountArray[i]!= null) {
	         
	         String dbAccount = accountArray[i].getAccount();
	         if (dbAccount.equals(accountNum)) {
	            return accountArray[i];
	         }
	      }
	   }
	   return null;
	}  
}

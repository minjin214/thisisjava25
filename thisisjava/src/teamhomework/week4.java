package teamhomework;

import java.util.Scanner;

public class week4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//boolean run = true;
		int money = 0;
		
		while(true) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")) {
				System.out.print("예금액>");
				int deposit = Integer.parseInt(scanner.nextLine());
				money += deposit;
			} else if(strNum.equals("2")) {
				System.out.print("출금액>");
				int withdraw = Integer.parseInt(scanner.nextLine());
				money -= withdraw;
			} else if(strNum.equals("3")) {
				System.out.println("잔고>" + money);
			} else if(strNum.equals("4")) {
				break;
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("프로그램 종료");
	}
}

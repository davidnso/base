package primelab;
import java.util.Scanner;
public class ClassLab {
public static void main(String []args) { 
	/*Coin Coin = new Coin(); 
	System.out.println("The coin is facing " + Coin.sideUp() + " initially.");
	int count=0; 
	while(count < 20) { 
		Coin.toss();
		System.out.println(Coin.getSideUp()); 
		count ++; 
	}
	System.out.println("Heads: " + Coin.getHcount());
	System.out.println("Tails: "+ Coin.getTcount());
}
}*/
/*Die snake = new Die(); 
CompDie eyes = new CompDie(); 
int compWin=0; 
int userWin=0; 
int noWin=0; 
for(int i=0; i <=9; i++) { 
	int y=snake.Roll();
	int r=eyes.CompRoll();
	if(y>r) {
		userWin++; }
	if(y<r) {
		compWin++; }
	if(y==r) {
		noWin++; }
	}
System.out.print("In this game \nThe computer won " + compWin+ " time(s) \n"
		+ "The user won " + userWin + " time(s)."
		+ "\nThere was a tie "+ noWin+ " time(s)");}
}*/
Scanner K = new Scanner(System.in); 
MonthDays M = new MonthDays(); 
System.out.print("Enter a month(1-12): "); int month=K.nextInt(); 
System.out.print("Enter a Year: "); int year=K.nextInt();
System.out.print(M.getNumberofDays(month, year) + " days"); }
}

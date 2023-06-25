import java.util.Scanner;
import java.util.Random;


class Guessing {//Guessing class
	
	int Computer_Input;
	int USER_INPUT;
	int Guesses_Numbers = 0;
	
	
	Guessing() {
		Random random = new Random();
		this.Computer_Input = random.nextInt(100) + 1;
	}
	
	
	
	public boolean takingInput() {
		if (Guesses_Numbers < 10 ) {
			System.out.print("Guess the number : ");
			this.USER_INPUT = Number_Guessing.Integer_Input(100);
			Guesses_Numbers++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}
	
	
	
	public boolean isCorrect_Guess() {
		
		if ( Computer_Input == USER_INPUT ) {
			System.out.println("Congratulation!! your Guessing  Number is " + Computer_Input +
			" in " + Guesses_Numbers + " guesses");
			switch(Guesses_Numbers) {
				case 1:
				System.out.println("Your score is 100:");
				break;

				case 2:
				System.out.println("Your score is 90:");
				break;

				case 3:
				System.out.println("Your score is 80:");
				break;

				case 4:
				System.out.println("Your score is 70:");
				break;

				case 5:
				System.out.println("Your score is 60:");
				break;

				case 6:
				System.out.println("Your score is 50:");
				break;

				case 7:
				System.out.println("Your score is 40:");
				break;

				case 8:
				System.out.println("Your score is 30:");
				break;

				case 9:
				System.out.println("Your score is 20:");
				break;

				case 10:
				System.out.println("Your score is 10:");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( Guesses_Numbers < 10 && USER_INPUT > Computer_Input ) {
			if ( USER_INPUT - Computer_Input > 10 ) {
				System.out.println("Too High:");
			}
			else {
				System.out.println("Little High:");
			}
		}
		else if ( Guesses_Numbers < 10 && USER_INPUT < Computer_Input ) {
			if ( Computer_Input - USER_INPUT > 10 ) {
				System.out.println("Too Low:");
			}
			else {
				System.out.println("Little Low:");
			}
		}
		return false;
	}
}


public class Number_Guessing {
	

	public static int Integer_Input(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner obj = new Scanner(System.in);
				input = obj.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("You will choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Yoy will give only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println("1. Start the Game \n2. Exit");
		System.out.print("Enter your choice : ");
		int choice = Integer_Input(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			
			while ( nextRound == 1 ) {
				
				Guessing game = new Guessing();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " +  ++noOfRound + " starts...");
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takingInput();
					isMatched = game.isCorrect_Guess();
				}

				
				System.out.println("1. Next Play \n2. Exit");
				System.out.println("Give your choice: ");
				nextRound =Integer_Input(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}

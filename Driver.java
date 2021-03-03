import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Scanner for input 
		OpSum os = new OpSum(); //Instantiate OpSum
		
		//HardCoded values 
		os.findOpThatSumTo(3,10); 
		
		//User entered values
		while(true) {	//Infinite loop isn't great, but it works for testing phase.
			int numOps = getInput(input, "number of operands"); //Ask user for n
			int sumTo = getInput(input, "their desired sum"); 	//Ask user for s
			os.findOpThatSumTo(numOps,sumTo);	//Find n operands that sum to s
		}
	}
	
	/**
	 * Asks user for a specified integer input
	 * @param input Scanner for input
	 * @param valueType String that is used in the print statement to specify what 
	 * type of value to enter. For example, "Number of Operands" or "That Sum To." 
	 * @return user's desired value (an integer)
	 */
	private static int getInput(Scanner input, String valueType) {

		int d = 0; //dimension: could be height or width
		while(d<=0 || d>100) { //keep asking for input until user enters dimension > 0 
			try {
				System.out.print("Enter the "+valueType+": ");
				d = input.nextInt(); //Get user input

				if(d<=0) { //Prevents user from entering value less than 0
					System.err.println("  "+valueType+" must be positive");
				}
			}catch(InputMismatchException e) { //Prevents user from entering a String
				System.err.println("  That is an invalid input.");
			}
			input.nextLine(); //catch "\n"
		}
		return d;
	}


}

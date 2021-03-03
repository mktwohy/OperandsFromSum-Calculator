import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OpSum {
	
//FIND ANSWER
	/**
	 * Takes the desired number of operands (n) and their desired sum (s),
	 * then returns an array of n operands that sum to s. 
	 * @param numOps desired number of operands
	 * @param sumTo desired sum of operands
	 * @return array of n operands that sum to s
	 */
	public int[] findOpThatSumTo(int numOps, int sumTo) {
		int[] results = opSumAlgorithm(numOps,sumTo);
		displayResults(numOps, sumTo, results);
		return results;
	}
	/**
	 * Algorithm that, based on the desired number of operands (n) and their desired sum (s),
	 * finds and returns an array of n operands that sum to s. 
	 * @param numOps desired number of operands
	 * @param sumTo desired sum of operands
	 * @return array of n operands that sum to s
	 */
	private int[] opSumAlgorithm(int numOps,int sumTo) {
		int[] ops = new int[numOps];
		while(numOps>0) {
			float div = (float)sumTo / (float)numOps; //Divide sum by number of operators
			int tempOp =  Math.round(div); //round this answer up or down to an int
			ops[numOps-1] = tempOp; //record answer (one of the operands) in array
			sumTo = sumTo - tempOp; //Since tempOp is one of the known operands in the sum,
								//We subtract it from the sum. This loop is constantly 
								//making the sum smaller, which makes the problem easier.
								//Eventually, the unknown operand will be trivial: "op1 = sum/1"
			numOps = numOps-1; //Iterate operand down one. Time to find the next operand!
		}

		return ops;
	}
	/**
	 * Verifies and prints results
	 * @param numOps desired number of operands
	 * @param sumTo desired sum of operands
	 * @param results array of n operands that sum to s
	 */
	private void displayResults(int numOps, int sumTo, int[] results) {
		//State the algorithm input
		System.out.println("  Find "+numOps + " operands that sum to "+sumTo+": ");
		
		//Display verification results. If verified, display answer
		if(verifyResults(numOps, sumTo, results)) { 
			//Print each operand in results array
			System.out.print("  "); //Indents answer in console
			for(int op : results) { 
				System.out.print(op+", ");
			}
			System.out.println("\n\n");	//print newlines for easier console reading 

		}
	}
	
	
//VERIFY ANSWER
	/**
	 * Verifies that answer passes all tests
	 * @param numOps desired number of operands 
	 * @param sumTo desired sum of operands
	 * @param results array of operands that should sum to the desired "sumTo" value
	 * @return true if results array is a verified answer and false otherwise
	 */
	private boolean verifyResults(int numOps, int sumTo, int[] results) {
		System.out.println("\t>Verifying Answer");
		if(checkNumOps(numOps, results) && checkSumOps(sumTo, results)
			&& checkDiff(results)) {
			System.out.println("\t>Answer verified!");
			return true;
		}else {
			System.err.println("\t>Answer not verified\n");
			return false;
		}
	}
	/**
	 * Verifies that operands in results array sum to (sumTo)
	 * @param sumTo desired sum of operands
	 * @param results array of operands that should sum to the desired "sumTo" value
	 * @return
	 */
	private boolean checkSumOps(int sumTo, int[] results) {
		int sum = 0;
		for(int i : results) {
			sum = sum + i;
		}

		if(sum == sumTo) {
			System.out.println("\t  >Operands sum to "+sumTo);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Verifies that results has the correct number of operands
	 * @param numOps desired number of operands
	 * @param sumTo desired sum of operands
	 * @return true if verified and false otherwise
	 */
	private boolean checkNumOps(int numOps, int[] results) {
		if(results.length == numOps){
			System.out.println("\t  >Sum found with "
					+numOps+" Operands");
			return true;
		}else {
			System.err.println("Sum not found");
			return false;
		}
	}
	/**
	 * Verifies that each operand in the results array differs by no more than 1
	 * @param results array of operands that should sum to the desired "sumTo" value
	 * @return true if verified and false otherwise
	 */
	private boolean checkDiff(int[] results) {
		Arrays.sort(results);
		int min = results[0];	
		int max = results[results.length-1];
		int diff = max - min;
		if(diff<=1) {
			System.out.println("\t  >Operands differ by no more than 1");
			return true;
		}else {
			return false;
		}
	}
}

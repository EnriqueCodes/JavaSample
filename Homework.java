import java.util.Scanner;

public class Homework1 {
	
	static double [] arrayOfNums=new double[10];
	static double [] inverseArray = new double[arrayOfNums.length];

	public static void main(String[] args) {
		
		
		createArray();
		
		printArray(arrayOfNums);
		
		newLine();
		
		cubeCalculator(arrayOfNums);
		
		newLine();
		
		replaceValuesOver250(arrayOfNums);
		
		printArray(arrayOfNums);
		
		newLine();
		
		calculateInverse(arrayOfNums);
		
		//print original array
		System.out.println("Original Array:");
		printArray(arrayOfNums);
		
		newLine();
		
		System.out.println("Inverse Array:");
		printArray(inverseArray);
		
		
		
		

	}
	
	
	
	
	static double[] createArray() {
		System.out.println("Enter 10 positive values to create an array. Press Enter after every number.");
		Scanner input =new Scanner(System.in);
		
		
		for(int i =0;i<arrayOfNums.length;i++) {
			//Validate user input using a while loop
			arrayOfNums[i] = input.nextDouble();
			while(arrayOfNums[i]<0 || arrayOfNums[i]==-0) {
				
				System.out.println("You entered a negative number. Please enter a positive value to continue:");
				arrayOfNums[i] = input.nextDouble();

			}
			
		}
		System.out.println("List of input numbers in the array:");
		
		return arrayOfNums;
		
		
		
		
	}
	
	static void cubeCalculator(double[] x) {
		
		System.out.println("This method calculates the cube of each number and prints the result:");
		
		for(int i =0;i<x.length;i++) {
			
			System.out.println(arrayOfNums[i] + " cubed = " +x[i]*x[i]*x[i]);

			
			
		}
	}
	
	static void replaceValuesOver250(double[] x) {
		
		double temporaryArray[] = new double[arrayOfNums.length];
		boolean isOver250 = false;
		
		//Copy the values of arrayOfNums into temporaryArray to compare later
		
		for(int i =0;i<arrayOfNums.length;i++) {
			
			temporaryArray[i] = arrayOfNums[i];

		if(arrayOfNums[i]>250) {
			arrayOfNums[i]=250;
			
		}
		//Compare values
		if(temporaryArray[i] != arrayOfNums[i]) {
			isOver250 = true;
		}
		}
		//if at least one value is over 250, print a message
		if(isOver250 == true) {
					System.out.println("All values over 250 have been converted to 250.0");
		}
		else {
			System.out.println("No value is higher than 250, therefore all values remain the same.");
		}
	}
	
	
	static void printArray(double[] x) {
		
		for(int i =0;i<x.length;i++) {
		System.out.println(x[i]);}
		
	}
	
	static void newLine() {
		System.out.println(" ");
	}
	
	static double[] calculateInverse(double[] x) {
		
		
		for(int i =0;i<x.length;i++) {
		inverseArray [i] = (1/x[i]);
				}
		
		
		return inverseArray;
		
	}

	
	
}

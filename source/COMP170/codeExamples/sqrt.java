import java.util.Scanner;

public class sqrt { 
	
	public static final double EPSILON = 0.00001; 
	public static final int RUNAWAY = 10000;
	
	public static void main(String[] args) { 
		
		double n=0;
		int counter=0;
		
		Scanner keyboard = new Scanner(System.in);
		
		while (n>=0) {
		
			System.out.println("\n\nEnter a number to computer its square root.");
			System.out.println("(Negative number will terminate the program)");
			n = keyboard.nextDouble();
			
			if ( n>=0 ) {
		
				double xCurrent = 1, xNext, delta;
				boolean keepGoing = true; 
		
				do { 
			
					xNext = 0.5 * ( xCurrent + n/xCurrent ); 
					delta = Math.abs( xNext-xCurrent ); 
			
					if ( delta < EPSILON ) {
						keepGoing = false; 
					} else {
						xCurrent = xNext;
					}
					
					if ( counter > RUNAWAY) {
						keepGoing=false;
					} else {
						counter++;
					}
			
				} while ( keepGoing ); 
				
				System.out.println("Approximate square root of "+n+" is "+xNext+"\n\t("+counter+" iterations)");
				
			}
		} 
	} 
}

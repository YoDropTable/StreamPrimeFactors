/*
 * A skeleton for HW3
 * The file with the primes is read using input redirection
 * The product of two primes whose factor will be calculated
 * is read as command line argument.
 * To compile on EOS:
 * /usr/java/jdk1.8.0_102/bin/javac HW3.java  
 * Sample execution command:
 * /usr/java/jdk1.8.0_102/bin/java HW3  239811952854769 < oneMillionPrimes.txt 
 * @Author: Phil Garza
 * @date: 10/21/2018
 */ 

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class HW3  {

    private final static int SIZE = 1000000;
    public static void main(String args[]) {

	if (args.length != 1) {
	    System.out.println("Usage java HW3 target");
	    return;
	}
	ArrayList < Integer > primes = new ArrayList < Integer > (SIZE);
	// Read a collection of prime numbers
    // Use input redirection
    // Needed to change scanner to read from file
    Scanner scn = new Scanner(System.in);
    
    //Reading Each Line from File
    System.out.println("Reading from file...");
	while (scn.hasNext()) {
	    primes.add(scn.nextInt());
    }
    //Closes the scanner 
    scn.close();

    //Stores arguemnt in a target variable
	long target = Long.parseLong(args[0]);
	System.out.println("The target is: "+target);
	System.out.println("And its factors are: ");
	long startTime = System.currentTimeMillis();
    
    //Splits the arraylist into streams to see if its a factor of target
    primes.parallelStream().filter(i -> target % i == 0).forEach(System.out::println);
    
	long endTime = System.currentTimeMillis();
	long duration = endTime - startTime;
	System.out.println("Time taken: "+ duration);
	
    }
}
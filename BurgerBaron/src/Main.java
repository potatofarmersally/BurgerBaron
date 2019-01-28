import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * This is supposed to execute the burger and handle all the changes 
 * and reads in the orders and outputs the orders based on what the 
 * customer wants. 
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
//		File testFile = new File("customer.txt");
//		// https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html 
//		// for self reference
//		BufferedReader reader = new BufferedReader(new FileReader(testFile));
//		try {
//			while(reader.ready()) {
//				String order = reader.readLine();
//				parseLine(order);
//			}
//			reader.close();
//		} catch (IOException e){
//			System.out.println(e);
//		}
		testBurger();
	}
	
	/*
	 * Method to parse the line of each file in the thing. 
	 */
	private static void parseLine(String line) {
		String[] parsedString = line.split(" ");
		Burger orderBurger;
		boolean isBaron = false; 
		
		
	}
	
	/*
	 * Method to test the stack that I made. 
	 */
	private static void testMyStack() {
		MyStack<String> sample = new MyStack<>();
		
		sample.push("Lamb.");
		sample.push("Little ");
		sample.push("a ");
		sample.push("had ");
		sample.push("Mary ");
		
		while(!sample.isEmpty()) {
			System.out.print(sample.pop());
		}
		
	}
	
	/*
	 * Method to test the burger that I made. 
	 * 
	 * problems so far: 
	 * when you set the burger to true, it doesn't rearrange in the correct order. (sauces out of whack)
	 * it doesn't remove categories or ingredients 
	 * it doesn't add a patty and it doesn't change the patty either 
	 * when you add categories and ingredients twice, it doesn't go to their respective places
	 * when you add a category then add an ingredient the ingredient goes outside of the burger. 
	 */
	private static void testBurger() {
		Burger sampleBurger = new Burger(false);
		Burger sampleBaron = new Burger(true);

		sampleBurger.addCategory("Cheese");
		
		System.out.println(sampleBurger.toString());
		System.out.println(sampleBaron.toString());
	}
}

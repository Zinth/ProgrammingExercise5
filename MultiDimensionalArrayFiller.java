import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Program: Muti-Dimensional Array Filler
* File: MultiDimensionalArrayFiller.java
* Summary: Reads text from a file and fills a multi-dimensional character array and prints it back
*          in column-major order. 
* Author: Chris Hyde
* Date: November 7, 2017 
**/

public class MultiDimensionalArrayFiller {
	
	//Class Defined Constant for the file path
	private static final String FILEPATH = "J:\\GCU\\Programming 1(CST-105)\\Assignments\\Week4CHyde\\Week4_Eclipse_Workspace\\ProgrammingExercise5\\src\\MultiDimensionalArrayFiller.txt";

	// Main Method
	public static void main(String[] args) {
		
		String text = readTextFile(FILEPATH); //String that contains the content of the text file.
		
		String columnText = ""; // String that will display the reordered text
		
		int position = 0; //Integer to count the character position of the text String.
		
		char[][] charList = new char[20][45]; //Create two-dimensional char array that is 20x45.
		
		//Fill the charList with the content of the text file in Row Major order
		for (int row = 0; row < charList.length; row++) {
			for (int column = 0; column < charList[row].length; column++) {

				// Test if position exceeds string length and if so fill with '@'
				if (position < text.length()) {
					charList[row][column] = text.charAt(position); // Set the current character in text to this position in charList.
				}else { 
					charList[row][column] = '@'; // Change all blanks to @.
				}
				
				position++;// Increase position.
				
			}
		} // End of charList Fill
		
		
		// Set columnText to charList in Column Major order
		for (int column = 0; column < 45; column++) {
			for (int row = 0; row < charList.length; row++) {
				columnText += charList[row][column]; // Add the char to columnText.
			}
		}// End setting of columnText.
		
		//Print columnText to user.
		System.out.println(columnText);
		
	}// End Main Method
	
	// Method for reading text files.
	public static String readTextFile(String filePath) {
		String fullText = "";

		// Start Try-Catch block for IO errors.
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(filePath));

			String readLine = "";

			// Loop through each line of the text file set to readLine and add each line to fullText.
			while ((readLine = buffReader.readLine()) != null) {
				fullText += readLine;
			}

			buffReader.close(); // close the file
		} // Try ends, Catch starts in case the file can't be found.
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR 01: File Not Found - Make sure filePath is correct."); // For easier Debugging.
		}
		//End Try-Catch block

		return fullText; // Return the entire text file contents as a string. 
	} // End readTextFile Method

}

/* 
Lab 9
Nicholas Warren
Advanced Application Development with java
Professor Webb
4/6/21
*/

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

class Main {  
static String filename;
static FileReader myFile;
public static void main(String[] args) {   

filename = "data.txt";
String name = "", age = "", color = "";
 //     Declare and initialize a new ArrayList named people that can hold Person objects 
ArrayList<Person> personList = new ArrayList<Person>();
 // Add five new Person objects to your people ArrayList. The first Person added should be you - your name, age, and favorite color. Then add the four other Person objects as shown above (A/B/C/D, their ages, and colors).
personList.add(new Person("Nick", 20, "Purple"));
personList.add(new Person("A", 87, "Pink"));
personList.add(new Person("B", 13, "Yellow"));
personList.add(new Person("C", 55, "Black"));
personList.add(new Person("D", 4, "Green"));
     

//  for(int i=0; i < personList.size(); i++){
//     System.out.printf("%-25s %-20s %-20s %n", personList.get(i).getName(), personList.get(i).getAge(), personList.get(i).getColor());
//    }  This code was being used to test whether or not the array is working.
  
// Start your "try" block
FileWriter toWriteFile;
try {
// Declare a new FileWriter object and initialize it to a new FileWriter with the filename data.txt
toWriteFile = new FileWriter(filename); 
// Declare a new BufferedWriter object and initialize it to use the FileWriter object you just created
BufferedWriter output = new BufferedWriter(toWriteFile);
// Using a loop, go through your people ArrayList and add each person's name, age, and color to the file. Make sure to convert the age to a String. 
for(int i=0; i<personList.size(); i++) {
output.write(personList.get(i).getName()); 
output.newLine();
output.write(Integer.toString(personList.get(i).getAge())); 
output.newLine();
output.write(personList.get(i).getColor()); 
output.newLine();
//Make sure to flush the output at the end of each iteration through the loop. 
output.flush();
 } //end of for loop.
 output.close();  // Close the BufferedWriter object
} //end of try.
catch (IOException excpt) 
{ 
excpt.printStackTrace(); // Add in your "catch" block using an IOException and print out the exception.
} //end of catch.

// Start your "try" block
try {
// Declare and initialize a FileReader object that opens up the data.txt file
myFile = new FileReader(filename);
// Declare and initialize a BufferedReader object that uses the FileReader object you just created
BufferedReader reader = new BufferedReader(myFile);
// Using a while loop, loop through each line of your BufferedReader object
while (reader.ready()) {
name = reader.readLine();
age = reader.readLine();
color = reader.readLine();
// Using System.out.printf, left justified for everything and 10 characters for everything, print out the name, age, and favorite color of the lines you just read in
System.out.printf("%-10s %-10s %-10s %n", name, age, color);
} //closes the reader.
reader.close();
} //closes the try.
// Add in your "catch" block using an IOException and print out the exception
catch (IOException exception) {
System.out.println("An error occurred: " + exception);
} //end of catch.
} //end of main.
}  //end of program.
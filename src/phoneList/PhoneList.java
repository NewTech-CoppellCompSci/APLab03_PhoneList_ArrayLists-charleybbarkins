package phoneList;

import java.util.ArrayList;

import java.util.Scanner;



/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {

	  /*
	 * Instance Variables
	 */
	
	//creates array lists to use later
	 private static ArrayList<Contact> list;
	 private static ArrayList<String> name;
	 private static ArrayList<Long> number;
	 
	 //keeps count for method later
	 private static int count;
	
	 //creates a scanner for whole lab
	static Scanner inKey = new Scanner(System.in);
	
	
	
	//Constructor
	public PhoneList() {
		//initialize instance variables
		list = new ArrayList<Contact>();
	    name = new ArrayList<String>();
		number = new ArrayList<Long>();
		
		//set count 0
		count = 0;
}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number
	 *   - create a new Contact object with that input
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	
	
	public static void addContact() {
		
		//prompt user to input contact name 
        System.out.println();
		System.out.println("Enter contact name: ");
		
		//if this method has been called more than once,
		if (count > 0) {
		
			//a filler keyboard input because it keeps skipping >:(
		     String filler = inKey.nextLine();
		}
		
		//set contact equal to user input
		String contact = inKey.nextLine();
		
		//add name to the name array (stores all names in contact)
		name.add(contact);
		
		 System.out.println();
		 
		 //prompts user for contact number
		System.out.println("Enter contact number: ");
		
		//stores contact number input into contactNum
		Long contactNum = inKey.nextLong();
		
		//adds contactNum to the number array
		number.add(contactNum);
		
		//creates contact based on user input (will later be used to add to list array)
		Contact c1 = new Contact(contact,contactNum );
		
		 String holder;
		 Long numName;
		 Long numName2;
		 String holder2;
		
		 // if method has ran more than once ....
		 //(because if theres only one variable in the array youll go out of bounds).
		if (count > 0) {
		 
			//While I is less than the size of name
		 for (int i = 0 ; i < name.size(); i++) {
			 
			 //while j is less than names size
	            for (int j = i + 1; j < name.size(); j++) {
	               
	            	//value is equal to the integer gotten from .compareTo (interger shows if index should be swapped)
	            	int value = name.get(i).compareTo(name.get(j));
	            	
	               // if name (i) is alphabetically behind name(j)
	                if (value > 0) {

	                    // swap 
	                	//transfer (j) into holder 
	                    holder = name.get(j);
	                    
	                    //transfer (i) into holder 2
	                    holder2 = name.get(i);
	                    
	                    //set name(i) equal to holder
	                    name.set(i, holder);
	                    
	                    //set name(j) equal to holder2
	                    name.set(j,holder2);
	              
	                    
	                    //repeat same process for the numbers array (so numbers and name stay connected)
	                    numName = number.get(j);
	                    numName2 = number.get(i);
	                    number.set(i, numName);
	                    number.set(j,numName2);
 
	                }
	            }
	        }
		} else {
			//if this IS the first time the method has ran, just add contact to list 
			
			list.add(c1);
			
		}
		//clear list 
		list.clear();
		for (int i = 0; name.size() > i; i++) {
			
			//make a new contact to contain name and number of a certain index,
			Contact c3 = new Contact(name.get(i),number.get(i));
			
			//add that index to list
			list.add(c3);
			
		}
		//add to count
		count++;
		System.out.println();
		
		 //tell user what was added. 
		 System.out.println("Contact \"" + contact + "\" under the number \"" + contactNum + "\" has been added");
		
		
	}
	
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public static void removeContact() {
		
		System.out.println();
		
		//makes a long to store removed number in the future
		Long num =number.get(0);
		
		//counts if number has been removed
		int found = 0;
		
		//Prompts user for contact to delete
		System.out.println("What contact would you like to delete?");
		
		//stores users input
		String remove = inKey.next();
		
		//while i is less than names size...
		for (int i = 0; i < name.size(); i++) {
			
			//go through every index and check to see if it finds removed name
			if (name.get(i).equals(remove)) {
				
				//if found, set num equal to number found at that index 
				num = number.get(i);
				
				//remove from name list
				name.remove(i);
				
				//remove from list array
				list.remove(i);
				//remove from number array
				number.remove(i);
				//add to found
				found++;
				
			}
		}
		
		//if no number was removed,
		if (found == 0) {
			//tell user contact was not found
			System.out.println();
			System.out.println("That contact was not found.");
			
		}else { //else....
			System.out.println();
			//tell user the name and number that was removed
		System.out.println("Contact \"" + remove + "\" at the number \"" + num + "\"  has been removed" );
		
		}
		
	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	public static void printList() {
		
		//makes header
		System.out.println("\n\n-----------------------");
		System.out.println("   Name      Number\n-----------------------");
		
		
		//as long as i is less than list size...
		for (int i = 0; i < list.size(); i++) {
			//print every contact in list (already alphabetical
			System.out.println(list.get(i) + "\n");
		}
		
		System.out.println("-----------------------");
		System.out.println("\n");
		
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	public static void menu() {
		
		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	public static String getString(String str) {
		
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		return inKey.nextLine();
		
	}
	
	
	public static void main(String[] args) {
		
		PhoneList app = new PhoneList();
		app.menu();
	}
}

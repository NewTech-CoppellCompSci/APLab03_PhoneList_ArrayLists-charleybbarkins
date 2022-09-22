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
	
	 public static ArrayList<Contact> list;
	 public static ArrayList<String> name;
	 public static ArrayList<Long> number;
	 public static int count;
	
	
	static Scanner inKey = new Scanner(System.in);
	//Constructor
	public PhoneList() {
		//initialize instance variables
		list = new ArrayList<Contact>();
	    name = new ArrayList<String>();
		number = new ArrayList<Long>();
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
		
        System.out.println();
		System.out.println("Enter contact name: ");
		
		if (count > 0) {
		
		     String filler = inKey.nextLine();
		}
		
		String contact = inKey.nextLine();
		
		name.add(contact);
		
		 System.out.println();
		System.out.println("Enter contact number: ");
		
		Long contactNum = inKey.nextLong();
		
		number.add(contactNum);
		
		Contact c1 = new Contact(contact,contactNum );
		
		 String holder;
		 Long numName;
		 Long numName2;
		 String holder2;
		
		if (count > 0) {
		 
		 for (int i = 0 ; i < name.size(); i++) {
	            for (int j = i + 1; j < name.size(); j++) {
	               
	            	int value = name.get(i).compareTo(name.get(j));
	            	
	                // to compare one string with other strings
	                if (value > 0) {

	                    // swapping
	                    holder = name.get(j);
	                    holder2 = name.get(i);
	                    name.set(i, holder);
	                    name.set(j,holder2);
	              
	                    numName = number.get(j);
	                    numName2 = number.get(i);
	                    number.set(i, numName);
	                    number.set(j,numName2);
 
	                }
	            }
	        }
		} else {
			
			list.add(c1);
			
		}
		list.clear();
		for (int i = 0; name.size() > i; i++) {
			
			Contact c3 = new Contact(name.get(i),number.get(i));
			
			list.add(c3);
			
		}
		count++;
		System.out.println();
		
		 
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
		
		System.out.println("What contact would you like to delete?");
		
		String remove = inKey.next();
		
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).equals(remove)) {
				
				name.remove(i);
				list.remove(i);
				number.remove(i);
				
			}
		}
		
		System.out.println("Contact \"" + remove + "\"  has been removed" );
		
		System.out.println();
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
		
		System.out.println("\n\n-----------------------");
		System.out.println("   Name      Number\n-----------------------");
		
		
		for (int i = 0; i < list.size(); i++) {
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

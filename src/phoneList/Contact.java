package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {
	
	//makes string variabel to store the name 
	private String name;
	
	//makes Long variable to store the number
	private Long number;
	
	
//constructor
	public Contact(String name, Long number) {
		
		//sets variables to parameters
		this.name = name;
				
	    this.number = number; 
				
	}
	
	//getter
	public String getName() {
    	
		//returns name
  		return  name;
	}
	
	//getter 
	public Long getNumber() {
    	
		//returns number
  		return number;
	}
	
	//setter
	public void setName(String name) {
		//set name to parameter name
		this.name = name;
	}
	
	//setter
	public void setNumber(Long number) {
		//set number to parameter number
		this.number = number;
	}
	
	@Override
	  public String toString() {
			
	    //Helps format printing of information later on Runner page ( for printList() )
	     return " " +name + "  --  " + number;
    }
	
	
}

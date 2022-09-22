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
	
	private String name;
	
	private Long number;
	
	

	public Contact(String name, Long number) {
		this.name = name;
				
	    this.number = number; 
				
	}
	
	public String getName() {
    	
  		return  name;
	}
	
	public Long getNumber() {
    	
  		return number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(Long number) {
		this.number = number;
	}
	
	@Override
	  public String toString() {
			
	    //Helps format printing of information later on Runner page
	     return " " +name + "  --  " + number;
    }
	
	
}

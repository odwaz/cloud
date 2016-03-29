package order;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServlet;

public class Order   implements Serializable 
{
    static final long serialVersionUID = 7103954158550675528L;
    
	private String name;
	private String address;
	private String city;
	private boolean mushrooms;
	private boolean beef;
	private boolean sausage;
	private String size;
    private int count;	
    private int ConfirmationNumber;


	private String email;
	
	

	public int getCount() {
		return count;
	}



	public void setCount(int i) {
		this.count = i;
	}




	public int getConfirmationNumber() {
		return ConfirmationNumber;
	}



	public void setConfirmationNumber(int confirmationNumber) {
		ConfirmationNumber = confirmationNumber;
	}



	public double getPrice()
	{
		// calculate the price
		  double price = 18.95;
		  if ( getSize().equalsIgnoreCase ( "Small" ) )
			  price = 10.95;
		  else if ( getSize().equalsIgnoreCase ( "Medium" ) )
			  price = 14.95;
			
		  if ( isBeef() )
			  price += 1;
			
		  if ( isMushrooms() )
			  price += 1;
			
		  if ( isSausage() )
			  price += 1;
		
		return price;
	}
	
	

	public boolean isBeef()
	{
		return beef;
	}

	public boolean isMushrooms()
	{
		return mushrooms;
	}

	public boolean isSausage()
	{
		return sausage;
	}

	public String getSize()
	{
		return size;
	}

	public void setBeef(boolean b)
	{
		beef = b;
	}

	public void setMushrooms(boolean b)
	{
		mushrooms = b;
	}

	public void setSausage(boolean b)
	{
		sausage = b;
	}

	public void setSize(String string)
	{
		size = string;
	}

	public String getAddress()
	{
		return address;
	}

	public String getName()
	{
		return name;
	}

	public String getCity()
	{
		return city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String string)
	{
		address = string;
	}

	public void setName(String string)
	{
		name = string;
	}

	public void setCity(String string)
	{
		city = string;
	}	
	
	
}

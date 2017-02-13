package for_Database;
import java.io.*;

//Gloriane Tran 
//CS 64, Final Project 
//May 13th, 2015

/**
 * The Address class represents the address information. There are fields for
 * users to enter their first name, middle name, last name, street line, 
 * optional street line, city, state and zipcode. The text is gathered 
 * to make an address for the contact information. 
 * @author gtran
 */

public class Address implements Comparable<Address>, Serializable{
	/**
	 * A String representation of the address' street.
	 */
	private String myStreet;
	/**
	 * An Optional String field for the address.
	 */
	private String myStreet2;
	/**
	 * A String representation of the address' city.
	 */
	private String myCity;
	/**
	 * A String representation of the address' state.
	 */
	private String myState; 
	/**
	 * A String representation of the address' zipcode. 
	 */
	private String myZip;
	/**
	 * A collection of Strings(array) that represent the abbreviations 
	 * of the states in the U.S.
	 */
	public static final String[] STATES = {"--",
		"AL", "AK","AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", 
		"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", 
		"MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
		"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", 
		"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
	/**
	 * A 5 parameter constructor that constructs an address
	 * using the first and second street line, the city, the state and the zipcode. 
	 * @param theStreet A String representation of the street line in an address. 
	 * @param theStreet2 A String representation of the optional line in an address. 
	 * @param theCity A String representation of the city in an address. 
	 * @param theState A String representation of the state in an address. 
	 * @param theZip A String representation of the zip code in an address. 
	 */

	public Address(String theStreet, String theStreet2, String theCity, String theState, String theZip){
		myStreet = theStreet; 
		myStreet2 = theStreet2; 
		myCity = theCity; 
		myState = theState; 
		myZip = theZip; 
	}//5 parameter constructor

	/**
	 * A 4 parameter constructor that constructs an address using 
	 * the first street line, the city, the state and the zip code. 
	 * @param theStreet A String representation of the street line in an address. 
	 * @param theCity A String representation of the city in an address.
	 * @param theState A String representation of the state in an address.
	 * @param theZip A String representation of the zip code in an address.
	 */
	public Address(String theStreet, String theCity, String theState, String theZip){
		myStreet = theStreet; 
		myCity = theCity; 
		myState = theState; 
		myZip = theZip; 
		myStreet2 = "";
	}//4 parameter constructor

	/**
	 * A 0 parameter constructor that creates an empty address. 
	 */
	public Address(){
		myStreet = ""; 
		myStreet2 = ""; 
		myCity = ""; 
		myState = ""; 
		myZip = ""; 
	}//0 parameter constructor

	/**
	 * A get method that returns a String representation of the 
	 * first street line
	 * @return a String representing the first street line of the address 
	 */
	public String getStreet(){
		return myStreet; 
	}//getStreet
	
	/**
	 * A get method that returns a String representation of the 
	 * second street line
	 * @return a String representing the second street line of the address 
	 */
	public String getStreet2(){
		return myStreet2; 
	}//getStreet2
	
	/**
	 * A get method that returns a String representation of the 
	 * city
	 * @return a String representing the city of an address. 
	 */
	public String getCity(){
		return myCity; 
	}//getCity
	
	/**
	 * A get method that returns a String representation of
	 * the state 
	 * @return a String representation of the state of an address.
	 */
	public String getState(){
		return myState; 
	}//getState
	
	/**
	 * A get method that returns a String representation of 
	 * the zipcode.
	 * @return a String representing the zipcode of an address. 
	 */
	public String getZip(){
		return myZip; 
	}//getZip
	
	/**
	 * A set method that changes the first street line.
	 * @param theStreet A String representation of the street.
	 */
	public void setStreet(String theStreet){
		myStreet = theStreet; 
	}//setStreet

	/**
	 * A set method that changes the second street line.
	 * @param theStreet2 A String representation of the optional line. 
	 */
	public void setStreet2(String theStreet2){
		myStreet2 = theStreet2; 
	}//setStreet2
	
	/**
	 * A set method that changes the street.
	 * @param theCity A String representation of the city. 
	 */
	public void setCity(String theCity){
		myCity = theCity; 
	}//setCity

	/**
	 * A set method that changes the state.
	 * @param theState A String representation of the state.
	 */
	public void setState(String theState){
		myState = theState; 
	}//setState
	
	/**
	 * A set method that changes the zipcode. 
	 * @param theZip A String representation of the zipcode. 
	 */
	public void setZip(String theZip){
		myZip = theZip; 
	}//setZip
	
	/**
	 * The equals method compares String representations
	 * of the street, optional line, city, state,
	 * and zipcode to check if they are identical.
	 * @param theOther The object that is being compared to. 
	 * @return true if the address is equal to addres being compared,
	 * false if the address is not equal.
	 */
	@Override
	public boolean equals(Object theOther){
		Address theAddress = (Address)theOther;
		return myStreet.equals(theAddress.myStreet)&&
				myStreet2.equals(theAddress.myStreet2)&&
				myCity.equals(theAddress.myCity)&&
				myState.equals(theAddress.myState)&&
				myZip.equals(theAddress.myZip);
	}//equals

	/**
	 * The compareTo method compares the state, city, zipcode, 
	 * street, and optional street line in that specific order. 
	 * @param theAddress The address that is being compared to. 
	 * @return a number if the item being compared is before, after, or
	 * equal to the other item.
	 */
	public int compareTo(Address theAddress){
		int compareValue = myState.compareTo(theAddress.myState);
		if(compareValue != 0){
			return compareValue;
		}//if
		compareValue = myCity.compareTo(theAddress.myCity);
		if(compareValue != 0){
			return compareValue;
		}//compareTo
		compareValue = myZip.compareTo(theAddress.myZip);
		if(compareValue != 0){
			return compareValue;
		}//if
		compareValue = myStreet.compareTo(theAddress.myStreet);
		if (compareValue != 0){
			return compareValue;
		}//if
		return myStreet2.compareTo(theAddress.myStreet2);
	}//compareTo 

	/**
	 * The before method determines if an address is before or 
	 * after another address. 
	 * @param theAddress The address information being compared to. 
	 * @return true if the address being compared is before the address,
	 * and false if the address being compared is after the address.
	 */
	public boolean before(Address theAddress){
		return compareTo(theAddress) < 0;
	}//before

	/**
	 * The toString method prints out the address. 
	 * @return The address information. 
	 */
	public String toString(){ 
		if(myStreet.equals("")){
		return "\n";	
		}else{
		return "\n" + myStreet + "\n" + ("".equals(myStreet2) ? "" : myStreet2 + "\n") +
				myCity +  ", " + myState + " " + myZip;
		}//else
	}//toString

}//Address
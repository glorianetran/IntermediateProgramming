package for_Database;
//Gloriane Tran
//Final Project 
//May 13th, 2014
//CS 64
import java.util.*;
import java.io.*;

/**
 * The AddressInfo class represents the contact information consisting of the name 
 * and address. There are fields for users to enter their first name, middle name, 
 * last name,street, optional street line, city, state and zipcode. The texts are 
 * gathered to make a contact information here. 
 * @author gtran
 */
public class AddressInfo implements Comparable<AddressInfo>, Serializable {

	/**
	 * The name of the contact info.
	 */
	private Name myName;
	/**
	 * The address of the contact info. 
	 */
	private Address myAddress;

	/**
	 * A comparator that overrides the natural ordering for overrides. 
	 */
	public static final Comparator<AddressInfo> ADDRESS_COMPARATOR = 
			((aI1,aI2) -> {
				return resultForComparator(aI1, aI2);
			});

	/**
	 * An int that holds a number that represents if the address is before, 
	 * after, or equal to another address. 
	 * @param aI1 A contact that is being compared. 
	 * @param aI2 A contact that is being compared.  
	 * @return a number represented whether the contact infos are
	 *  before, after or equals to each other. 
	 */
	private static int resultForComparator(AddressInfo aI1, AddressInfo aI2){
		int result = aI1.myAddress.compareTo(aI2.myAddress);
		if(result != 0){
			return result;
		}//if addresses are not the same
		return aI1.myName.compareTo(aI2.myName);		
	}//resultForComparator

	/**
	 * An 8 parameter constructor that creates a contact info using the first name,
	 * middle name, last name, street, optional line, city, state and zipcode.
	 * @param theFirst A String representation of the first name. 
	 * @param theMiddle A String representation of the middle name.  
	 * @param theLast A String representation of the last name. 
	 * @param theStreet A String representation of the street line in an address. 
	 * @param theStreet2 A String representation of the optional line in an address. 
	 * @param theCity A String representation of the city in an address. 
	 * @param theState A String representation of the state in an address. 
	 * @param theZip A String representation of the zipcode in an address. 
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast, String theStreet,
			String theStreet2, String theCity, String theState, String theZip){
		myName = new Name (theFirst, theMiddle, theLast);
		myAddress = new Address(theStreet,theStreet2,theCity,theState,theZip);
	}//8 parameter constructor

	/**
	 * An 7 parameter constructor that constructs a contact info using first name, 
	 * middle name, last name, street, city, state and zipcode.
	 * @param theFirst A String representation of the first name.
	 * @param theMiddle A String representation of the middle name.
	 * @param theLast A String representation of the last name.
	 * @param theStreet A String representation of the street line in an address.
	 * @param theCity A String representation of the city in an address.
	 * @param theState A String representation of the state in an address.
	 * @param theZip A String representation of the zipcode in an address.
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast, String theStreet,
			String theCity, String theState, String theZip){
		myName = new Name (theFirst, theMiddle, theLast);
		myAddress = new Address(theStreet,theCity,theState,theZip);
	}//7 parameter constructor

	/**
	 * A 3 parameter constructor that constructs a contact info using the first name,
	 * middle name, and last name. 
	 * @param theFirst A String representation of the first name.
	 * @param theMiddle A String representation of the middle name.
	 * @param theLast A String representation of the last name.
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast){
		myName = new Name (theFirst, theMiddle, theLast);
		myAddress = new Address();
	}//3 parameter constructor

	/**
	 * The hashCode method overrides the hashCode in the Object class
	 * to work in conjunction with the equals method that compares the
	 * first name, middle name and last name. 
	 * @return Returns a hash code value for the AddressInfo. 
	 */
	public int hashCode(){
		return myName.getFirst().length() + myName.getMiddle().length()
				+myName.getLast().length();
	}//hashCode
	
	/**
	 * A get method that returns the name of the contact info.
	 * @return Name information consisting of the first name,
	 * middle name, and the last name. 
	 */
	public Name getName(){
		return myName;
	}//getName

	/**
	 * A get method that returns the address of the contact info.
	 * @return Address information consisting of the street line, 
	 * the optional line, the city, the state, and the zipcode. 
	 */
	public Address getAddress(){
		return myAddress;
	}//getAddress

	/**
	 * A set method that changes the name of the contact info.
	 * @param theName Name information consisting of the first name,
	 * middle name, and last name. 
	 */
	public void setName(Name theName){
		myName = theName;
	}//setName

	/**
	 * A set method that changes the address of the contact info.
	 * @param theAddress Address information consisting of the street line,
	 * the optional line, the city, the state and the zipcode. 
	 */
	public void setAddress(Address theAddress){
		myAddress = theAddress; 
	}//setAddress

	/**
	 * A toString method that prints out the contact info. 
	 * @return the contact information 
	 */
	public String toString(){
		return ""+ myName + "" + myAddress;
	}//toString

	/**
	 * The equals method compares two contact infos to 
	 * see if they are equivalent to each other. 
	 * @param theOther the object being compared to. 
	 * @return true if the contact infos are equal, 
	 * false if the contact infos are not equal.
	 */
	public boolean equals(Object theOther){
		AddressInfo theAddressInfo = (AddressInfo)theOther;
		return myName.equals(theAddressInfo.myName);
	}//equals

	/**
	 * A compareTo method that compares the contact infos' 
	 * names. 
	 * @param theAddressInfo The contact information being compared. 
	 * @return a number if the item being compared is before, after, or
	 * equal to the other item.
	 */
	@Override
	public int compareTo(AddressInfo theAddressInfo){
		return myName.compareTo(theAddressInfo.myName);	
	}//compareTo

	/**
	 * The beforeAlpha method checks to see if the name of the 
	 * contact info is before the name of the contact info being 
	 * compared to. 
	 * @param theAddressInfo The contact information being compared. 
	 * @return true if the name is before the name being compared,
	 * false if the name is after or equal to the name being
	 * compared. 
	 */
	public boolean beforeAlpha(AddressInfo theAddressInfo){
		return myName.compareTo(theAddressInfo.myName) < 0;
	}//beforeAlpha

	/**
	 * The beforeAddress method checks to see if the address of the
	 * contact info is before the address of the contact info being
	 * compared.
	 * @param theAddressInfo The contact info being compared. 
	 * @return true if the address of the contact info is before
	 * the address of the contact info being compared, or if the
	 * address and name of the contact info is equal to the address
	 * and name of the contact being compared are equal. false if
	 * anything otherwise. 
	 */
	public boolean beforeAddress(AddressInfo theAddressInfo){
		return myAddress.before(theAddressInfo.myAddress) || 
				(myAddress.equals(theAddressInfo.myAddress) &&
						myName.before(theAddressInfo.myName));
	}//beforeAddress

}//AddressInfo 

package for_Database;
//Gloriane Tran
//May 13th, 2015
//Final Project P1
//CS 64
import java.io.*;

/**
 * This name class represents the name information. The text entered in the 
 * fields for users to enter their first name, middle name and last name are gathered 
 * and created here for the contact information. 
 * @author gtran
 */

public class Name implements Comparable<Name>, Serializable{
	/**
	 * A reference to the first name. 
	 */
	private String myFirst;
	/**
	 * A reference to the middle name. 
	 */
	private String myMiddle;
	/**
	 * A reference to the last name. 
	 */
	private String myLast;

	/**
	 * This is a 3 parameter constructor that constructs a name
	 * from the first name, middle name, and last name.
	 * @param theFirst A string representation of the first name. 
	 * @param theMiddle A string representation of the middle name. 
	 * @param theLast A string representation of the last name. 
	 */

	public Name(String theFirst, String theMiddle, String theLast){
		myFirst = theFirst;
		myMiddle = theMiddle;
		myLast = theLast;
	}// 3 parameter constructor

	/**
	 * A get method that returns the first name. 
	 * @return The a String representation of the first name. 
	 */
	public String getFirst(){
		return myFirst; 
	}//getFirst

	/**
	 * A get method that returns the middle name.
	 * @return A String representation of the middle name. 
	 */
	public String getMiddle(){
		return myMiddle;
	}//getMiddle

	/**
	 * A get method that returns the last name.
	 * @return A String representation of the last name. 
	 */
	public String getLast(){
		return myLast;
	}//getLast
	
	/**
	 * A set method that changes the first name. 
	 * @param theFirst A String representation of the first name. 
	 */
	public void setFirst(String theFirst){
		myFirst = theFirst;		
	}//setFirst

	/**
	 * A set method that changes the middle name. 
	 * @param theMiddle A String representation of the middle name.  
	 */
	public void setMiddle(String theMiddle){
		myMiddle = theMiddle;
	}//setMiddle

	/**
	 * A set method that changes the last name. 
	 * @param theLast A String representation of the last name. 
	 */
	public void setLast(String theLast){
		myLast = theLast;
	}//setLast

	/**
	 * The toString method prints the name. 
	 * @return A String representation of the name.
	 */
	public String toString(){
		if (myMiddle == ""){
			return myLast + ", " + myFirst;
		}//if
		return myLast + ", " + myFirst + " " + myMiddle;
	}//toString

	/**
	 * The equals method compares the first name,
	 * middle name, and last name to see if they are
	 * identical.
	 * @param theOther The object being compared. 
	 * @return true if the names are equal, 
	 * false if the names are not. 
	 */
	public boolean equals(Object theOther){
		Name theName = (Name)theOther;
		return myFirst.equals(theName.myFirst)&&
				myMiddle.equals(theName.myMiddle)&&
				myLast.equals(theName.myLast);
	}//equals

	/**
	 * The compareTo method compares the last name,
	 * first name and middle name in that specific order.
	 * @param theName The name information being compared. 
	 * @return a number if the item being compared is before, after, or
	 * equal to the other name.
	 */
	@Override
	public int compareTo(Name theName) {
		int compareLast = myLast.compareTo(theName.myLast);
		if (compareLast != 0) {
			return compareLast;
		}//family names were different
		int compareFirst = myFirst.compareTo(theName.myFirst);
		if (compareFirst != 0){
			return compareFirst;
		}// first names were different with identical last name
		return myMiddle.compareTo(theName.myMiddle);
	}//compareTo

	/**
	 * The before method compares two names to 
	 * check if one name is before the other name. 
	 * @param theName The name information being compared. 
	 * @return true if the name is before the
	 * name being compared to, false if it equal 
	 * or after. 
	 */
	public boolean before(Name theName){
		return compareTo(theName) < 0;
	}//theName

	/**
	 * The after method compares two names to 
	 * check if one name is after the other name. 
	 * @param theName The name information being compared. 
	 * @return true if the name is after the 
	 * name being compared to, false if equal or 
	 * before. 
	 */
	public boolean after(Name theName){
		return compareTo(theName) > 0;
	}//theName

}//Name

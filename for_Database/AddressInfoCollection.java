package for_Database;
import java.io.*;
import java.util.TreeSet;
import java.util.HashSet;

//Gloriane Tran
//CS 64
//Final Project P1
//May 4th, 2015

/**
* The AddressInfoCollection class 
* links the GUI to the data structures holding the data.
*/

public class AddressInfoCollection {
	
	/**
	 * A reference to a HashSet that contains contact information. 
	 */
	private HashSet<AddressInfo> myHashSet; 
	
	/**
	 * A constructor that creates a HashSet. 
	 */
	public AddressInfoCollection(){
		myHashSet = new HashSet<>();
	}//constructor	
	
	/**
	 * A method that searches the HashSet for a contact information. 
	 * @param findMe The contact information to be found in the HashSet. 
	 * @return The contact information that was found in the HashSet. 
	 */
	public AddressInfo search(AddressInfo findMe){
		if(!myHashSet.contains(findMe)){
			return null;
		}//no matching AddressInfo object in the TreeSet
		for(AddressInfo current : myHashSet){
			if(current.equals(findMe)){
			return current;
			}//if found a match 
		}//for
		return null;
	}//search
	
	/**
	 * A method that adds the contact information to the HashSet. 
	 * @param addMe The contact information to be added into the HashSet.
	 * @return true if the contact info was added to the HashSet, 
	 * false if the contact info was not added to the HashSet.
	 */
	public boolean add(AddressInfo addMe){
		if(myHashSet.contains(addMe)){
			return false;
		}//duplicate name in Collection
		return myHashSet.add(addMe);
	}//add
	
	/**
	 * A method that deletes the contact information from the HashSet.
	 * @param deleteMe The contact information being deleted from the 
	 * HashSet.
	 * @return true if the contact info was successfully deleted, 
	 * false if the contact info was not deleted. 
	 */
	public boolean delete(AddressInfo deleteMe){
		if(!myHashSet.contains(deleteMe)){
			return false;
		}//cannot delete because it is not in the collection
		return myHashSet.remove(deleteMe);
	}//delete
	
	/**
	 * A method that puts all the contacts from the HashSet into a TreeSet
	 * sorted by name, and then prints out all the contacts in that TreeSet. 
	 * @return A String representation of all the contacts 
	 * in the TreeSet. 
	 */
	public String toStringAlphabetical(){
		String toReturn = "";
		TreeSet<AddressInfo> alphaTS = new TreeSet<>();
		alphaTS.addAll(myHashSet);
		for(AddressInfo current: alphaTS){
		toReturn += "\n" + current + "\n";
		}//for
		return toReturn;
	}//toStringAlphabetical
	
	/**
	 * A method that puts all the contacts from the HashSet into a TreeSet
	 * sorted by address, and then prints out all the contacts in that TreeSet. 
	 * @return A String representation of all the contacts 
	 * in the TreeSet. 
	 */
	public String toStringByAddress(){
		String toReturn = "";
		TreeSet<AddressInfo> addressTS = 
				new TreeSet<>(AddressInfo.ADDRESS_COMPARATOR);
		addressTS.addAll(myHashSet);
		for(AddressInfo current: addressTS){
			toReturn += "\n" + current + "\n";
			}//for
		return toReturn;
	}//toStringByAddress
	
	/**
	 * A method that saves the the contact information in the HashSet 
	 * to a file. 
	 * @param fileName The name of the file to be saved to. 
	 * @return A String message containing errors if the save fails. 
	 */
	public String saveToFile(String fileName){
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(
				new FileOutputStream(fileName));
				for(AddressInfo current: myHashSet){
					oOS.writeObject(current);
				}//for
				oOS.flush();
				oOS.close();
			}//try 
		catch(Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile
	
	/**
	 * A method that loads the contact information in a file. 
	 * @param fileName The name of the file to be loaded. 
	 * @return A String message containing errors if the load fails. 
	 */
	public String loadFromFile(String fileName){
		String toReturn = "";
		try{
			ObjectInputStream oIS =
					new ObjectInputStream(new FileInputStream(fileName));
			while(true){
				AddressInfo fromFile = (AddressInfo)(oIS.readObject());
				AddressInfo found = search(fromFile);
				if(found == null){
					if(add(fromFile)){
						toReturn += fromFile + "\n-- successfully added to List.\n" + "\n";
					}else{
						toReturn += fromFile + "\n-- not successfully added to List.\n" + "\n";
					}//innerelse
				}else{
					toReturn += found + "\n--already in Database."
							+ " Record not added from file!\n" + "\n";
				}//else
			}//while
		}//try
		catch(EOFException eOF) {
		}//catch
		catch(Exception e){
			toReturn += e;
		}//catch
		return toReturn;
	}//loadFromFile
	
	/**
	 * A method that checks if the HashSet is empty. 
	 * @return true if the HashSet contains no contact information, 
	 * false if there is contact information in the HashSet. 
	 */
	public boolean isEmpty(){
		return myHashSet.isEmpty();
	}//isEmpty
	
}//AddressInfoCollection

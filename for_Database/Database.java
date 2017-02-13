package for_Database;
import java.util.*;
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import javax.swing.*;

//Gloriane Tran
//May 13th, 2015
//Final Project P1
//CS 64

/**
 * The Database applications let's user's enter new contact information into the Database, 
 * save the information in the Database to a file, and load the file into the Database. 
 * The Database is similar to an address book that keeps the contact information of people or
 * the information entered. 
 * @author gtran
 */

public class Database extends JFrame implements ActionListener { 
	/**
	 * A button that adds the contact information. 
	 */
	private JButton addB;
	/**
	 * A button that displays the contact information in the Database.
	 */
	private JButton displayB;
	/**
	 * A button that alphabetically displays the contact information 
	 * in the Database based on the contact's first name. 
	 */
	private JButton alphaSortB;
	/**
	 * A button that displays the contact information 
	 * in the Database ordered by the contact's address. 
	 */
	private JButton addressSortB;
	/**
	 * A button to search for a contact in the Database. 
	 */
	private JButton searchB;
	/**
	 * A button to delete a contact from the Database. 
	 */
	private JButton deleteB;
	/**
	 * A button that confirms an action made by the user. 
	 */
	private JButton confirmB;
	/**
	 * A button that cancels an action made by the user. 
	 */
	private JButton cancelB;
	/**
	 * A text field for the user enters their first name. 
	 */
	private JTextField firstTF;
	/**
	 * A text field for the user enters their middle name. 
	 */
	private JTextField middleTF;
	/**
	 * A text field for the user enters their last name. 
	 */
	private JTextField lastTF;
	/**
	 * A text field for the user enters the street name of 
	 * their address. 
	 */
	private JTextField streetTF;
	/**
	 * A text field for the user enters the optional line of 
	 * their address. 
	 */
	private JTextField optionalTF;
	/**
	 * A text field for the user enters the city of their 
	 * address.
	 */
	private JTextField cityTF;
	/**
	 * A text field for the user enters the zipcode of their 
	 * address. 
	 */
	private JTextField zipTF;
	/**
	 * A text field for the user to enter the file name they want
	 * to save the contacts in the Database to. 
	 */
	private JTextField fileTF;
	/**
	 * A text area where the contact information appears. 
	 */
	private JTextArea messageTA;
	/**
	 * A label to help the user indicate where to input 
	 * their first name. 
	 */
	private JLabel firstL;
	/**
	 * A label to help the user indicate where to input their
	 * middle name. 
	 */
	private JLabel middleL;
	/**
	 * A label to help the user indicate where to input their 
	 * last name. 
	 */
	private JLabel lastL;
	/**
	 * A label to help the user indicate where to input the street
	 * line of the user's address. 
	 */
	private JLabel streetL;
	/**
	 * A label to to help the user indicate where to input the optional 
	 * line of the user's address. 
	 */
	private JLabel optionalL;
	/**
	 * A label to help the user indicate where to input the city of
	 * the user's address. 
	 */
	private JLabel cityL;
	/**
	 * A label to help the user indicate where to input the state of the
	 * user's address. 
	 */
	private JLabel stateL;
	/**
	 * A label to help the user indicate where to input the zipcode 
	 * of the user's address. 
	 */
	private JLabel zipL;
	/**
	 * A label to help the user indicate where to input the file name.
	 */
	private JLabel fileL;
	/**
	 * A scroll pane in the text area that allows the user to 
	 * scroll through the contacts if the list of contacts 
	 * exceeds the size of the text area. 
	 */
	private JScrollPane messageSP;
	/**
	 * A error text area that has messages appear to inform 
	 * users of possible errors. 
	 */
	private JTextArea errorTA;
	/**
	 * A drop down menu where the user can select a state for
	 * their address. 
	 */
	private JComboBox stateCB;
	/**
	 * The layout out of the program. 
	 */
	private Container myCP; 
	/**
	 * A reference to a contact that used to search delete. 
	 */
	private AddressInfo found; 
	/**
	 * A button that loads a file. 
	 */
	private JButton loadB;
	/**
	 * A button that saves the contacts in the database 
	 * to a file. 
	 */
	private JButton saveB;
	/**
	 * A reference to a file name being processed by a save or load command.
	 */
	private String fileName;
	/**
	 * refer to a record currently being used 
	 * and a record found in the list in memory 
	 */
	private AddressInfo currentAIRecord;
	/**
	 * A true/false value that is set to true when awaiting OK 
	 * or Cancel during a Save to file operation
	 */
	private boolean processingSave; 
	/**
	 * A true/false value that set to true when awaiting OK or Cancel
	 */
	private boolean processingDelete;
	/**
	 * A String used to pass a message from validNameInput method
	 */
	private String errorMsg;
	/**
	 * A String used to pass first name from validNameInput method
	 */
	private String fName;
	/**
	 * A String used to pass the last name from validNameInput method
	 */
	private String lName; 
	/**
	 * An Address Info Collection that holds the address information
	 */
	private AddressInfoCollection myCollection = new AddressInfoCollection();

	public Database() { 
		super("Database"); 
		setSize(950, 800); 
		setLocation(100,100); 
		myCP = getContentPane(); 
		myCP.setLayout(null); 
		myCP.setBackground(new Color(55,200,240));

		constructAllButtons();
		constructAllTextFields();
		constructAllLabels();
		constructAllScrollPanes();
		errorTA = UtilityMethods.makeTextArea(30,290,500,100,myCP, false);

		stateCB = new JComboBox(Address.STATES);
		stateCB.setSize(150,30);
		stateCB.setLocation(450,180);
		myCP.add(stateCB);

		processingSave = false; //not processing a save yet 
		processingDelete = false;//not processing a delete yet

		setVisible(true); 
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 
	}//Database. This is the end of the constructor 

	/**
	 * This is a method that creates the buttons that the user interacts with 
	 * in the Database. 
	 */
	public void constructAllButtons(){
		addB = UtilityMethods.makeButton(550, 400, 160, 20, "Add",
				(ActionEvent e) -> addClicked(), myCP, true);
		alphaSortB = UtilityMethods.makeButton(550, 450, 160, 20, "Alpha\nOrder\nDisplay",
				(ActionEvent e) -> sortName(), myCP, true);
		addressSortB = UtilityMethods.makeButton(550, 500, 160, 20, "Address\nOrder\nDisplay",
				(ActionEvent e) -> sortAddress(), myCP, true);
		searchB = UtilityMethods.makeButton(550, 550, 160, 20, "Search",
				(ActionEvent e) -> search(), myCP, true);
		deleteB = UtilityMethods.makeButton(750, 400, 100, 20, "Delete",
				(ActionEvent e) -> delete(), myCP, true);
		confirmB = UtilityMethods.makeButton(750, 550, 100, 20, "Confirm",
				(ActionEvent e) -> confirm(), myCP, false);
		saveB = UtilityMethods.makeButton(750, 500, 100, 20, "Save",
				(ActionEvent e) -> save(), myCP, true);
		cancelB = UtilityMethods.makeButton(750, 600, 100, 20, "Cancel",
				(ActionEvent e) -> cancel(), myCP, false);
		loadB = UtilityMethods.makeButton(750, 450, 100, 20, "Load",
				(ActionEvent e) -> load(), myCP, true);
	}//constructAllButtons

	/**
	 * This is a method that creates the text fields where the user enters information 
	 * into in the Database. 
	 */

	public void constructAllTextFields(){
		firstTF = UtilityMethods.makeTextField(130,30,150,30, myCP);
		middleTF = UtilityMethods.makeTextField(130,80,150,30, myCP);
		lastTF = UtilityMethods.makeTextField(130,130,150,30, myCP);
		streetTF = UtilityMethods.makeTextField(450,30,150,30, myCP);
		optionalTF = UtilityMethods.makeTextField(450,80,150,30, myCP);
		cityTF = UtilityMethods.makeTextField(450,130,150,30, myCP);
		zipTF = UtilityMethods.makeTextField(450,230,150,30, myCP);
		fileTF = UtilityMethods.makeTextField(750,30,150,30, myCP);
	}//constructAllTextFields

	/**
	 * This is a method that creates the labels to help the user indicate where to
	 * input information in the Database. 
	 */

	public void constructAllLabels(){
		firstL = UtilityMethods.makeJLabel(40, 30, 150, 20,"First Name*", myCP);
		middleL = UtilityMethods.makeJLabel(40, 80, 150, 20,"Middle Name*", myCP);
		lastL = UtilityMethods.makeJLabel(40, 130, 150, 20,"Last Name*", myCP);
		streetL = UtilityMethods.makeJLabel(350, 30, 150, 20,"Street Name*", myCP);
		optionalL = UtilityMethods.makeJLabel(350, 80, 150, 20,"Optional Line", myCP);
		cityL = UtilityMethods.makeJLabel(350, 130, 150, 20,"City*", myCP);
		stateL = UtilityMethods.makeJLabel(350, 180, 150, 20,"State*", myCP);
		zipL = UtilityMethods.makeJLabel(350, 230, 150, 20,"Zip*", myCP); 
		fileL = UtilityMethods.makeJLabel(670, 32, 150, 20,"File Name", myCP); 
	}//constructAllLabs

	/**
	 * This is a method that creates the scroll pane to help the user scroll through
	 * the contacts when the size of the contact list exceeds the message box. 
	 */
	public void constructAllScrollPanes(){
		messageTA = UtilityMethods.makeTextArea2(false);
		messageSP = UtilityMethods.makeScrollPane(30, 400, 500, 350, myCP, messageTA);
	}//constructAllScrollPanes


	/**
	 * A method that clears the text in the text fields. 
	 */
	private void clearInputFields() {
		firstTF.setText("");
		middleTF.setText("");
		lastTF.setText("");
		streetTF.setText("");
		optionalTF.setText("");
		cityTF.setText("");
		zipTF.setText("");
		stateCB.setSelectedIndex(0);
		fileTF.setText("");
	}//clearInputFields

	/**
	 * A method that adjusts the buttons according to the actions of the user.
	 * @param tFValue A true or false value that determines if buttons are 
	 * enabled or disabled. 
	 */
	private void adjustButtons(boolean tFValue) {
		saveB.setEnabled(tFValue);
		searchB.setEnabled(tFValue);
		deleteB.setEnabled(tFValue);
		loadB.setEnabled(tFValue);
		confirmB.setEnabled(!tFValue);
		cancelB.setEnabled(!tFValue);
	}//clearInputFields

	/**
	 * A method that resets the buttons and clears the text fields. 
	 */
	private void reset() {
		adjustButtons(true);
		clearInputFields();
	}//reset
	/**
	 * A method that gets the texts the user enters in the text field and
	 * constructors a message.  
	 * @param theTF The text the user enters into the text field that is used in the message. 
	 * @param theText The text needed for the message. 
	 * @return A String that represents a message to the user. 
	 */
	private String getUserInput(JTextField theTF, String theText){
		String userInput = theTF.getText();
		if (userInput.equals("")){
			errorMsg += "You need to enter a " + theText + " name.\n";
		}//if
		return userInput;
	}//getUserInput

	/**
	 * A method that determines if the user's name input is valid or invalid. 
	 * @return A method that returns true if the name input is valid, false if the name input 
	 * is invalid.
	 */
	public boolean validNameInput() {
		errorMsg = "";
		fName = getUserInput(firstTF,"first");
		lName = getUserInput(lastTF,"last");
		return errorMsg.equals("");
	}//validNameInput method

	/**
	 * A method that returns the user's name. 
	 * @return A collection of Strings that represent the user's first
	 * name, middle name and last name. 
	 */
	public String[] getUserNames(){
		return new String[] { firstTF.getText(),
				middleTF.getText(), lastTF.getText()};
	}//getUserNames

	/**
	 * A method that gets the user's address from the text fields. 
	 * @return A collection of Strings that represent the user's street line,
	 * optional line, city, state and zipcode in their address. 
	 */
	//Method to get the user's address from the text fields
	public String[] getUserAddress(){
		return new String[] { streetTF.getText(), optionalTF.getText(),
				cityTF.getText(),(String) stateCB.getSelectedItem(),
				zipTF.getText()};
	}//getUserAddress

	/**
	 * A method that checks for empty names. 
	 * @param nameArray A collection of Strings that represent the first name, 
	 * middle name and the last name that the user entered into the text fields. 
	 * @return true if there is text in the first name, middle name, and last name text
	 * fields.  
	 * false, if there is no text in the first name, middle name and last name text
	 * fields. 
	 */
	public boolean checkForEmptyName(String[] nameArray){
		messageTA.setText("");
		boolean noErrors = true;
		if(nameArray[0].equals("")){
			noErrors = false;
			messageTA.append("Error. Please enter first name\n");
		}//if

		if(nameArray[1].equals("")){
			noErrors = false;
			messageTA.append("Error. Please enter middle name\n");
		}//if

		if(nameArray[2].equals("")){
			noErrors = false;
			messageTA.append("Error. Please enter last name\n");
		}//if
		return noErrors;
	}//checkForEmptyName


	/**
	 * A method that checks for empty Addresses.
	 * @param addressArray A collection of Strings that represent the street line, 
	 * the optional line, the city, the state and the zip code that the user entered 
	 * into the text fields. 
	 * @return true if there is text in the street line, optional line, city, state, and 
	 * zipcode text fields. false if there is no text in the street line, optional line, 
	 * city, state, and zip ode text fields. 
	 */
	public boolean checkForEmptyAddress(String [] addressArray){
		boolean noErrors = true; 
		messageTA.setText("");
		if(addressArray[0].equals("")){
			noErrors = false; 
			messageTA.append("Error. Please enter street name\n");
		}//if

		if(addressArray[2].equals("")){
			noErrors = false; 
			messageTA.append("Error. Please enter city name\n");
		}//if

		if(addressArray[3].equals("--")){
			noErrors = false; 
			messageTA.append("Error. Please enter state name\n");
		}//if

		if(addressArray[4].equals("")){
			noErrors = false; 
			messageTA.append("Error. Please enter zip name\n");
		}//if
		return noErrors;
	}//checkForEmptyAddress

	/**
	 * A method used to help check if a collection is empty. 
	 * @param findMe An AddressInfo used to help search for the specific 
	 * contact information. 
	 */
	public void collectionEmpty(AddressInfo findMe){
		if(myCollection.isEmpty()){
			errorTA.setText("The database is empty.");
			messageTA.setText("");
			return;
		}else{
			errorTA.setText("Are you sure you want to delete the" + 
					" Address Info? ");
			messageTA.setText("" + myCollection.search(findMe));
		}//else
	}//checkIfEmpty

	/**
	 * Methods used in the delete to search for the data item and then change
	 * the appropriate buttons
	 * @param findMe An AddressInfo used to help search for the specific 
	 * contact information. 
	 */
	public void tryToSearch(AddressInfo findMe){
		found = myCollection.search(findMe);
		if(found == null){
			errorTA.setText("The Address Info is not in the database."
					+ " Please enter a new address info.");
			messageTA.setText("");
		}else{
			deleteB.setEnabled(false);
			cancelB.setEnabled(true);
			confirmB.setEnabled(true);
			processingDelete = true; //sets boolean true to indicate which button is being pressed
		}//else
	}//tryToDelete

	/**
	 * A method that adds the contact information to the Database when the user
	 * presses the add button. 
	 */
	public void addClicked(){
		String[] nameArray = getUserNames();
		String[] addressArray = getUserAddress();
		if(checkForEmptyName(nameArray) && checkForEmptyAddress(addressArray)){
			AddressInfo userInfo = new AddressInfo(nameArray[0], nameArray[1],
					nameArray[2], addressArray[0], addressArray[1], addressArray[2], 
					addressArray[3],addressArray[4]);
			if(myCollection.add(userInfo)){
				errorTA.setText("The AddressInfo was added.");
				messageTA.setText("");
			}else{
				errorTA.setText("The AddressInfo was not added.");
				messageTA.setText("");
			}//else
			clearInputFields();
		}//if
	}//addClicked

	/**
	 * A method that alphabetically sorts the contact information in the 
	 * database according to the first name, middle name and last name, when 
	 * the user clicks the Alpha Order Display button.
	 */
	public void sortName(){
		messageTA.setText(myCollection.toStringAlphabetical());
		if(myCollection.isEmpty()){
			errorTA.setText("The database is empty.");
			return;
		}//if
		errorTA.setText("");
	}//sortName

	/**
	 * A method that sorts the contact information in the database according 
	 * to the state, city, zipcode, street line and optional line in that
	 *  ascending order, when the user clicks the Address Order Display button. 
	 */
	public void sortAddress(){
		messageTA.setText(myCollection.toStringByAddress());
		if(myCollection.isEmpty()){
			errorTA.setText("The database is empty.");
			return;
		}//if
		errorTA.setText("");
	}//sortAddress

	/**
	 * A method that searches the Database for a contact information when the user
	 * presses the search button. 
	 */
	public void search(){
		String[] nameArray = getUserNames();
		if(checkForEmptyName(nameArray)){
			AddressInfo userInfo = new AddressInfo(nameArray[0], nameArray[1],
					nameArray[2]);
			if(myCollection.search(userInfo) == null){
				errorTA.setText("The Address Info is not in list.");
				messageTA.setText("");
			}else{
				errorTA.setText("");
				messageTA.setText("" + myCollection.search(userInfo));
			}//else
		}//if
		reset();
	}//search

	/**
	 * A method that deletes the contact information in the Database when the user
	 * presses the delete button. 
	 */
	public void delete(){
		String[] nameArray = getUserNames();
		AddressInfo findMe = new AddressInfo(nameArray[0], nameArray[1],
				nameArray[2]);
		if(checkForEmptyName(nameArray)){
			collectionEmpty(findMe);
			tryToSearch(findMe);
		}//if
		clearInputFields();
	}//delete

	/**
	 * A method that confirms can action when the user wants to delete or save 
	 * contact information. 
	 */
	public void confirm() {
		if(processingSave){
			String errmsg = myCollection.saveToFile(fileName);
			errorTA.setText(fileName + " over written.\n"
					+ errmsg + "\n");
			messageTA.setText("");
			processingSave = false;
		}else if(processingDelete){
			if(myCollection.delete(found)){
				messageTA.setText("\n" + found +
						"\n--was deleted.");
				errorTA.setText("");
			}else{
				errorTA.setText("Failure occured in deleting " + found + ".\n");
			}//else
			processingDelete = false;
		}else{
			System.out.println("OK Button being handled at inappropriate time." );
		}//else
		reset();
	}//confirm

	/**
	 * A method that cancels an action when the user does not want to delete or save
	 * contact information. 
	 */
	public void cancel(){
		if(processingSave){
			errorTA.setText("Save request cancelled. " + fileName 
					+ " unchanged.\n");
			processingSave = false;
		}else if(processingDelete){
			errorTA.setText("Delete request cancelled. \n");
			processingDelete = false;
		}else{
			System.out.println("Cancel Button being handled at inappropriate time");
		}//else
		reset();
	}//cancel

	/**
	 * A method that saves the contact information in the database to a file when 
	 * the user presses the save button. 
	 */
	public void save() {
		fileName = fileTF.getText();
		fileTF.setText("");
		String message = "";
		if(fileName.compareTo("") > 0){
			File theFile = new File(fileName);
			if(!theFile.exists()){
				message = myCollection.saveToFile(fileName);
				errorTA.setText("Data saved to file " + fileName+ ".\n"
						+ message + "\n");
			}else if(theFile.isDirectory()){
				errorTA.setText("Error: " + fileName + " is a directory.\n");
			}else if(!theFile.canWrite()){
				errorTA.setText("Cannot write data to " + fileName + "\n");
			}else{
				adjustButtons(false);
				processingSave = true;
				errorTA.setText("\nPress confirm to overwrite file " + 
						fileName + "\nor press Cancel to cancel save request.\n");
				messageTA.setText("");
			}//else
		}else{
			errorTA.setText("You must enter a file name in order to save a file.");
		}//else
		clearInputFields();
	}//save

	/**
	 * A method that loads a file into the database when the user presses the load
	 * button. 
	 */
	public void load(){
		errorTA.setText("");
		fileName = fileTF.getText();
		if(fileName.compareTo("") > 0){
			File theFile = new File(fileName);
			if(!theFile.exists()){
				errorTA.setText(fileName + " does not exist - cannot load data\n");
			}else if(!theFile.canRead()){
				errorTA.setText("Cannot read from " + fileName + "\n");
			}else if(theFile.isDirectory()){
				errorTA.setText(fileName + " is a directory. Please enter" 
						+ " a file name.");
			}else{
				messageTA.append("starting load"+"\n");
				String fromLoad = myCollection.loadFromFile(fileName);
				messageTA.append(fromLoad + " first load" +"\n");
				messageTA.setText("Data loaded from " + fileName + "\n" + "\n"
						+ fromLoad + "\n");
			}//else
			clearInputFields();
		}else{
			errorTA.setText("You must enter a file name " +
					"in order to load a file");
		}//else
	}//load

	public static void main (String args[]) { 
		Database myAppF = new Database(); 
	} //main 

	@Override
	public void actionPerformed(ActionEvent e) {

	}//main
} //Database
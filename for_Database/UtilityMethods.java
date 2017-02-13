package for_Database;
//Gloriane Tran 
//CS 64, Final Project 
//May 13th, 2015
import java.util.*;
//Gloriane Tran
//Assignment #4, Exercise 11.11
//February 19th, 2015
//CS 64

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
/**
 * The Utility Methods class contains methods to make buttons, textfields, labels, text
 * areas, scroll panes. It also has methods that sorts and prints items. 
 * @author gtran
 *
 */
public class UtilityMethods {

	/**
	 * A method that makes a button for a GUI.
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param theText
	 * @param theHandler
	 * @param theCP
	 * @param theEnabled
	 * @return
	 */
	public static JButton makeButton(int theX, int theY, int theWidth, 
			int theHeight, String theText,ActionListener theHandler,
			Container theCP, boolean theEnabled){
		JButton toReturn = new JButton(theText);
		toReturn.setSize(theWidth,theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setEnabled(theEnabled);
		theCP.add(toReturn);
		toReturn.addActionListener(theHandler);
		return toReturn;
	}//makeButton

	/**
	 * A method that makes a text field for a GUI.
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param theCP
	 * @return
	 */
	public static JTextField makeTextField(int theX, int theY, int theWidth,
			int theHeight, Container theCP){
		JTextField toReturn = new JTextField();
		toReturn.setSize(theWidth,theHeight);
		toReturn.setLocation(theX, theY);
		theCP.add(toReturn);
		return toReturn;
	}//makeTextField

	/**
	 * A method that makes a label for a GUI.
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param theText
	 * @param theCP
	 * @return
	 */
	public static JLabel makeJLabel(int theX, int theY, int theWidth,
			int theHeight, String theText, Container theCP){
		JLabel toReturn = new JLabel(theText);
		toReturn.setSize(theWidth,theHeight);
		toReturn.setLocation(theX, theY);
		theCP.add(toReturn);
		return toReturn;
	}//makeJLabel

	/**
	 * A method that makes a text area for a GUI. 
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param theCP
	 * @param theEditable
	 * @return
	 */
	public static JTextArea makeTextArea(int theX, int theY, int theWidth,
			int theHeight, Container theCP, boolean theEditable ){
		JTextArea toReturn = new JTextArea();
		toReturn.setSize(theWidth,theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setEditable(theEditable);
		theCP.add(toReturn);
		return toReturn;
	}//JTextArea

	/**
	 * A method that makes the text area that is not editable for a GUI. 
	 * @param theEditable
	 * @return
	 */
	public static JTextArea makeTextArea2(boolean theEditable){
		JTextArea toReturn = new JTextArea();
		toReturn.setEditable(theEditable);
		return toReturn;
	}//makeTextArea2

	/**
	 * A method that makes a scroll pane for the text area in a GUI. 
	 * @param theX
	 * @param theY
	 * @param theWidth
	 * @param theHeight
	 * @param theCP
	 * @param theTA
	 * @return
	 */
	public static JScrollPane makeScrollPane(int theX, int theY, int theWidth,
			int theHeight, Container theCP, JTextArea theTA){
		JScrollPane toReturn = new JScrollPane(theTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		toReturn.setSize(theWidth,theHeight);
		toReturn.setLocation(theX, theY);
		theCP.add(toReturn);
		return toReturn;
	}//makeScrollPane
	
	/**
	 * Swap is a helper method that swaps the position of items. 
	 * @param theArray
	 * @param firstPos
	 * @param otherPos
	 */
	private static <E> void swap (E[] theArray, int firstPos, int otherPos) {
		E temp = theArray[firstPos];
		theArray[firstPos] = theArray[otherPos];
		theArray[otherPos] = temp;
	}//swap

	/**
	 * A method that sorts the items.
	 * @param theArray
	 * @param theSize
	 */
	public static <E extends Comparable<E>> void 
				sort( E[] theArray,int theSize){
		for(int passNum = 1; passNum < theSize; passNum++) {
			for (int j = 0; j < theSize - passNum; j++) {
				if(theArray[j+1].compareTo(theArray[j])<0) {
					swap(theArray,j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//sort by compareTo

	/**
	 * A method that sorts the array with a comparator that overrides 
	 * the natural ordering of overrides.
	 * @param theArray
	 * @param theSize
	 * @param theComparator
	 */
	public static <E> void 
			sort( E[] theArray,int theSize, Comparator<E> theComparator){
		for(int passNum = 1; passNum < theSize; passNum++) {
			for (int j = 0; j < theSize - passNum; j++) {
				if(theComparator.compare(theArray[j+1],theArray[j])<0) {
					swap(theArray,j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//sort by compareTo
	
	/**
	 * A method that prints every item. 
	 * @param theArray
	 * @param theSize
	 * @return
	 */
	public static <E> String arrayToString(E[] theArray, int theSize){
		String stringToReturn = "";
		for (int j = 0; j < theSize; j++) {
			stringToReturn += theArray [j] + "\n" + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//arrayToString

}//UtilityMethods

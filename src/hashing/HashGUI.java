package hashing;

import BreezySwing.*;
import javax.swing.*;

public class HashGUI extends GBFrame{

	private JButton linear; //Creates table with linear collisions
	private JButton quadratic; //Creates table with quadratic collisions
	private JButton rehash; //Creates table with rehashing collisions
	private JButton bucket; //Creates table with bucket collisions
	private JButton linked; //Creates table with linkedlist collisions
	
	private JLabel inputL; //Tells user where to inputs numbers
	private IntegerField inputF; //Where user inputs numbers
	private JTextArea output; //Outputs data
	private JButton add; //Adds a number to the table
	private JButton search; //Searches for a number
	private JButton print; //Prints a table
	
	private HashTable table;//Holds info for the table
	
	/**
	 * This is the constructor method. 
	 * Instance variables are instantiated. 
	 */
	public HashGUI(){
		
		setSize(400,300);
		setVisible(true);
		
		linear = addButton("Linear",1,1,1,1);
		quadratic = addButton("Quadratic",1,2,1,1);
		rehash = addButton("Rehashing",1,3,1,1);
		bucket = addButton("Bucket",1,4,1,1);
		linked = addButton("Linked",1,5,1,1);
		
		inputL = addLabel("Input",5,1,1,1);
		inputF = addIntegerField(0,5,2,1,1);
		
		output = addTextArea("",2,1,5,3);
		add = addButton("Add",5,3,1,1);
		search = addButton("Search",5,4,1,1);
		print = addButton("Print",5,5,1,1);
		
		setSize(400,300);
		setVisible(true);
		
	}
	
	/**
	 * This method is called when a button is clicked
	 */
	public void buttonClicked(JButton buttonObj){

			
		 if(buttonObj == linear){
			table = new LinearTable();
			disableButtons();
		}else if(buttonObj == quadratic){
			table = new QuadraticTable();
			disableButtons();
		}else if(buttonObj == rehash){
			table = new RehashTable();
			disableButtons();
		}else if(buttonObj == bucket){
			table = new BucketTable();
			disableButtons();
		}else if(buttonObj == linked){
			table = new LinkedTable();
			disableButtons();
		}else if(buttonObj == add){
			table.add(inputF.getNumber());
			inputF.requestFocus(true);
		}else if(buttonObj == search){
			output.setText(table.search(inputF.getNumber()));
		}else if(buttonObj == print){
			output.setText(table.toString());
		}
		 
	}

	/**
	 * This is the main method it creates the actual GUI
	 * @param args
	 */	
	public static void main(String[] args) {
		new HashGUI();
	}
	
	/**
	 * This method disables choice buttons
	 */
	private void disableButtons(){
		linear.setEnabled(false);
		quadratic.setEnabled(false);
		rehash.setEnabled(false);
		bucket.setEnabled(false);
		linked.setEnabled(false);
	}
	
}

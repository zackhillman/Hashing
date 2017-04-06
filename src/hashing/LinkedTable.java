package hashing;

public class LinkedTable implements HashTable{

	
		private LinkedList<Integer> table[];//Holds the integers in the table
		private int count; //holds number of ints in table
		
		/**
		 * This is the constructor method. 
		 * Instance variables are instantiated. 
		 */
		public LinkedTable(){
			table = new LinkedList[12];
			count = 0;
		}

		/**
		 * This method adds integers to the table.
		 * @param- The number being added to the table
		 */
		public void add(Integer num) {
			int index = hash(num);
			if(table[index] == null){
				table[index] = new LinkedList<Integer>();
				count++;
			}
			table[index].addEnd(num);
		}
		
		/**
		 * This method checks the size of the table
		 */
		private void checkTSize(){
			if(count == 0)
				throw new IllegalArgumentException("Table is empty");
		}

		/**
		 * This method searches for a given number
		 * @param- the number to search for
		 * @return- the number of places checked & the number if found
		 */
		public String search(Integer num) {
			checkTSize();
			int index = hash(num);
			return "Found\n Locations Searched: " + table[index].find(num);
		}
		
		/**
		 * This method gets the hash index for a given number
		 * @param- the inputed number
		 * @return- the hash index
		 */
		public int hash(Integer key_value){
			return key_value%12;
		}
		
		/**
		 * This method the string representation of the hash table
		 * @return- the table as a string
		 */
		public String toString(){
			checkTSize();
			String output = "Elements:\n";
			for(int i = 0; i < table.length;i++){
				if(table[i] == null)
					output += i + ": null\n";
				else
					output += i + ": " + table[i].toString() + "\n";
			}
			return output;
		}
	
}

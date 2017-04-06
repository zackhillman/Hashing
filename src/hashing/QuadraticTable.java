package hashing;

public class QuadraticTable implements HashTable{

		private Integer table[];//Holds the integers in the table
		private int count; //holds number of ints in table
		private final int SIZE = 12;
		
		/**
		 * This is the constructor method. 
		 * Instance variables are instantiated. 
		 */
		public QuadraticTable(){
			table = new Integer[12];
			count = 0;
		}

		/**
		 * This method adds integers to the table.
		 * @param- The number being added to the table
		 */
		public void add(Integer num) {
			if(count >= SIZE)
				throw new IllegalArgumentException("Table full");
			int key = hash(num);
			for (int i = 0; i < SIZE; i++) {
		        int index = (key + i*i) % SIZE;
		        if (table[index]==null) {
		            table[index] = num;
		            count++;
		            return;
		        }
		    }
			throw new IllegalArgumentException("Cannot be placed");

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
			int key = hash(num);
			 for (int i = 0; i < SIZE; i++) {
			        int index = (key + i*i) % SIZE;
			        if (table[index]!=null && table[index] == num)
			            return "Found: " + (i+1);
			        if(table[index]==null)
			        		return "Not Found: " + (i+1);
			  }
			    return "Not Found: 12";
		}
		
		/**
		 * This method gets the hash index for a given number
		 * @param- the inputed number
		 * @return- the hash index
		 */
		public int hash(Integer key_value){
			return key_value % table.length;
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

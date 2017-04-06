package hashing;

public class RehashTable implements HashTable{

		private Integer table[];//Holds the integers in the table
		private int count; //holds number of ints in table
		private final int SIZE = 12;
		
		/**
		 * This is the constructor method. 
		 * Instance variables are instantiated. 
		 */
		public RehashTable(){
			table = new Integer[12];
			count = 0;
		}

		/**
		 * This method adds integers to the table.
		 * @param- The number being added to the table
		 */
		public void add(Integer num) {
			if(count >= 12)
				throw new IllegalArgumentException("Table Full");
			int key = hash(num);
	        if (table[key]==null) {
	        	table[key] = num;
	            count++;
	            return;
	        }
	        key = rehash(num);
	        if (table[key]==null){
	        	table[key] = num;
	            count++;
	            return;
	        }
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
		private void checkSize(){
			if(count == 0)
				throw new IllegalArgumentException("Table is empty");
		}

		/**
		 * This method searches for a given number
		 * @param- the number to search for
		 * @return- the number of places checked & the number if found
		 */
		public String search(Integer num) {
			checkSize();
			if(count >= 12)
				throw new IllegalArgumentException("Table Full");
			int counter = 0;
			int key = hash(num);
			counter++;
	        if (table[key]==null) 
	            return "Not Found: " + counter;
	        else if(table[key]==num)
	        	return "Found: " + counter;
	        counter++;
	        key = rehash(num);
	        if (table[key]==null) 
	            return "Not Found: " + counter;
	        else if(table[key]==num)
	        	return "Found: " + counter;
	        for (int i = 0; i < SIZE; i++) {
		        int index = (key + i*i) % SIZE;
		        if (table[index]!=null && table[index] == num)
		            return "Found: " + (i+3);
		        if(table[index]==null)
		        		return "Not Found: " + (i+3);
		  }
		    return "Not Found: 14";
	        
		    
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
		 * This method gets the rehash index for a given number
		 * @param- the inputed number
		 * @return- the rehash index
		 */
		public int rehash(Integer key_value){
			return 3 * key_value % table.length;
		}
		
		/**
		 * This method the string representation of the hash table
		 * @return- the table as a string
		 */
		public String toString(){
			checkSize();
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

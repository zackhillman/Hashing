package hashing;

public class BucketTable implements HashTable{

		private Integer table[];//Holds the integers in the table
		private int count; //Tracks number of ints in table
		private final int bSize; //Size of the bucket
		
		/**
		 * This is the constructor method. 
		 * Instance variables are instantiated. 
		 */
		public BucketTable(){
			table = new Integer[36];
			count = 0;
			bSize = 3;
		}

		/**
		 * This method adds integers to the table.
		 * @param- The number being added to the table
		 */
		public void add(Integer num){
			if(count >= 12)
				throw new IllegalArgumentException("Table is full");
			int index = hash(num);
			while(table[index] != null && table[index] != num)
				index+=3;
			if(index >= 36)
				throw new IllegalArgumentException("Not Added");
			if(table[index] == null)
				count++;
			for(int i = 0; i < bSize; i++){
				if(table[index + i] == null){
					table[index + i] = num;
					return;
				}
			}
			throw new IllegalArgumentException("Specific bucket is full");
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
		public String search(Integer num){
			checkSize();
			int index = hash(num);
			int locations = 0;
			while(table[index] != null && table[index] != num){
				index+=3;
				locations++;
			}
			if(index >= 36)
				return  "Not Found\n Locations Searched: " + locations;
			for(int i = 0; i < bSize; i++){
				if(table[index + i] == null){
					table[index + i] = num;
					locations++;
					return "Found\n Locations Searched: " + locations;
				}
				locations++;
			}
			return "Not Found\n Locations Searched: " + locations;
		}
		
		/**
		 * This method gets the hash index for a given number
		 * @param- the inputed number
		 * @return- the hash index
		 */
		public int hash(Integer key_value){
			return (key_value%(table.length/bSize))*bSize;
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

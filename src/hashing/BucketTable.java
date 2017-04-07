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
		public void add(Integer element) {
			int index = hash(element);
			if(table[index] == null){
				table[index] = element;
				count++;
				return;
			}
			int temp = 1;
			index += temp++;
			while(temp < 3){
				if(table[index] == null){
					table[index] = element;
					count++;
					return;
				}
				index = temp++;
			}
			throw new IllegalArgumentException("Error for too many iterations.");
		}

		/**
		 * This method searches for a given number
		 * @param- the number to search for
		 * @return- the number of places checked & the number if found
		 */
		
		public String search(Integer i) {
			int c = 1;
			int index = hash(i);
			if(table[index] == i){
				return "Item found in " + c + "steps.";
			}
			int temp = 1;
			index += temp++;
			while(temp < 3){
				c++;
				if(table[index] == i){
					return "Item found in " + c + "steps.";
				}
				index += temp++;
			}
			throw new IllegalArgumentException("Error for too many iterations.");
		}
		
		/**
		 * This method checks the size of the table
		 */
		private void checkSize(){
			if(count == 0)
				throw new IllegalArgumentException("Table is empty");
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
				if(i % 3 == 0){
					output += "Bucket: " + (i/3) + "\n";
				}
				if(table[i] == null)
					output += i + ": null\n";
				else
					output += i + ": " + table[i].toString() + "\n";
			}
			return output;
		}
}

package hashing;
public interface HashTable {

	/**
	 * This method adds integers to the table.
	 * @param- The number being added to the table
	 */
	public void add(Integer num);
	
	/**
	 * This method searches for a given number
	 * @param- the number to search for
	 * @return- the number of places checked & the number if found
	 */
	public String search(Integer num);
	
	/**
	 * This method gets the hash index for a given number
	 * @param- the inputed number
	 * @return- the hash index
	 */
	public int hash(Integer key_value);
	
}